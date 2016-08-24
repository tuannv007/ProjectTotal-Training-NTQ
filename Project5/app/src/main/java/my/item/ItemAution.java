package my.item;

/**
 * Created by admin on 8/1/2016.
 */
public class ItemAution {
    private int imvAvatar, imvStatus;
    private String txtName;
    private boolean isOnline = true;

    public ItemAution(int imvAvatar, String txtName, boolean isOnline) {
        this.imvAvatar = imvAvatar;
        this.txtName = txtName;
        this.isOnline = isOnline;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public int getImvAvatar() {
        return imvAvatar;
    }


    public int getImvStatus() {
        return imvStatus;
    }


    public String getTxtName() {
        return txtName;
    }


}
