package gavin.kitchat;

import android.app.Activity;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc:
 * Date: 2015-07-09
 * Time: 15:37
 */
public class BaseActivity extends Activity {
    private long exitTime = 0 ;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN ) {
            // 如果2秒内连续单击返回，则退出程序
            if ( (System.currentTimeMillis()-exitTime) > 2000 ) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish() ;
                System.exit(0) ;
            }
            return true ;
        }
        return super.onKeyDown(keyCode, event);
    }
}
