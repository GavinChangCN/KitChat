package gavin.kitchat.bean;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc:
 * Date: 2015-07-09
 * Time: 14:44
 */
public class College {
    private Integer id ;
    private Integer uid ;
    private String univerNum ;
    private String collegeNum ;
    private String collegeName ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUniverNum() {
        return univerNum;
    }

    public void setUniverNum(String univerNum) {
        this.univerNum = univerNum;
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
}
