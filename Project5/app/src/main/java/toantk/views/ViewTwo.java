package toantk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.admin.project1final.R;

import toantk.entities.AbstractRow;
import toantk.entities.User;

/**
 * Created by admin on 8/3/2016.
 */
public class ViewTwo extends LinearLayout {

    private UserView mUserView1, mUserView2;

    public ViewTwo(Context context) {
        super(context);
        initView(context);
    }

    public ViewTwo(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ViewTwo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private static void displayUser(UserView userView, User user) {

        if (userView == null || user == null) return;

        userView.displayUser(user);
    }

    private void initView(Context context) {
        inflate(context, R.layout.include_view_two, this);
        mUserView1 = (UserView) findViewById(R.id.view_first);
        mUserView2 = (UserView) findViewById(R.id.view_second);
    }

    public void display(AbstractRow abstractRow) {
        resetViews();

        if (abstractRow == null) return;
        displayUser(mUserView1, abstractRow.getUser(0));
        displayUser(mUserView2, abstractRow.getUser(1));
    }

    private void resetViews() {
        mUserView1.reset();
        mUserView2.reset();
    }
}
