package gavin.kitchat.utils;

import android.support.v7.internal.view.menu.MenuDialogHelper;
import android.util.Log;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc: 封装Log方法的文件
 * Date: 2015-07-09
 * Time: 21:38
 */
public class L {

    public L() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    // 是否需要打印BUG，可以在application的onCreate函数里面初始化
    public static boolean isDebug = true ;
    private static final String TAG = "way" ;

    // 下面四个是默认TAG的函数
    public static void i ( String msg ) {
        if ( isDebug )
            Log.i(TAG, msg) ;
    }

    public static void d ( String msg ) {
        if ( isDebug )
            Log.d( TAG, msg ) ;
    }

    public static void e ( String msg ) {
        if ( isDebug )
            Log.e( TAG, msg ) ;
    }

    public static void v ( String msg ) {
        if ( isDebug )
            Log.v( TAG, msg ) ;
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void e(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void v(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }
}
