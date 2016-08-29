package fragment.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import java.util.ArrayList;

import fragment.base.BaseFragment;
import my.item.ItemSearchFriendListview;
import myadapter.SearchFriendAdapterGrirdView;
import myadapter.SearchFriendAdapterListview;

/**
 * Created by admin on 7/27/2016.
 */
public class SearchFriendFragment extends BaseFragment implements View.OnClickListener {
    private SearchFriendAdapterListview myAdapterList;
    private ArrayList<ItemSearchFriendListview> arrItemData = new ArrayList<>();
    private ImageView imvChangeList;
    private TextView txtContent;
    private ListView listView;
    private GridView gridView;
    private ImageView imvChageToGrird;
    private SearchFriendAdapterGrirdView myAdapter;
    private DrawerLayout drawerLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_friend_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        myAdapter = new SearchFriendAdapterGrirdView(getActivity(), android.R.layout.simple_list_item_1, arrItemData);
        gridView.setAdapter(myAdapter);

    }

    private void initView(View view) {

        imvChangeList = (ImageView) view.findViewById(R.id.imv_change_list);
        imvChangeList.setOnClickListener(this);
        txtContent = (TextView) view.findViewById(R.id.txt_change_type);
        gridView = (GridView) view.findViewById(R.id.grv_searchFriend);
        listView = (ListView) view.findViewById(R.id.lv_searchFriend);
        drawerLayout = MainActivity.drawerLayout;
        openDrawerLayout();
        drawerLayout.closeDrawer(Gravity.LEFT);
        imvChageToGrird = (ImageView) view.findViewById(R.id.imv_change_grird);
        imvChageToGrird.setOnClickListener(this);


    }

    private void initData() {
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuanweurhkwehrjkrhjkrhjkwehrjkwehkh", "My name is tuan", "23 yo", "150 mi ", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi ", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi ", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi ", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi ", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, "2"));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));
        arrItemData.add(new ItemSearchFriendListview(R.drawable.default_avata, "online", R.drawable.ic_status_online_grid_view, "Tuan", "My name is tuan", "23 yo", "150 mi", R.drawable.ic_menu_item_notification, ""));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imv_change_list:
                txtContent.setText(R.string.grird);
                myAdapterList = new SearchFriendAdapterListview(getActivity(), arrItemData);
                listView.setAdapter(myAdapterList);
                listView.setVisibility(View.VISIBLE);
                gridView.setVisibility(View.GONE);
                imvChageToGrird.setVisibility(View.VISIBLE);
                imvChangeList.setVisibility(View.GONE);
                break;
            case R.id.imv_change_grird:
                listView.setVisibility(View.GONE);
                gridView.setVisibility(View.VISIBLE);
                txtContent.setText(R.string.listView);
                gridView.setAdapter(myAdapter);
                imvChangeList.setVisibility(View.VISIBLE);
                imvChageToGrird.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "vao day", Toast.LENGTH_LONG).show();
                break;

        }
    }
}
