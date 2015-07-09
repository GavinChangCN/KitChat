package gavin.kitchat.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.NonWritableChannelException;

import gavin.kitchat.R;
import gavin.kitchat.common.ConstClass;
import gavin.kitchat.dialog.LoadingDialog;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc:
 * Date: 2015-07-09
 * Time: 15:52
 */
public class UpdateManager {

    private Context context ;
    private Dialog loaddialog ;

    // 提示语
    private String updateMsg = "最新版本软件包发布啦，做不更新会死星人！" ;

    // 获取的安装包url
    private String apkUrl = ConstClass.HOSTURL + "Apk/XunTong.apk" ;

    private Dialog noticeDialog ;

    private Dialog downloadDialog ;

    /* 下载包的默认存储地址 */
    private static final String SAVEPATH = "/sdcard/downloads/" ;

    /* 默认的apk文件存储名称 */
    private static final String SAVEFILENAME = SAVEPATH + "XunTong.apk" ;

    /* 进度条与通知UI刷新的Handle和Msg常量 */
    private ProgressBar progressBar ;

    private static final int DOWN_UPDATE = 1 ;

    private static final int DOWN_OVER = 2 ;

    private int progress ;

    private Thread downLoadThread ;

    private boolean interceptFlag = false ;

    // 下载更新晨曦
    private Handler handler = new Handler() {
        public void handleMessage ( Message msg ) {
            switch ( msg.what ) {
                case DOWN_UPDATE:
                    progressBar.setProgress( progress ) ;
                    break ;
                case DOWN_OVER:
                    downloadDialog.hide() ;
                    installApk() ;
                    break ;
                default:
                    break ;
            }
        }
    } ;

    public UpdateManager( Context newContext ) {
        this.context = newContext ;
    }

    // 留出外部接口使得主Activity能够调用
    public void checkUpddateInfo() {
        final String versionName = AppUtils.getVersionName(context) ;
        RequestQueue requestQueue = Volley.newRequestQueue(context) ;
        showDialog() ;
        StringRequest sr = new StringRequest(StringRequest.Method.POST, ConstClass.SERVERURL
                + "GetVersionName", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                // 从服务器获取最新版本信息
                if ( !versionName.equals(s) ) {
                    showNoticeDialog() ;
                } else {
                    T.showShort( context, "软件已经是最新版本" ) ;
                }
                hiddenDialog() ;
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                hiddenDialog() ;
            }
        }) ;
        requestQueue.add( sr ) ;
    }

    // 外部接口使得主Activity能够调用
    public void checkUpdate() {
        final String versionName = AppUtils.getVersionName(context) ;
        RequestQueue requestQueue = Volley.newRequestQueue(context) ;
        StringRequest sr = new StringRequest(StringRequest.Method.POST, ConstClass.SERVERURL
                + "GetVersionName", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                // 从服务器获取最新版本信息
                if (!versionName.equals(s)) {
                    showNoticeDialog();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                hiddenDialog() ;
            }
        });
        requestQueue.add( sr ) ;
    }

    /**
     * 弹出提示更新提示
     */
    private void showNoticeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder( context ) ;
        builder.setTitle( "软件版本更新" ) ;
        builder.setMessage( updateMsg ) ;
        builder.setPositiveButton("下载", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss() ;
                showDownloadDialog() ;
            }
        }) ;
        builder.setNegativeButton( "以后再说", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss() ;
            }
        }) ;
        noticeDialog = builder.create() ;
        noticeDialog.show() ;
    }

    /**
     * 下载弹出框
     */
    private void showDownloadDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder( context ) ;
        builder.setTitle( "软件版本更新" ) ;

        final LayoutInflater inflater = LayoutInflater.from( context ) ;
        View v = inflater.inflate( R.layout.progress, null ) ;
        progressBar = (ProgressBar) v.findViewById( R.id.progress ) ;

        builder.setView(v) ;
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss() ;
                interceptFlag = true ;
            }
        }) ;

        downloadDialog = builder.create() ;
        downloadDialog.show() ;

        downloadApk() ;
    }

    private Runnable downApkRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(apkUrl) ;

                // 建立与服务器的连接，下载服务器
                HttpURLConnection conn = ( HttpURLConnection ) url.openConnection() ;
                conn.connect() ;

                // 文件的Byte长度
                int length = conn.getContentLength() ;
                InputStream is = conn.getInputStream() ;

                // 如果文件夹不存在，新建文件夹
                File file = new File( SAVEPATH ) ;
                if ( !file.exists() ) {
                    file.mkdir() ;
                }

                String apkFileName = SAVEFILENAME ;
                File apkFile =  new File(apkFileName) ;
                FileOutputStream fos = new FileOutputStream(apkFile) ;

                int count = 0 ;
                byte buf[] = new byte[1024] ;

                do {
                    int numread = is.read( buf ) ;
                    count += numread ;
                    // 下载进度显示
                    progress = (int) ( ( ( float ) count / length ) * 100 ) ;

                    // 更新进度
                    handler.sendEmptyMessage(DOWN_UPDATE) ;
                    if ( numread <= 0 ) {
                        // 下载完成，通知安装选择
                        handler.sendEmptyMessage(DOWN_OVER) ;
                        break ;
                    }
                    fos.write( buf, 0, numread ) ;
                } while ( !interceptFlag ) ; // 点击取消，停止下载

                fos.close() ;
                is.close() ;
            } catch ( MalformedURLException e ) {
                e.printStackTrace() ;
            } catch ( IOException e ) {
                e.printStackTrace() ;
            }
        }
    };

    /**
     * 下载apk
     */
    private void downloadApk() {
        downLoadThread = new Thread(downApkRunnable) ;
        downLoadThread.start() ;
    }

    /**
     * 安装apk
     */
    private void installApk() {
        File apkfile = new File( SAVEFILENAME ) ;
        if( !apkfile.exists() ) {
            return ;
        }
        Intent i = new Intent(Intent.ACTION_VIEW) ;
        i.setDataAndType(Uri.parse( "file://" + apkfile.toString()),
                "application/vnd.android.package-archive" ) ;
        context.startActivity(i);
    }


    private void showDialog() {
        if ( loaddialog == null ) {
            loaddialog = LoadingDialog.createLoadingDialog( context, "正在加载，请稍后...", true ) ;
            loaddialog.show() ;
        } else {
            loaddialog.dismiss() ;
            loaddialog = LoadingDialog.createLoadingDialog( context, "正在加载，请稍后...", true ) ;
            loaddialog.show() ;
        }
    }

    private void hiddenDialog() {
        if ( loaddialog != null ) {
            loaddialog.dismiss() ;
            loaddialog = null ;
        }
    }
}
