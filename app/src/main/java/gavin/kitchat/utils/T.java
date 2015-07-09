package gavin.kitchat.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc: 封装Toast的文件
 * Date: 2015-07-09
 * Time: 21:27
 */
public class T {

    public T() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true ;

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort( Context context, CharSequence message ) {
        if ( isShow ) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort( Context context, Integer message ) {
        if ( isShow ) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong( Context context, CharSequence message ) {
        if ( isShow ) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong( Context context, Integer message ) {
        if ( isShow ) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, CharSequence message, int duration)
    {
        if (isShow)
            Toast.makeText(context, message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, Integer message, int duration)
    {
        if (isShow)
            Toast.makeText(context, message, duration).show();
    }
}
