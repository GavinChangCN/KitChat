package gavin.kitchat.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc:
 * Date: 2015-07-09
 * Time: 14:14
 */
public class MsgBean implements Parcelable {

    private String num ;
    private String title ;
    private String url ;
    private String univerName ;
    private String collegeName ;
    private String time ;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUniverName() {
        return univerName;
    }

    public void setUniverName(String univerName) {
        this.univerName = univerName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(num);
        parcel.writeString(title);
        parcel.writeString(url);
        parcel.writeString(univerName);
        parcel.writeString(collegeName);
        parcel.writeString(time);
    }
    protected MsgBean(Parcel in) {
        num = in.readString();
        title = in.readString();
        url = in.readString();
        univerName = in.readString();
        collegeName = in.readString();
        time = in.readString();
    }

    public static final Creator<MsgBean> CREATOR = new Creator<MsgBean>() {
        @Override
        public MsgBean createFromParcel(Parcel in) {
            return new MsgBean(in);
        }

        @Override
        public MsgBean[] newArray(int size) {
            return new MsgBean[size];
        }
    };

}
