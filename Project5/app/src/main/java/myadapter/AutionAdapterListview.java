package myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import my.item.RowFour;
import my.item.RowTwo;
import my.item.ViewRows;

/**
 * Created by admin on 8/3/2016.
 */
public class AutionAdapterListview extends BaseAdapter {
    private static final int TYPE_TWO = 0;
    private static final int TYPE_FOUR = 1;
    private static final int TYPE_FIVE = 2;
    private ArrayList<ViewRows> arrViewRows = new ArrayList<>();
    private Context mContext;

    public AutionAdapterListview(ArrayList<ViewRows> arrViewRows, Context mContext) {
        this.arrViewRows = arrViewRows;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        if (arrViewRows != null)
            return arrViewRows.size();
        else return 0;
    }

    @Override
    public Object getItem(int i) {
        return arrViewRows.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (arrViewRows.get(position) instanceof RowTwo) {
            return TYPE_TWO;

        } else if (arrViewRows.get(position) instanceof RowFour) {
            return TYPE_FOUR;

        } else {
            return TYPE_FIVE;
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        int type = getItemViewType(position);
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            viewHolder = new ViewHolder();
            switch (type) {
                case TYPE_TWO:
                    view = mInflater.inflate(R.layout.item_list_two_aution, viewGroup,false);
                    viewHolder.imvAvatar = (ImageView) view.findViewById(R.id.imv_avatar_au1);
                    viewHolder.imvStatus = (ImageView) view.findViewById(R.id.imv_point_au1);
                    viewHolder.txtName = (TextView) view.findViewById(R.id.txt_au1);

                    viewHolder.imvAvatar2 = (ImageView) view.findViewById(R.id.imv_avatar_au2);
                    viewHolder.imvStatus2 = (ImageView) view.findViewById(R.id.imv_point_au2);
                    viewHolder.txtName2 = (TextView) view.findViewById(R.id.txt_au2);


                    view.setTag(viewHolder);
                    break;
                case TYPE_FOUR:
                    view = mInflater.inflate(R.layout.item_list_four_aution, viewGroup, false);
                    viewHolder.imvAvatar = (ImageView) view.findViewById(R.id.imv_avatar_four_au1);
                    viewHolder.imvStatus = (ImageView) view.findViewById(R.id.imv_point_four_au1);
                    viewHolder.txtName = (TextView) view.findViewById(R.id.txt_four_au1);


                    viewHolder.imvAvatar2 = (ImageView) view.findViewById(R.id.imv_avatar_four_au2);
                    viewHolder.imvStatus2 = (ImageView) view.findViewById(R.id.imv_point_four_au2);
                    viewHolder.txtName2 = (TextView) view.findViewById(R.id.txt_four_au2);


                    viewHolder.imvAvatar3 = (ImageView) view.findViewById(R.id.imv_avatar_four_au3);
                    viewHolder.imvStatus3 = (ImageView) view.findViewById(R.id.imv_point_four_au3);
                    viewHolder.txtName3 = (TextView) view.findViewById(R.id.txt_four_au3);


                    viewHolder.imvAvatar4 = (ImageView) view.findViewById(R.id.imv_avatar_four_au4);
                    viewHolder.imvStatus4 = (ImageView) view.findViewById(R.id.imv_point_four_au4);
                    viewHolder.txtName4 = (TextView) view.findViewById(R.id.txt_four_au4);
                    view.setTag(viewHolder);
                    break;
                case TYPE_FIVE:
                    view = mInflater.inflate(R.layout.item_list_five_aution, viewGroup,false);
                    viewHolder.imvAvatar = (ImageView) view.findViewById(R.id.imv_avatar_five_au1);
                    viewHolder.imvStatus = (ImageView) view.findViewById(R.id.imv_point_five_au1);
                    viewHolder.txtName = (TextView) view.findViewById(R.id.txt_five_au1);


                    viewHolder.imvAvatar2 = (ImageView) view.findViewById(R.id.imv_avatar_five_au2);
                    viewHolder.imvStatus2 = (ImageView) view.findViewById(R.id.imv_point_five_au2);
                    viewHolder.txtName2 = (TextView) view.findViewById(R.id.txt_five_au2);


                    viewHolder.imvAvatar3 = (ImageView) view.findViewById(R.id.imv_avatar_five_au3);
                    viewHolder.imvStatus3 = (ImageView) view.findViewById(R.id.imv_point_five_au3);
                    viewHolder.txtName3 = (TextView) view.findViewById(R.id.txt_five_au3);


                    viewHolder.imvAvatar4 = (ImageView) view.findViewById(R.id.imv_avatar_five_au4);
                    viewHolder.imvStatus4 = (ImageView) view.findViewById(R.id.imv_point_five_au4);
                    viewHolder.txtName4 = (TextView) view.findViewById(R.id.txt_five_au4);

                    viewHolder.imvAvatar5 = (ImageView) view.findViewById(R.id.imv_avatar_five_au5);
                    viewHolder.imvStatus5 = (ImageView) view.findViewById(R.id.imv_point_five_au5);
                    viewHolder.txtName5 = (TextView) view.findViewById(R.id.txt_five_au5);

                    view.setTag(viewHolder);
                    break;

            }

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        if (type == TYPE_TWO) {
            if (arrViewRows!=null && arrViewRows.get(position).getArrayList()!=null){
                viewHolder.imvAvatar.setImageResource(arrViewRows.get(position).getArrayList().get(0).getImvAvatar());
                if (arrViewRows.get(position).getArrayList().get(0).isOnline()) {
                    viewHolder.imvStatus.setImageResource(R.drawable.ic_status_online_grid_view);
                } else {
                    viewHolder.imvStatus.setImageResource(R.drawable.ic_menu_item_offline);
                }
                viewHolder.txtName.setText(arrViewRows.get(position).getArrayList().get(0).getTxtName());


                viewHolder.imvAvatar2.setImageResource(arrViewRows.get(position).getArrayList().get(1).getImvAvatar());
                if (arrViewRows.get(position).getArrayList().get(1).isOnline()) {
                    viewHolder.imvStatus2.setImageResource(R.drawable.ic_status_online_grid_view);
                } else {
                    viewHolder.imvStatus2.setImageResource(R.drawable.ic_menu_item_offline);
                }
                viewHolder.txtName2.setText(arrViewRows.get(position).getArrayList().get(1).getTxtName());
            }

        }
       /* if (type == TYPE_FOUR) {
            viewHolder.imvAvatar.setImageResource(arrViewRows.get(position).getArrayList().get(2).getImvAvatar());
            if (arrViewRows.get(position).getArrayList().get(2).isOnline()) {
                viewHolder.imvStatus.setImageResource(R.drawable.ic_status_online_grid_view);
            } else {
                viewHolder.imvStatus.setImageResource(R.drawable.ic_menu_item_offline);
            }
            viewHolder.txtName.setText(arrViewRows.get(position).getArrayList().get(2).getTxtName());


            viewHolder.imvAvatar2.setImageResource(arrViewRows.get(position).getArrayList().get(3).getImvAvatar());
            if (arrViewRows.get(position).getArrayList().get(3).isOnline()) {
                viewHolder.imvStatus2.setImageResource(R.drawable.ic_status_online_grid_view);
            } else {
                viewHolder.imvStatus2.setImageResource(R.drawable.ic_menu_item_offline);
            }
            viewHolder.txtName2.setText(arrViewRows.get(position).getArrayList().get(3).getTxtName());


            viewHolder.imvAvatar3.setImageResource(arrViewRows.get(position).getArrayList().get(4).getImvAvatar());
            if (arrViewRows.get(position).getArrayList().get(4).isOnline()) {
                viewHolder.imvStatus3.setImageResource(R.drawable.ic_status_online_grid_view);
            } else {
                viewHolder.imvStatus3.setImageResource(R.drawable.ic_menu_item_offline);
            }
            viewHolder.txtName3.setText(arrViewRows.get(position).getArrayList().get(4).getTxtName());


            viewHolder.imvAvatar4.setImageResource(arrViewRows.get(position).getArrayList().get(5).getImvAvatar());
            if (arrViewRows.get(position).getArrayList().get(5).isOnline()) {
                viewHolder.imvStatus4.setImageResource(R.drawable.ic_status_online_grid_view);
            } else {
                viewHolder.imvStatus4.setImageResource(R.drawable.ic_menu_item_offline);
            }
            viewHolder.txtName4.setText(arrViewRows.get(position).getArrayList().get(5).getTxtName());

        }*/


/*
        if (type == TYPE_FIVE) {
            viewHolder.imvAvatar.setImageResource(arrViewRows.get(position).getArrayList().get(6).getImvAvatar());
            viewHolder.imvStatus.setImageResource(arrViewRows.get(position).getArrayList().get(6).getImvStatus());
            viewHolder.txtName.setText(arrViewRows.get(position).getArrayList().get(6).getTxtName());

        }
*/


        return view;
    }
    private class ViewHolder {
        private ImageView imvAvatar, imvStatus, imvAvatar2, imvStatus2, imvStatus3, imvStatus4, imvAvatar4, imvAvatar5, imvStatus5;
        private TextView txtName, txtName2, txtName3, txtName4, txtName5;
        public ImageView imvAvatar3;
    }
}
