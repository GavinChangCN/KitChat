package gavin.kitchat.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc:
 * Date: 2015-07-09
 * Time: 14:48
 */
public class UserInfo implements Parcelable {
    private String userNum ;
    private String userName ;
    private String realName ;
    private String mobilePhone ;
    private String univerNum ;
    private String univerName ;
    private String collegeNum ;
    private String collegeName ;
    private String message ;
    private Integer power ;
    private boolean status ;

    protected UserInfo(Parcel in) {
        userNum = in.readString();
        userName = in.readString();
        realName = in.readString();
        mobilePhone = in.readString();
        univerNum = in.readString();
        univerName = in.readString();
        collegeNum = in.readString();
        collegeName = in.readString();
        message = in.readString();
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getUniverNum() {
        return univerNum;
    }

    public void setUniverNum(String univerNum) {
        this.univerNum = univerNum;
    }

    public String getUniverName() {
        return univerName;
    }

    public void setUniverName(String univerName) {
        this.univerName = univerName;
    }

    public String getCollegeNum() {
        return collegeNum;
    }

    public void setCollegeNum(String collegeNum) {
        this.collegeNum = collegeNum;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userNum);
        parcel.writeString(userName);
        parcel.writeString(realName);
        parcel.writeString(mobilePhone);
        parcel.writeString(univerNum);
        parcel.writeString(univerName);
        parcel.writeString(collegeNum);
        parcel.writeString(collegeName);
        parcel.writeString(message);
    }
}
