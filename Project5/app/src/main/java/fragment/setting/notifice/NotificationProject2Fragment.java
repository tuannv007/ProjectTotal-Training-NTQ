package fragment.setting.notifice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.project1final.R;

import java.util.ArrayList;

import fragment.base.BaseFragment;
import my.item.ItemNotification;
import myadapter.NotificationAdapter;

/**
 * Created by admin on 8/2/2016.
 */
public class NotificationProject2Fragment extends BaseFragment implements View.OnClickListener {
    private ArrayList<ItemNotification> arrayList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notification_project2_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        NotificationAdapter mAdapter = new NotificationAdapter(arrayList);
        recyclerView.setAdapter(mAdapter);
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rlc_notification);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initData() {
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));
        arrayList.add(new ItemNotification("here", "19s"));


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
