package my.item;

import android.widget.ImageView;

/**
 * Created by admin on 8/2/2016.
 */
public class ItemNotification {
    private int imvImages,imvLocation,imvTime,imvChange;
    private String txtTextMain,txtHere,txtTime;

    public ItemNotification(String txtHere, String txtTime) {
        this.txtHere = txtHere;
        this.txtTime = txtTime;
    }

    public int getImvImages() {
        return imvImages;
    }

    public void setImvImages(int imvImages) {
        this.imvImages = imvImages;
    }

    public int getImvLocation() {
        return imvLocation;
    }

    public void setImvLocation(int imvLocation) {
        this.imvLocation = imvLocation;
    }

    public int getImvTime() {
        return imvTime;
    }

    public void setImvTime(int imvTime) {
        this.imvTime = imvTime;
    }

    public int getImvChange() {
        return imvChange;
    }

    public void setImvChange(int imvChange) {
        this.imvChange = imvChange;
    }

    public String getTxtTextMain() {
        return txtTextMain;
    }

    public void setTxtTextMain(String txtTextMain) {
        this.txtTextMain = txtTextMain;
    }

    public String getTxtHere() {
        return txtHere;
    }

    public void setTxtHere(String txtHere) {
        this.txtHere = txtHere;
    }

    public String getTxtTime() {
        return txtTime;
    }

    public void setTxtTime(String txtTime) {
        this.txtTime = txtTime;
    }
}
