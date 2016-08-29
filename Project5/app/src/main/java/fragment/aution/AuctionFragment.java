package fragment.aution;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import fragment.base.BaseFragment;
import fragment.chat.ChatFragment;
import key.name.fragment.tag.NameFragment;
import my.item.ItemAution;
import myadapter.AuctionAdapter;

/**
 * Created by admin on 8/1/2016.
 */
public class AuctionFragment extends BaseFragment implements View.OnClickListener {
    private GridLayoutManager layoutManager;
    private ArrayList<ItemAution> arrayListAuction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.aution_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
        setColumnsView();
    }

    private void setColumnsView() {
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0 || position == 1) return 10;
                if (position >= 2 || position <= 5)
                    return 5;

                return 4;
            }
        });
    }

    private void initView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcl_aution);
        AuctionAdapter myAdapter = new AuctionAdapter(arrayListAuction);
        recyclerView.setAdapter(myAdapter);
        layoutManager = new GridLayoutManager(getActivity(), 20);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void initData() {
        arrayListAuction = new ArrayList<>();
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Nguyen Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Nguyen Nhung", false));
        arrayListAuction.add(new ItemAution(R.drawable.default_female_bg, "Quynh Thuy", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", false));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Lan", false));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Anh Long", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));

        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", false));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", false));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Lan", false));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Quynh", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));

        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", false));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", false));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Lan", false));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Quynh", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayListAuction.add(new ItemAution(R.drawable.default_male_bg, "Viet Nam", true));


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imvDrawerOpenAution:
                openDrawerLayout();
                break;
            case R.id.frm_chat_message_aution:
                changeFragment(new ChatFragment(), NameFragment.chatFragment);
                break;
        }
    }
}
