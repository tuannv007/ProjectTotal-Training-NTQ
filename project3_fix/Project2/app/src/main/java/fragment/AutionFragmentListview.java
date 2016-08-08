package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.admin.project1final.R;

import java.util.ArrayList;
import java.util.List;

import my.item.ItemAution;
import my.item.RowFive;
import my.item.RowFour;
import my.item.RowTwo;
import my.item.ViewRows;
import myadapter.AutionAdapterListview;

/**
 * Created by admin on 8/3/2016.
 */
public class AutionFragmentListview extends BaseFragment {
    private ArrayList<ViewRows> arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.aution_listview_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        AutionAdapterListview myAdapter = new AutionAdapterListview(arrayList, getActivity());
        ListView listView = (ListView) view.findViewById(R.id.lv_aution);
        listView.setAdapter(myAdapter);
    }

    private void initData() {
        arrayList = new ArrayList<>();
        ViewRows rowTwo = new RowTwo();
        ViewRows rowsFour = new RowFour();
        ViewRows rowsFive = new RowFive();
        ArrayList<ItemAution> itemAutions = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            itemAutions.add(new ItemAution(R.drawable.ic_menu_item_offline, "Tuan", false));
        }
        rowTwo.setArrayList(itemAutions);
        arrayList.add(rowTwo);


    }


}
