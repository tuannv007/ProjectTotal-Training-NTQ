package my.item;

import android.widget.ImageView;

/**
 * Created by admin on 7/27/2016.
 */
public class ItemSearchFriendListview {
    private int Avata, phay, gender, locator, imvStatus;
    private String name, content, age, distance, status;
    private String txtContentRecever, txtContentSend, txtTime, txtContentLocation;
    private int imvTime;
    private int imvDelete;
    private int imvNotification;
    private String txtNumberNotification;



    private boolean isOnline;


    public ItemSearchFriendListview(int avata, String status, int imvStatus, String name, String content, String age, String distance, int imvNotification, String txtNumberNotification) {
        Avata = avata;
        this.status = status;
        this.imvStatus = imvStatus;
        this.name = name;
        this.content = content;
        this.age = age;
        this.distance = distance;
        this.imvNotification = imvNotification;
        this.txtNumberNotification = txtNumberNotification;
    }

    public ItemSearchFriendListview(int avata, String txtContentLocation, String txtTime, String txtContentSend, String txtContentRecever, boolean isOnline, String name) {
        this.Avata = avata;
        this.txtContentLocation = txtContentLocation;
        this.txtTime = txtTime;
        this.txtContentSend = txtContentSend;
        this.txtContentRecever = txtContentRecever;
        this.name = name;
        this.isOnline = isOnline;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public int getImvNotification() {
        return imvNotification;
    }


    public String getTxtNumberNotification() {
        return txtNumberNotification;
    }
    public String getTxtContentLocation() {
        return txtContentLocation;
    }
    public String getTxtContentRecever() {
        return txtContentRecever;
    }
    public String getTxtContentSend() {
        return txtContentSend;
    }
    public String getTxtTime() {
        return txtTime;
    }
    public int getAvata() {
        return Avata;
    }
    public String getStatus() {
        return status;
    }
    public int getImvStatus() {
        return imvStatus;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAge() {
        return age;
    }


    public String getDistance() {
        return distance;
    }


}
