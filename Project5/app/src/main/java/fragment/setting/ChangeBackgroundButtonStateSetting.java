package fragment.setting;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.Button;

import fragment.base.BaseApiFragment;

import static com.example.admin.project1final.R.drawable.background_search_setting;
import static com.example.admin.project1final.R.drawable.background_world;

/**
 * Created by admin on 7/19/2016.
 */
public abstract class ChangeBackgroundButtonStateSetting extends BaseApiFragment {
    public Boolean isChecked = true;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void changeBackgroundSearchSetting(Button button, int myDrawable) {
        if (isChecked) {
            button.setTextColor(Color.WHITE);
            button.setBackground(getResources().getDrawable(background_world));
            Drawable images = getResources().getDrawable(myDrawable);
            button.setCompoundDrawablesRelativeWithIntrinsicBounds(null, images, null, null);
        } else {
            button.setTextColor(Color.BLACK);
            button.setBackground(getResources().getDrawable(background_search_setting));
            Drawable images = getResources().getDrawable(myDrawable);
            button.setCompoundDrawablesRelativeWithIntrinsicBounds(null, images, null, null);
        }


    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void resetBackground(Button button, int myDrawable) {
        button.setTextColor(Color.BLACK);
        button.setBackground(getResources().getDrawable(background_search_setting));
        Drawable images = getResources().getDrawable(myDrawable);
        button.setCompoundDrawablesRelativeWithIntrinsicBounds(null, images, null, null);
    }
}
