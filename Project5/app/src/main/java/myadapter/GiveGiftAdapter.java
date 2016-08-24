package myadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import my.item.ItemGiveGift;

/**
 * Created by admin on 8/4/2016.
 */
public class GiveGiftAdapter extends RecyclerView.Adapter<GiveGiftAdapter.ViewHolderGift> {
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    private ArrayList<ItemGiveGift> arrayList = new ArrayList<>();

    public GiveGiftAdapter(ArrayList<ItemGiveGift> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolderGift onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.item_give_gift_layout, parent, false);
        return new ViewHolderGift(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderGift holder, int position) {
        ItemGiveGift itemGiveGift = arrayList.get(position);
        if (itemGiveGift != null)
            holder.nameGift.setText(itemGiveGift.getNameGift());
    }

    @Override
    public int getItemCount() {
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    class ViewHolderGift extends RecyclerView.ViewHolder {
        private TextView nameGift;

        public ViewHolderGift(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view, getPosition());
                }
            });
            nameGift = (TextView) itemView.findViewById(R.id.txt_give_gift);
        }
    }
}
