package gavin.kitchat.utils;

import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import gavin.kitchat.R;
import gavin.kitchat.common.ConstClass;

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
    private String apkUrl = ConstClass.HOSTURL + "apk/XunTong.apk" ;

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
    }
    LayoutInflater inflater = LayoutInflater.from(context) ;
    View v = inflater.inflate(R.layout.progress, null) ;

    private void showDialog() {
        if ( loaddialog == null ) {
            loaddialog = LOadin
        }
    }
}
