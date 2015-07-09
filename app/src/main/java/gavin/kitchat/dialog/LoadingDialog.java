package gavin.kitchat.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import gavin.kitchat.R;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc: 公用的消息框设计
 * Date: 2015-07-09
 * Time: 17:06
 */
public class LoadingDialog {
    private static Dialog dialog ;

    /**
     * 得到自定义的progressDialog
     * @param context
     * @param msg
     * @param iscancel
     * @return
     */
    public static Dialog createLoadingDialog( Context context, String msg, boolean iscancel ) {

        // 首先得到整个View
        View view = LayoutInflater.from(context).inflate(
                R.layout.loading_dialog_view, null ) ;

        // 获取整个布局
        LinearLayout layout = (LinearLayout) view
                .findViewById( R.id.dialog_view ) ;

        // 页面中的Img
        ImageView img = (ImageView) view.findViewById( R.id.img ) ;

        // 页面中显示的文本
        TextView tipText = (TextView) view.findViewById( R.id.tipTextView ) ;

        // 加载动画，使img不停地旋转
        Animation animation = AnimationUtils.loadAnimation( context,
                R.anim.dialog_load_animation) ;

        // 显示动画
        img.startAnimation(animation) ;

        // 显示文本
        tipText.setText(msg) ;

        // 创建自定义样式的Dialog
        Dialog loadingDialog = new Dialog( context, R.style.loading_dialog ) ;

        // 设置返回键无效
        loadingDialog.setCancelable( iscancel ) ;
        loadingDialog.setContentView( layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));

        return loadingDialog ;
    }

    public static void showDialog( Context context , boolean iscancel ) {
        dialog = LoadingDialog.createLoadingDialog( context, "正在加载，请稍后...", iscancel) ;
        dialog.show() ;
    }

    public static void hiddenDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }

    }
}
