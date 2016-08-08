/*
package toantk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.admin.project1final.R;

import java.util.ArrayList;
import java.util.List;

import toantk.adapter.MyAdapter;
import toantk.entities.AbstractRow;
import toantk.entities.RowFive;
import toantk.entities.RowFour;
import toantk.entities.RowTwo;
import toantk.entities.User;

*/
/**
 * Created by admin on 8/3/2016.
 *//*

public class ToanTKFragment extends Fragment {

    private ListView mListView;
    private MyAdapter myAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_toantk, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mListView = (ListView) view.findViewById(R.id.list_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<User> userList = new ArrayList<>();

        userList.add(new User("Tuan", "Tuan"));
        userList.add(new User("Tuan", "Tuan"));
        userList.add(new User("Tuan", "Tuan"));
        userList.add(new User("Tuan", "Tuan"));
        userList.add(new User("Tuan", "Tuan"));
        userList.add(new User("Tuan", "Tuan"));


        //TODO add user


        //TODO convert userList into list of AbstractRow

        */
/*
        item 1 : rowTwo
        item 2 : rowFour
        item 3 : rowFive
         *//*


        ArrayList<AbstractRow> rowList = new ArrayList<>();

        final int userSize = userList.size();

        RowTwo rowTwo = new RowTwo(split(userList, 0, 1));
        rowList.add(rowTwo);

        if (userSize > 2) {
            RowFour rowFour = new RowFour((ArrayList<User>) split(userList, 2, 5));
            rowList.add(rowFour);
        }

        if (userSize > 6) {

            int startIndex = 6;
            int endIndex;

            do {
                endIndex = startIndex += 5 - 1;
                RowFive rowFive = new RowFive(split(userList, startIndex, endIndex));
                rowList.add(rowFive);
            } while (endIndex < userSize);

        }

        myAdapter = new MyAdapter(rowList);
        mListView.setAdapter(myAdapter);
    }

*/
/*
    private static List<User> split(ArrayList<User> userList, int startIndex, int endIndex) {

        if (userList == null) return null;
        if (startIndex > endIndex) return null;
        if (startIndex < 0) return null;
        if (endIndex > userList.size())
            endIndex = userList.size();

        return (ArrayList<User>) userList.subList(startIndex, endIndex);
    }
*//*

}
*/
