package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import key.name.fragment.tag.NameFragment;
import my.item.ItemAution;
import myadapter.AutionAdapter;

/**
 * Created by admin on 8/1/2016.
 */
public class AutionFragment extends BaseFragment implements View.OnClickListener {
    private AutionAdapter myAdapter;
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private ArrayList<ItemAution> arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.aution_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        myAdapter = new AutionAdapter(arrayList);
        recyclerView.setAdapter(myAdapter);
        layoutManager = new GridLayoutManager(getActivity(), 20);
        recyclerView.setLayoutManager(layoutManager);
        setColumnsView();
    }

    private void setColumnsView() {
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0 || position == 1) return 10;
                if (position>=2 || position<=5)
                    return 5;

                return 4;
            }
        });
    }

    private void initView(View view) {
        ImageView imvOpenDrawer = (ImageView) view.findViewById(R.id.imvDrawerOpenAution);
        recyclerView = (RecyclerView) view.findViewById(R.id.rcl_aution);
        FrameLayout frmMessage = (FrameLayout) view.findViewById(R.id.frm_chat_message_aution);
       /* frmMessage.setOnClickListener(this);
        imvOpenDrawer.setOnClickListener(this);*/
    }

    private void initData() {
        arrayList = new ArrayList<>();
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Nguyen Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Nguyen Nhung", false));
        arrayList.add(new ItemAution(R.drawable.default_female_bg, "Quynh Thuy", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", false));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Lan", false));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Anh Long", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));

        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", false));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", false));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Lan", false));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Quynh", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));

        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", false));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", false));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Lan", false));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Quynh", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Tuan", true));
        arrayList.add(new ItemAution(R.drawable.default_male_bg, "Viet Nam", true));


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
