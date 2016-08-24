package myadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import my.item.ItemGiveGift;

/**
 * Created by admin on 8/4/2016.
 */
public class AllAdapter extends RecyclerView.Adapter<AllAdapter.ViewHolderAll> {


    private ArrayList<ItemGiveGift> arrItemAll = new ArrayList<>();

    public AllAdapter(ArrayList<ItemGiveGift> arrItemAll) {
        this.arrItemAll = arrItemAll;
    }

    @Override
    public ViewHolderAll onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.item_all_layout, parent, false);
        return new ViewHolderAll(view);
    }

    @Override
    public int getItemCount() {
        if (arrItemAll != null) return arrItemAll.size();
        return 0;
    }

    @Override
    public void onBindViewHolder(ViewHolderAll holder, int position) {
        ItemGiveGift itemPosition = arrItemAll.get(position);
        holder.imvImage.setImageResource(itemPosition.getImageGift());
        holder.price.setText(itemPosition.getNameGift());
    }

    class ViewHolderAll extends RecyclerView.ViewHolder {
        private TextView price;
        private ImageView imvImage;

        public ViewHolderAll(View itemView) {
            super(itemView);
            price = (TextView) itemView.findViewById(R.id.txt_all_text);
            imvImage = (ImageView) itemView.findViewById(R.id.imv_all_image);
        }
    }


}
