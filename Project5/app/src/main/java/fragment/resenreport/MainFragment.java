package fragment.resenreport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import fragment.base.BaseFragment;

/**
 * Created by admin on 7/8/2016.
 * fragment chính thực hiện các thao tác với drawer layout, từ đây có thể di chuyển đến các fragment khác
 */
public class MainFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DrawerLayout drawerLayout = MainActivity.drawerLayout;
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        drawerLayout.closeDrawer(Gravity.LEFT);
        ((MainActivity) getActivity()).showActionbarRecentReport();
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
