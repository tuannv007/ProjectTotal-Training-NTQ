package my.item;

import java.util.ArrayList;

/**
 * Created by admin on 8/3/2016.
 */
public abstract class ViewRows {
    protected ArrayList<ItemAution> arrayList = new ArrayList<>();

    public ArrayList<ItemAution> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<ItemAution> arrayList) {
        this.arrayList = arrayList;
    }
}
