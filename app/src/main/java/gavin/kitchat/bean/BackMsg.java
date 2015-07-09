package gavin.kitchat.bean;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc:
 * Date: 2015-07-09
 * Time: 14:43
 */
public class BackMsg {
    private boolean status = false ;
    private int code = 0 ;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
