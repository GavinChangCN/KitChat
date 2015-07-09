package gavin.kitchat.utils;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc: 应用程序运行规范
 * Date: 2015-07-09
 * Time: 21:44
 */
public class AppManager {
    private List<Activity> activityList = new LinkedList<Activity>() ;
    private static AppManager instance ;

    private AppManager(){}

    /**
     * 单一实例
     * @return
     */
    public static AppManager getAppManager() {
        if ( instance == null ) {
            instance = new AppManager() ;
        }
        return instance ;
    }

    /**
     * 添加Activity到堆栈
     * @param activity
     */
    public void addActivity( Activity activity ) {
        activityList.add( activity ) ;
    }

    /**
     * 结束指定的Activity
     * @param activity
     */
    public void finishActivity( Activity activity ) {
        if( activity != null ) {
            activityList.remove( activity ) ;
            activity.finish() ;
            activity = null ;
        }
    }

    public void finishAllActivity() {
        while ( activityList.size() > 0 ) {
            Activity activity = activityList.get( activityList.size() - 1 ) ;
            activityList.remove( activityList.size() - 1 ) ;
            activity.finish() ;
        }
    }
    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            finishAllActivity() ;
        } catch ( Exception e ) {

        }
    }
}
