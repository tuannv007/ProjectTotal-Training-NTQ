package user;

import java.util.Date;

/**
 * Created by admin on 8/10/2016.
 */
public class User {
    private String email,frd_id,ava_id,last_msg,is_own,sent_time,unread_num,longs,lat,distance,msg_type;
    private String password;
    private String username;
    private String notify_token;
    private int avatar;
    private String birthday;
    private int gender,nameShowme,nameInterred,nameDistance,lower_age,upper_age;
    private boolean isOnline;
    private String token;

    public User() {
    }

    public User(String frd_id, String ava_id, String last_msg, String is_own, String sent_time, String unread_num, String longs, String lat, String distance, String msg_type, String username, int gender, boolean isOnline) {
        this.frd_id = frd_id;
        this.ava_id = ava_id;
        this.last_msg = last_msg;
        this.is_own = is_own;
        this.sent_time = sent_time;
        this.unread_num = unread_num;
        this.longs = longs;
        this.lat = lat;
        this.distance = distance;
        this.msg_type = msg_type;
        this.username = username;
        this.gender = gender;
        this.isOnline = isOnline;
    }

    public int getUpper_age() {
        return upper_age;
    }

    public void setUpper_age(int upper_age) {
        this.upper_age = upper_age;
    }

    public int getLower_age() {
        return lower_age;
    }

    public void setLower_age(int lower_age) {
        this.lower_age = lower_age;
    }

    public int getNameDistance() {
        return nameDistance;
    }

    public void setNameDistance(int nameDistance) {
        this.nameDistance = nameDistance;
    }

    public int getNameInterred() {
        return nameInterred;
    }

    public void setNameInterred(int nameInterred) {
        this.nameInterred = nameInterred;
    }

    public int getNameShowme() {
        return nameShowme;
    }

    public void setNameShowme(int nameShowme) {
        this.nameShowme = nameShowme;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFrd_id() {
        return frd_id;
    }

    public String getAva_id() {
        return ava_id;
    }

    public String getLast_msg() {
        return last_msg;
    }

    public String getIs_own() {
        return is_own;
    }

    public String getSent_time() {
        return sent_time;
    }

    public String getUnread_num() {
        return unread_num;
    }

    public String getLongs() {
        return longs;
    }

    public String getLat() {
        return lat;
    }

    public String getDistance() {
        return distance;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }
    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
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
