package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import java.util.ArrayList;

import my.item.ItemSearchFriendListview;
import myadapter.ChatContentAdapter;

/**
 * Created by admin on 7/29/2016.
 */
public class ChatFragment extends BaseFragment implements View.OnClickListener {
    private ArrayList<ItemSearchFriendListview> arrChat = new ArrayList<>();
    private ChatContentAdapter myAdapter;
    private ImageView imvDelete;
    private ImageView imvDone;
    private TextView txtContentDelete;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chat_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        myAdapter = new ChatContentAdapter(getActivity(), arrChat);
        listView.setAdapter(myAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).hideActionbar();
    }

    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.lv_chat);
        imvDelete = (ImageView) view.findViewById(R.id.imv_delete_chat_history);
        imvDone = (ImageView) view.findViewById(R.id.imv_menu_done);
        txtContentDelete = (TextView) view.findViewById(R.id.txt_delete);

        imvDone.setOnClickListener(this);
        imvDelete.setOnClickListener(this);
    }

    private void initData() {
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "", "Content Receveraaaaaaaaaaaaaaaaaaaaaaaaaaaa", false, "Tuan"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_female_bg, "30mi", "45h", "Content Send", "", false, "Quynh"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "Content Send", "", true, "Nhung"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "", "Content Recever", true, "Hoa"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "", "Content Recever", false, "Lan"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "", "Content Recever", false, "Tuan"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "", "Content Recever", true, "Tuan"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "Content Send", "", false, "Tuan"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "", "Content Recever", true, "Tuan"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "", "Content Recever", false, "Tuan"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "Content Send", "", true, "Tuan"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "Content Send", "", false, "Tuan"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "Content Send", "", true, "Tuan"));
        arrChat.add(new ItemSearchFriendListview(R.drawable.default_male_bg, "30mi", "45h", "", "Content Recever", true, "Tuan"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imv_delete_chat_history:
                myAdapter.isDelete = true;
                imvDelete.setVisibility(View.GONE);
                imvDone.setVisibility(View.VISIBLE);
                txtContentDelete.setText(R.string.done);
                break;
            case R.id.imv_menu_done:
                myAdapter.isDelete = false;
                imvDelete.setVisibility(View.VISIBLE);
                imvDone.setVisibility(View.GONE);
                txtContentDelete.setText(R.string.deleteHistory);
                break;
        }
        myAdapter.notifyDataSetChanged();
    }


}
