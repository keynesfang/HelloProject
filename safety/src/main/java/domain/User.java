package domain;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User {
    private Integer userid;

    private String username;

    private String userpass;

    private String userright;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getUserright() {
        return userright;
    }

    public void setUserright(String userright) {
        this.userright = userright;
    }
}