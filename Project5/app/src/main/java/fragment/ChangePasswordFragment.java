package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

/**
 * Created by admin on 7/13/2016.
 */
public class ChangePasswordFragment extends BaseFragment implements View.OnClickListener {
    private View btnBack;
    DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.changepassword_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBack = (Button) view.findViewById(R.id.btnBack_changePassword);
        btnBack.setOnClickListener(this);
        drawerLayout = MainActivity.drawerLayout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack_changePassword:
                goBack();
                openDrawerLayout();
                break;
        }
    }
}
