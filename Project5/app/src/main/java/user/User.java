package user;

import java.util.Date;

/**
 * Created by admin on 8/10/2016.
 */
public class User {
    private String email,password,username,notify_token;
    private String birthday;
    private int gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public String getNotify_token() {
        return notify_token;
    }

    public void setNotify_token(String notify_token) {
        this.notify_token = notify_token;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
