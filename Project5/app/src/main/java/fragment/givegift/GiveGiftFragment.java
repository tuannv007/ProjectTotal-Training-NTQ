package fragment.givegift;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import java.util.ArrayList;

import fragment.AllFragment;
import fragment.base.BaseFragment;
import fragment.chat.ChatFragment;
import key.name.fragment.tag.NameFragment;
import my.item.ItemGiveGift;
import myadapter.GiveGiftAdapter;

/**
 * Created by admin on 8/4/2016.
 */
public class GiveGiftFragment extends BaseFragment implements View.OnClickListener {

    private ArrayList<ItemGiveGift> arrGiveGift;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.give_gift_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
        GiveGiftAdapter mAdapter = new GiveGiftAdapter(arrGiveGift);
        mAdapter.setmOnItemClickListener(new GiveGiftAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                changeFragment(new AllFragment(), NameFragment.allFragment);
                Toast.makeText(getActivity(), "clicl", Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

    private void initView(View view) {
        ImageView imvBack = (ImageView) view.findViewById(R.id.imv_back_give_gift);
        FrameLayout frmChatMessage = (FrameLayout) view.findViewById(R.id.frm_chat_message_give_gift);
        recyclerView = (RecyclerView) view.findViewById(R.id.rcl_give_gift);
        imvBack.setOnClickListener(this);
        frmChatMessage.setOnClickListener(this);
        if (arrGiveGift == null) return;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

    }

    private void initData() {
        arrGiveGift = new ArrayList<>();
        arrGiveGift.add(new ItemGiveGift("All"));
        arrGiveGift.add(new ItemGiveGift("Animal"));
        arrGiveGift.add(new ItemGiveGift("Flower"));
        arrGiveGift.add(new ItemGiveGift("Charactor"));
        arrGiveGift.add(new ItemGiveGift("Accessories"));
        arrGiveGift.add(new ItemGiveGift("Birthday"));
        arrGiveGift.add(new ItemGiveGift("Other"));
        arrGiveGift.add(new ItemGiveGift("Test"));
        arrGiveGift.add(new ItemGiveGift("Monter"));


    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).hideActionbar();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imv_back_give_gift:
                goBack();
                break;
            case R.id.frm_chat_message_give_gift:
                changeFragment(new ChatFragment(), NameFragment.chatFragment);
                break;
        }
    }
}
