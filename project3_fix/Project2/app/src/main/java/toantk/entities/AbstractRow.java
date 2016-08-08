package toantk.entities;

import java.util.ArrayList;

/**
 * Created by admin on 8/3/2016.
 */
public abstract class AbstractRow {

    private ArrayList<User> userList;

    public AbstractRow(ArrayList<User> userList) {
        this.userList = userList;
    }

    public User getUser(int position) {
        if (userList == null) return null;

        if (position < 0 || position >= userList.size()) return null;

        return userList.get(position);
    }
}
