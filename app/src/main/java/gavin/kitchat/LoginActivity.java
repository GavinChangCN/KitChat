package gavin.kitchat;


import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc:
 * Date: 2015-07-09
 * Time: 15:34
 */
public class LoginActivity extends BaseActivity {
    private Button loginBtn ;
    private TextView txtReg ;
    private EditText editUserName ;
    private EditText editUserPwd ;
    private Dialog loaddialog ;
    private RequestQueue requestQueue ;
    public final static String TAG = "LoginActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去除标题栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE) ;
        setContentView( R.layout.activity_login ) ;
        // 窗体获得焦点就会隐藏小键盘
        getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN ) ;
        initViews() ;

    }
}
