package fragment;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

/**
 * Created by admin on 7/18/2016.
 */
public abstract class BaseFragment extends Fragment {
    DrawerLayout drawerLayout = MainActivity.drawerLayout;
    void goBack(){
        getFragmentManager().popBackStack();
    }
    void changeFragment(Fragment myFragment,String Tag){
        getFragmentManager().beginTransaction().replace(R.id.main,myFragment,Tag).addToBackStack(null).commit();
    }
    void openDrawerLayout(){
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        drawerLayout.openDrawer(Gravity.LEFT);
    }
    void closeDrawerLayout(){
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }
}
