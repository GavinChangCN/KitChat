package gavin.kitchat.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc: 获取服务器路径的常量文件
 * Date: 2015-07-09
 * Time: 15:57
 */
public class ConstClass {
    public final static String HOSTURL = "http://www.boguedu.cn/xuntong" ;
    public final static String SERVERURL = "http://www.boguedu.cn/xuntong" ;

    // 判断手机号码格式时候正确
    public static boolean isMobile( String mobileNum ) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,5-9]))\\d{8}$") ;
        Matcher m = p.matcher( mobileNum ) ;
        return m.matches() ;
    }
}
