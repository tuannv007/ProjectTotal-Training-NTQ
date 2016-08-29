package myadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import my.item.ItemAution;

/**
 * Created by admin on 8/2/2016.
 */
public class AuctionAdapter extends RecyclerView.Adapter<AuctionAdapter.ViewHolderAution> {
    private ArrayList<ItemAution> arrItemAution = new ArrayList<>();

    public AuctionAdapter(ArrayList<ItemAution> arrItemAution) {
        this.arrItemAution = arrItemAution;
    }

    @Override
    public ViewHolderAution onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_list_recycler_aution, parent, false);
        return new ViewHolderAution(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolderAution holder, int position) {
        holder.txtName.setText(arrItemAution.get(position).getTxtName());
        holder.imvAvatar.setImageResource(arrItemAution.get(position).getImvAvatar());
        if (position == 0 || position == 1) {
            holder.imvAvatar.setPadding(35, 0, 0, 0);
            holder.imvAvatar.getLayoutParams().height = 500;

        }
        if (position >= 5 && position <= 5) {
            holder.imvAvatar.getLayoutParams().height = 300;
        }
        if (position > 5) {
            holder.imvAvatar.getLayoutParams().height = 250;

        }
        if (arrItemAution.get(position).isOnline()) {
            holder.imvStatus.setImageResource(R.drawable.ic_status_online_grid_view);
        } else {
            holder.imvStatus.setImageResource(R.drawable.ic_menu_item_offline);
        }

    }


    @Override
    public int getItemCount() {
        return arrItemAution.size();
    }

    public class ViewHolderAution extends RecyclerView.ViewHolder {
        public ImageView imvAvatar, imvStatus;
        public TextView txtName;

        public ViewHolderAution(View itemView) {
            super(itemView);
            imvAvatar = (ImageView) itemView.findViewById(R.id.imv_avatar_au1);
            imvStatus = (ImageView) itemView.findViewById(R.id.imv_point_au1);
            txtName = (TextView) itemView.findViewById(R.id.txt_au1);
        }
    }


}
