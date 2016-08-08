package my.item;

import android.widget.ImageView;

/**
 * Created by admin on 8/4/2016.
 */
public class ItemGiveGift {
    private String nameGift;
    private int imageGift;

    public ItemGiveGift(String nameGift) {
        this.nameGift = nameGift;
    }

    public ItemGiveGift(String nameGift, int imageGift) {
        this.nameGift = nameGift;
        this.imageGift = imageGift;
    }

    public String getNameGift() {
        return nameGift;
    }

    public int getImageGift() {
        return imageGift;
    }
}
