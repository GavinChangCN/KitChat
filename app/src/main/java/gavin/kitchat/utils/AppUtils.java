package gavin.kitchat.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc: 与APP安装相关的辅助类
 * Date: 2015-07-09
 * Time: 16:46
 */
public class AppUtils {

    public AppUtils() {
        /* 无法初始化 */
        throw new UnsupportedOperationException("cannot be instantiated" ) ;
    }

    /**
     * 获取应用程序的名称
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager() ;
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0) ;
            int labelRes = packageInfo.applicationInfo.labelRes ;
            return context.getResources().getString(labelRes) ;
        } catch ( PackageManager.NameNotFoundException e ) {
            e.printStackTrace() ;
        }
        return null ;
    }

    /**
     * 获取应用程序的版本名称信息
     *
     * @param context
     * @return 当前App的版本名称
     */
    public static String getVersionName( Context context ) {
        try {
            PackageManager pm = context.getPackageManager() ;
            PackageInfo packageInfo = pm.getPackageInfo( context.getPackageName(), 0 ) ;
            return packageInfo.versionName ;
        } catch ( PackageManager.NameNotFoundException e ) {
            e.printStackTrace() ;
        }
        return null ;
    }
}
