package fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

/**
 * Created by admin on 7/18/2016.
 */
public abstract class BaseFragment extends Fragment {
    DrawerLayout drawerLayout = MainActivity.drawerLayout;

    void goBack() {
        getFragmentManager().popBackStack();
    }

    public void changeFragment(Fragment myFragment, String Tag) {
        getFragmentManager().beginTransaction().replace(R.id.main, myFragment, Tag).addToBackStack(null).commit();
    }

    public void openDrawerLayout() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    public void closeDrawerLayout() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }



}
