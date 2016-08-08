package myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import my.item.ItemSearchFriendListview;

/**
 * Created by admin on 7/27/2016.
 */
public class SearchFriendAdapterGrirdView extends ArrayAdapter {
    private ArrayList<ItemSearchFriendListview> arrItem = new ArrayList<>();
    private LayoutInflater mInflater;

    public SearchFriendAdapterGrirdView(Context context, int resource, ArrayList<ItemSearchFriendListview> objects) {
        super(context, resource, objects);
        arrItem = objects;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_layout_grirdview, parent, false);
            viewHolder.imvAvata = (ImageView) convertView.findViewById(R.id.imv_avata);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txt_name);
            viewHolder.imvPoint = (ImageView) convertView.findViewById(R.id.imv_point);
            viewHolder.imvNotification = (ImageView) convertView.findViewById(R.id.imv_notification_grird);
            viewHolder.txtNumberNotification = (TextView) convertView.findViewById(R.id.txt_number_notification);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        ItemSearchFriendListview objectItem = (ItemSearchFriendListview) getItem(position);
        viewHolder.imvNotification.setImageResource(objectItem.getImvNotification());
        viewHolder.txtNumberNotification.setText(objectItem.getTxtNumberNotification());
        if (objectItem.getTxtNumberNotification().toString().isEmpty()) {
            viewHolder.imvNotification.setVisibility(View.INVISIBLE);
        }else{
            viewHolder.imvNotification.setVisibility(View.VISIBLE);
        }

        viewHolder.imvPoint.setImageResource(objectItem.getImvStatus());
        viewHolder.imvAvata.setImageResource(objectItem.getAvata());
        viewHolder.txtName.setText(objectItem.getName());
        return convertView;
    }

    class ViewHolder {
        private ImageView imvAvata, imvPoint, imvNotification;
        private TextView txtName, txtNumberNotification;
    }
}
