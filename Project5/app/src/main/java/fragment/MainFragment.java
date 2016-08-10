package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

/**
 * Created by admin on 7/8/2016.
 * fragment chính thực hiện các thao tác với drawer layout, từ đây có thể di chuyển đến các fragment khác
 */
public class MainFragment extends BaseFragment{
    private DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        drawerLayout = MainActivity.drawerLayout;
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        drawerLayout.closeDrawer(Gravity.LEFT);
        ImageView imageOpenDrawer = (ImageView) view.findViewById(R.id.imvOpenDrawer);
        ((MainActivity)getActivity()).showActionbarRecentReport();
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
