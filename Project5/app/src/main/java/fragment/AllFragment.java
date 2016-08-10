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
import my.item.ItemGiveGift;
import myadapter.AllAdapter;

/**
 * Created by admin on 8/4/2016.
 */
public class AllFragment extends BaseFragment implements View.OnClickListener {
    private ArrayList<ItemGiveGift> arrAll;
    private RecyclerView recyclerView;
    private ImageView imvBack;
    private FrameLayout frmChatMessage;
    private AllAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.all_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 4);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AllAdapter(arrAll);

        recyclerView.setAdapter(mAdapter);
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rcl_all);
        imvBack = (ImageView) view.findViewById(R.id.imv_back_give_all);
        frmChatMessage = (FrameLayout) view.findViewById(R.id.frm_chat_message_all_gift);
        imvBack.setOnClickListener(this);
        frmChatMessage.setOnClickListener(this);

    }

    private void initData() {
        arrAll = new ArrayList<>();
        arrAll.add(new ItemGiveGift("Free", R.drawable.image1_all));
        arrAll.add(new ItemGiveGift("Free", R.drawable.image2_all));
        arrAll.add(new ItemGiveGift("Free", R.drawable.image3_all));
        arrAll.add(new ItemGiveGift("Free", R.drawable.image4_all));
        arrAll.add(new ItemGiveGift("Free", R.drawable.image5_all));
        arrAll.add(new ItemGiveGift("Free", R.drawable.image1_all));
        arrAll.add(new ItemGiveGift("Free", R.drawable.image2_all));
        arrAll.add(new ItemGiveGift("Free", R.drawable.image3_all));
        arrAll.add(new ItemGiveGift("Free", R.drawable.image4_all));
        arrAll.add(new ItemGiveGift("Free", R.drawable.image5_all));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imv_back_give_all:
                goBack();
                break;
            case R.id.frm_chat_message_all_gift:
                changeFragment(new ChatFragment(), NameFragment.chatFragment);
                break;
        }
    }
}
