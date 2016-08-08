package com.example.admin.project1final;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import fragment.AutionFragment;
import fragment.ChatFragment;
import fragment.EditProfileFragment;
import fragment.GiveGiftFragment;
import fragment.MainFragment;
import fragment.NotificationProject2Fragment;
import fragment.PointFragment;
import fragment.SearchFriendFragment;
import fragment.SettingFragment;
import fragment.WellcomeFragment;
import key.name.fragment.tag.NameFragment;

public class MainActivity extends MyActivity implements View.OnClickListener {
    public static DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment activePage = checkFragment(NameFragment.loginFragment);
        initView();
        if (activePage == null) {
            showWellCome();
        }
        hideActionbar();
    }

    private void showWellCome() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main, new WellcomeFragment(), NameFragment.wellcomeFragment).commit();
        closeNavigation();

    }

    private Fragment checkFragment(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_main);
        LinearLayout lnlPoint = (LinearLayout) findViewById(R.id.lnl_point);
        if (lnlPoint != null) {
            lnlPoint.setOnClickListener(this);
        }
        LinearLayout lnlSetting = (LinearLayout) findViewById(R.id.lnl_setting);
        if (lnlSetting != null) {
            lnlSetting.setOnClickListener(this);
        }
        LinearLayout lnlNotification = (LinearLayout) findViewById(R.id.lnl_notification);
        assert lnlNotification != null;
        lnlNotification.setOnClickListener(this);
        LinearLayout lnlSearch = (LinearLayout) findViewById(R.id.lnl_search_setting);
        assert lnlSearch != null;
        lnlSearch.setOnClickListener(this);
        LinearLayout lnlProfile = (LinearLayout) findViewById(R.id.lnl_profile);
        assert lnlProfile != null;
        lnlProfile.setOnClickListener(this);
        LinearLayout lnlChat = (LinearLayout) findViewById(R.id.lnl_chat);
        assert lnlChat != null;
        lnlChat.setOnClickListener(this);
        LinearLayout lnlAution = (LinearLayout) findViewById(R.id.lnl_aution);
        assert lnlAution != null;
        lnlAution.setOnClickListener(this);
        LinearLayout lnlGiveGift = (LinearLayout) findViewById(R.id.lnl_give_gift);
        if (lnlGiveGift != null) {
            lnlGiveGift.setOnClickListener(this);
        }

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
                    changeFragment(new PointFragment(), NameFragment.pointFragmnet);
                    changeFragmentOpenNavigation();

                }

                break;
            case R.id.lnl_setting:
                Fragment fragmentSetting = checkFragment(NameFragment.settingFragment);
                if (fragmentSetting == null) {
                    changeFragment(new SettingFragment(), NameFragment.settingFragment);
                    changeFragmentOpenNavigation();
                }
                break;

            case R.id.lnl_notification:
                //TODO project 1
               /* changeFragment(new NotificationsFragment(), NameFragment.notificationFragment);
                closeNavigation();*/

                //TODO project 2
                Fragment fragmentNotification = checkFragment(NameFragment.nofiticationProject2);
                if (fragmentNotification == null) {
                    changeFragment(new NotificationProject2Fragment(), NameFragment.nofiticationProject2);
                    closeNavigation();
                    showActionbarAuction("Notification");
                }

                break;
            case R.id.lnl_search_setting:
                Fragment fragmentSearchSetting = checkFragment(NameFragment.searchSettingFragment);
                if (fragmentSearchSetting == null) {
                    changeFragment(new SearchFriendFragment(), NameFragment.searchFriendFragment);
                    closeNavigation();
                    showActionbarAuction("Search Friend");
                }

                break;
            case R.id.lnl_profile:
                Fragment fragmentProfile = checkFragment(NameFragment.editProfileFragment);
                if (fragmentProfile == null) {
                    changeFragment(new EditProfileFragment(), NameFragment.editProfileFragment);
                    closeNavigation();
                }

                break;
            case R.id.lnl_chat:
                Fragment chatFragment = checkFragment(NameFragment.chatFragment);
                if (chatFragment == null) {
                    changeFragment(new ChatFragment(), NameFragment.chatFragment);
                    closeNavigation();
                }

                break;
            case R.id.lnl_aution:
                Fragment autionFragment = checkFragment(NameFragment.autionFragment);
                if (autionFragment == null) {
                    changeFragment(new AutionFragment(), NameFragment.autionFragment);
                    showActionbarAuction("Auction");
                }
                break;
            case R.id.lnl_give_gift:
                Fragment giveGiftFragment = checkFragment(NameFragment.giveGiftFragment);
                if (giveGiftFragment == null) {
                    changeFragment(new GiveGiftFragment(), NameFragment.giveGiftFragment);
                    closeNavigation();
                    /*hideActionbar();*/
                }
                break;
        }

    }

    private void showActionbarAuction(String title) {
        if (getSupportActionBar() != null) {
            setUpActionbarAuction(title);
            getSupportActionBar().show();

        }
    }

    public void showActionbarRecentReport() {
        if (getSupportActionBar() != null)
            getSupportActionBar().show();
        setUpRecenreport("Recent Report");
    }

    public void showActionbarLogin() {
        if (getSupportActionBar() != null)
            getSupportActionBar().show();
        setUpLoginActionbar("Login");
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
        super.onBackPressed();

        Fragment activePageSetting = checkFragment(NameFragment.settingFragment);
        if (activePageSetting != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            return;
        }
        Fragment autionFragment = checkFragment(NameFragment.autionFragment);
        if (autionFragment != null) {
            showActionbarAuction("Aution");
            getSupportFragmentManager().popBackStackImmediate(
                    new MainFragment().getClass().getName(), 0);
            return;
        }
        Fragment searchFriendFragment = checkFragment(NameFragment.searchFriendFragment);
        if (searchFriendFragment != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            showActionbarAuction("Search Friend");
            return;
        }
        Fragment giveGiftFragment = checkFragment(NameFragment.giveGiftFragment);
        if (giveGiftFragment != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            hideActionbar();
            return;
        }
        Fragment activePageMain = checkFragment(NameFragment.mainFragmnet);
        if (activePageMain != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            drawerLayout.closeDrawer(Gravity.LEFT);
            showActionbarRecentReport();
            return;
        }



        Fragment activeWellcome = checkFragment(NameFragment.wellcomeFragment);

        Fragment activeLogin = checkFragment(NameFragment.loginFragment);
        if (activeLogin != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            showActionbarLogin();
            getFragmentManager().popBackStack();
            return;
        }


        if (activeWellcome != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            hideActionbar();
            return;
        }


    }

    public void hideActionbar() {
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
    }
}
