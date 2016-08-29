package myadapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.project1final.R;

/**
 * Created by admin on 7/27/2016.
 */
public class WelcomeAdapter extends PagerAdapter {
    private int image[];
    private LayoutInflater mLayoutInflater;

    public WelcomeAdapter(Context mContext, int[] image) {
        this.image = image;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_wellcome, null);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imv_images);
        imageView.setImageResource(image[position]);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);

    }
}
