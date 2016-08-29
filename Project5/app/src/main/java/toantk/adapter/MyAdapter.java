package toantk.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import my.item.RowFive;
import my.item.RowFour;
import my.item.RowTwo;
import toantk.entities.AbstractRow;
import toantk.views.ViewFive;
import toantk.views.ViewFour;
import toantk.views.ViewTwo;

/**
 * Created by admin on 8/3/2016.
 */
public class MyAdapter extends BaseAdapter {

    private static final int VIEW_TYPE_TWO = 1;
    private static final int VIEW_TYPE_FOUR = 2;
    private static final int VIEW_TYPE_FIVE = 3;

    private ArrayList<AbstractRow> rowList;

    public MyAdapter(ArrayList<AbstractRow> rowList) {
        this.rowList = rowList;
    }

    @Override
    public int getCount() {
        if (rowList == null) return 0;
        return rowList.size();
    }

    @Override
    public Object getItem(int position) {
        if (rowList == null) return null;
        return rowList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        Object object = getItem(position);
        if (object == null) return VIEW_TYPE_TWO;

        if (object instanceof RowTwo) return VIEW_TYPE_TWO;
        if (object instanceof RowFour) return VIEW_TYPE_FOUR;
        if (object instanceof RowFive) return VIEW_TYPE_FIVE;

        return VIEW_TYPE_TWO;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posistion, View convertView, ViewGroup viewGroup) {

        int viewType = getItemViewType(posistion);

        AbstractRow abstractRow = (AbstractRow) getItem(posistion);

        if (viewType == VIEW_TYPE_TWO) {

            if (convertView == null || !(convertView instanceof ViewTwo)) {
                convertView = new ViewTwo(viewGroup.getContext());
            }

            ((ViewTwo) convertView).display(abstractRow);
        } else if (viewType == VIEW_TYPE_FOUR) {
            if (convertView == null || !(convertView instanceof ViewFour)) {
                convertView = new ViewFour(viewGroup.getContext());
            }

            ((ViewFour) convertView).display(abstractRow);
        } else if (viewType == VIEW_TYPE_FIVE) {

            if (convertView == null || !(convertView instanceof ViewFive)) {
                convertView = new ViewFive(viewGroup.getContext());
            }

            ((ViewFive) convertView).display(abstractRow);
        }

        return convertView;
    }
}
