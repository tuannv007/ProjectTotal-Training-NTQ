package myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import my.item.ItemSearchFriendListview;
import toantk.entities.User;

/**
 * Created by admin on 7/29/2016.
 */
public class ChatContentAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ItemSearchFriendListview> arrayList = new ArrayList<>();
    public ViewHolderChatContent viewHolder;
    public boolean isDelete = false;

    public ChatContentAdapter(Context context, ArrayList<ItemSearchFriendListview> objects) {
        this.mContext = context;
        arrayList = objects;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        if (arrayList == null) return 0;
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        if (arrayList != null)
            return arrayList.get(position);
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        if (view == null) {
            view = mInflater.inflate(R.layout.item_chat_layout, parent, false);
            viewHolder = new ViewHolderChatContent();
            viewHolder.imvAvatar = (ImageView) view.findViewById(R.id.imv_avata_chat);
            viewHolder.imvStatus = (ImageView) view.findViewById(R.id.imv_point_chat);
            viewHolder.imvLocation = (ImageView) view.findViewById(R.id.imv_location_chat);
            viewHolder.imvTime = (ImageView) view.findViewById(R.id.imv_time_chat);
            viewHolder.txtContentReciver = (TextView) view.findViewById(R.id.txt_content_reciver_chat);
            viewHolder.txtContentSend = (TextView) view.findViewById(R.id.txt_content_send_chat);
            viewHolder.txtLocation = (TextView) view.findViewById(R.id.txt_content_location_chat);
            viewHolder.txtName = (TextView) view.findViewById(R.id.txt_name_chat);
            viewHolder.txtTime = (TextView) view.findViewById(R.id.txt_content_time_chat);
            viewHolder.btnDelete = (Button) view.findViewById(R.id.btn_delete_chat);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderChatContent) view.getTag();


        }
        ItemSearchFriendListview positionItem = arrayList.get(position);
        viewHolder.imvAvatar.setImageResource(positionItem.getAvata());
        viewHolder.imvTime.setImageResource(R.drawable.ic_menu_item_time_range);
        viewHolder.imvLocation.setImageResource(R.drawable.ic_menu_item_distance);
        if (positionItem.isOnline()) {
            viewHolder.imvStatus.setImageResource(R.drawable.ic_status_online_grid_view);
        } else {
            viewHolder.imvStatus.setImageResource(R.drawable.ic_menu_item_offline);
        }
        viewHolder.txtTime.setText(arrayList.get(position).getTxtTime());
        viewHolder.txtName.setText(arrayList.get(position).getName());
        viewHolder.txtLocation.setText(arrayList.get(position).getTxtContentLocation());
        viewHolder.txtContentSend.setText(arrayList.get(position).getTxtContentSend());
        viewHolder.txtContentReciver.setText(arrayList.get(position).getTxtContentRecever());

        if (viewHolder.txtContentSend.getText().toString().isEmpty()) {
            viewHolder.txtContentSend.setVisibility(View.GONE);
            viewHolder.txtContentReciver.setWidth(2000);
        } else {
            viewHolder.txtContentSend.setVisibility(View.VISIBLE);

        }
        if (viewHolder.txtContentReciver.getText().toString().isEmpty()) {
            viewHolder.txtContentReciver.setVisibility(View.GONE);

        } else {
            viewHolder.txtContentReciver.setVisibility(View.VISIBLE);

        }
        if (!isDelete) {
            viewHolder.btnDelete.setVisibility(View.GONE);
        } else {
            viewHolder.btnDelete.setVisibility(View.VISIBLE);
        }
        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(arrayList.get(position));
                notifyDataSetChanged();
            }
        });
        return view;
    }

    public static class ViewHolderChatContent {
        private Button btnDelete;
        private ImageView imvAvatar, imvStatus, imvLocation, imvTime;
        private TextView txtContentReciver, txtContentSend, txtLocation, txtTime, txtName;


    }
}
