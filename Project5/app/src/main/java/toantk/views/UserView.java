package toantk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.project1final.R;

import toantk.entities.User;

/**
 * Created by admin on 8/3/2016.
 */
public class UserView extends RelativeLayout {

    private TextView mUserName;
    private ImageView mAvatar;

    public UserView(Context context) {
        super(context);
        initView(context);
    }

    public UserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public UserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.include_user_view, this);
        mUserName = (TextView) findViewById(R.id.username);
        mAvatar = (ImageView) findViewById(R.id.avatar);
    }

    public void displayUser(User user) {
        //TODO display User
        mUserName.setText(user.getName());
    }

    public void reset() {
        //TODO reset
        mUserName.setText("");
    }
}
