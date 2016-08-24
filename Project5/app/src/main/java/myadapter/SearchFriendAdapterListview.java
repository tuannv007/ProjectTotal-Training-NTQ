package myadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import my.item.ItemSearchFriendListview;

/**
 * Created by admin on 7/27/2016.
 */
public class SearchFriendAdapterListview extends BaseAdapter {
    protected ArrayList<ItemSearchFriendListview> arrItem = new ArrayList<>();
    protected Context mContext;
    private LayoutInflater mInflater;

    public SearchFriendAdapterListview(Context mContext, ArrayList<ItemSearchFriendListview> arrItem) {
        this.mContext = mContext;
        this.arrItem = arrItem;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrItem.size();
    }

    @Override
    public Object getItem(int position) {
        return arrItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.item_layout_listview, parent, false);
            viewHolder.imvAvata = (ImageView) view.findViewById(R.id.imv_avata_list);
            viewHolder.imvPhai = (ImageView) view.findViewById(R.id.imv_doublephai);
            viewHolder.imvLocator = (ImageView) view.findViewById(R.id.imv_location);
            viewHolder.txtName = (TextView) view.findViewById(R.id.txt_name_listview);
            viewHolder.txtContent = (TextView) view.findViewById(R.id.txt_content_list);
            viewHolder.txtAge = (TextView) view.findViewById(R.id.txt_age_listview);
            viewHolder.txtDistance = (TextView) view.findViewById(R.id.txt_distance_list);
            viewHolder.txtStatus = (TextView) view.findViewById(R.id.txt_sttatus_list);
            viewHolder.imvNotificationList = (ImageView) view.findViewById(R.id.imv_notification_list);
            viewHolder.txtNumberNotification = (TextView) view.findViewById(R.id.txt_number_notification_list);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imvAvata.setImageResource(arrItem.get(position).getAvata());
        viewHolder.imvLocator.setImageResource(R.drawable.ic_fragment_share_buzz_location);
        viewHolder.imvPhai.setImageResource(R.drawable.ic_status);
        viewHolder.txtName.setText(arrItem.get(position).getName());
        viewHolder.txtAge.setText(arrItem.get(position).getAge());
        viewHolder.txtContent.setText(arrItem.get(position).getContent());
        viewHolder.txtDistance.setText(arrItem.get(position).getDistance());
        viewHolder.txtStatus.setText(arrItem.get(position).getStatus());
        viewHolder.imvNotificationList.setImageResource(arrItem.get(position).getImvNotification());
        viewHolder.txtNumberNotification.setText(arrItem.get(position).getTxtNumberNotification());
        if (viewHolder.txtStatus.getText().toString().equals("online")) {
            viewHolder.txtStatus.setTextColor(Color.BLUE);
        }
        if (viewHolder.txtNumberNotification.getText().toString().isEmpty()) {
            viewHolder.imvNotificationList.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.imvNotificationList.setVisibility(View.VISIBLE);
        }
        return view;
    }

    class ViewHolder {
        private ImageView imvAvata, imvPhai, imvLocator, imvNotificationList;
        private TextView txtName, txtContent, txtAge, txtDistance, txtStatus, txtNumberNotification;
    }
}
