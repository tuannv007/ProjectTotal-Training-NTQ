package myadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import my.item.ItemNotification;

/**
 * Created by admin on 8/2/2016.
 */
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.RecyclerViewHolder> {
    private ArrayList<ItemNotification> arrayList = new ArrayList<>();

    public NotificationAdapter(ArrayList<ItemNotification> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
       View itemView= mInflater.inflate(R.layout.item_notification,parent,false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.txtTime.setText(arrayList.get(position).getTxtTime());
        holder.txtTextMain.setText(R.string.confgurationNotifice);
        holder.txtHere.setText(arrayList.get(position).getTxtHere());
        holder.imvTime.setImageResource(R.drawable.ic_fragment_share_buzz_time);
        holder.imvLocation.setImageResource(R.drawable.ic_fragment_share_buzz_location);
        holder.imvImages.setImageResource(R.drawable.ic_look_at_me);
        holder.imvChange.setImageResource(R.drawable.edit_my_profile_arrow_right);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView imvImages,imvLocation,imvTime,imvChange;
        private TextView txtTextMain,txtHere,txtTime;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imvChange = (ImageView) itemView.findViewById(R.id.imv_noti_chage);
            imvImages = (ImageView) itemView.findViewById(R.id.imv_noti_images);
            imvLocation = (ImageView) itemView.findViewById(R.id.imv_noti_location);
            imvTime = (ImageView) itemView.findViewById(R.id.imv_noti_time);
            txtHere = (TextView) itemView.findViewById(R.id.txt_noti_here);
            txtTextMain = (TextView) itemView.findViewById(R.id.txt_noti_content);
            txtTime = (TextView) itemView.findViewById(R.id.txt_noti_time);
        }
    }
}
