package com.example.admin.project1final;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import fragment.EditProfileFragment;
import fragment.LoginFragment;
import fragment.NotificationsFragment;
import fragment.PointFragment;
import fragment.SearchSettingFragment;
import fragment.SettingFragment;
import key.name.fragment.tag.NameFragment;

public class MainActivity extends MyActivity implements View.OnClickListener {
    public static DrawerLayout drawerLayout;
    private LinearLayout lnlPoint, lnlSetting, lnlNotification, lnlSearch, lnlProfile;
    private Fragment activePage;
    private View mFrameOfSubScreen, mFrameOfMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activePage = checkFragment(NameFragment.loginFragment);
        initView();
        if (activePage == null) {
            showLogin();
        }

    }

    private void showLogin() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main, new LoginFragment(), NameFragment.loginFragment).commit();
        closeNavigation();
    }

    private Fragment checkFragment(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_main);
        lnlPoint = (LinearLayout) findViewById(R.id.lnl_point);
        lnlPoint.setOnClickListener(this);
        lnlSetting = (LinearLayout) findViewById(R.id.lnl_setting);
        lnlSetting.setOnClickListener(this);
        lnlNotification = (LinearLayout) findViewById(R.id.lnl_notification);
        lnlNotification.setOnClickListener(this);
        lnlSearch = (LinearLayout) findViewById(R.id.lnl_search_setting);
        lnlSearch.setOnClickListener(this);
        lnlProfile = (LinearLayout) findViewById(R.id.lnl_profile);
        lnlProfile.setOnClickListener(this);
        mFrameOfSubScreen = (FrameLayout) this.findViewById(R.id.sub_screen);
        mFrameOfMain = (FrameLayout) this.findViewById(R.id.main);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lnl_point:
                Fragment fragmentPoint = checkFragment(NameFragment.pointFragmnet);
                if (fragmentPoint == null) {
                    changeFragment(new PointFragment(),NameFragment.pointFragmnet);
                    changeFragmentOpenNavigation();
                }
               /* Fragment subScreen = getSubScreen();
                if (subScreen != null && subScreen instanceof PointFragment) {
                    return;
                }
                PointFragment point = new PointFragment();
                showSubScreen(point, true);*/
                break;
            case R.id.lnl_setting:
                Fragment fragmentSetting = checkFragment(NameFragment.settingFragment);
                if (fragmentSetting == null) {
                    changeFragment(new SettingFragment(), NameFragment.settingFragment);
                    changeFragmentOpenNavigation();
                }
               /* Fragment subScreen1 = getSubScreen();
                if (subScreen1 != null && subScreen1 instanceof SettingFragment) {
                    return;
                }
                SettingFragment settingFragment = new SettingFragment();
                showSubScreen(settingFragment, true);*/
                break;
            case R.id.lnl_notification:
                changeFragment(new NotificationsFragment(), NameFragment.notificationFragment);
                closeNavigation();
                break;
            case R.id.lnl_search_setting:
                changeFragment(new SearchSettingFragment(), NameFragment.searchSettingFragment);
                closeNavigation();
                break;
            case R.id.lnl_profile:
                changeFragment(new EditProfileFragment(), NameFragment.editProfileFragment);
                closeNavigation();
                break;
        }
    }

    private void popSubScreen() {
        int oldStackSize = getSupportFragmentManager().getBackStackEntryCount();
        if (oldStackSize > 0) {
            getSupportFragmentManager().popBackStack();
            getSupportFragmentManager().beginTransaction().remove(getSubScreen()).commit();
        } else {
            finish();
            return;
        }

        int stackSize = oldStackSize - 1;
        if (stackSize <= 0) {
            mFrameOfSubScreen.setVisibility(View.GONE);
            mFrameOfMain.setVisibility(View.VISIBLE);
        }
    }

    private void showSubScreen(Fragment subScreen, boolean wantToClearBackStack) {
        if (subScreen == null) return;

        mFrameOfSubScreen.setVisibility(View.VISIBLE);
        mFrameOfMain.setVisibility(View.GONE);

        if (wantToClearBackStack) {
            int backStackSize = getSupportFragmentManager().getBackStackEntryCount();
            if (backStackSize > 0) {
                for (int i = 0; i < backStackSize; i++) {
                    popSubScreen();
                }
            }
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.sub_screen, subScreen, "").addToBackStack("")
                .commit();
    }

    private Fragment getSubScreen() {
        return getSupportFragmentManager().findFragmentById(R.id.sub_screen);
    }

    private void closeNavigation() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    private void changeFragmentOpenNavigation() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void onBackPressed() {
       /* popSubScreen();*/
        super.onBackPressed();
        Fragment activePageSetting = checkFragment(NameFragment.settingFragment);
        if (activePageSetting != null) drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        Fragment activePageMain = checkFragment(NameFragment.mainFragmnet);
        if (activePageMain != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
        Fragment activeSearchSetting = checkFragment(NameFragment.searchSettingFragment);
        if (activeSearchSetting != null) drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }
}
