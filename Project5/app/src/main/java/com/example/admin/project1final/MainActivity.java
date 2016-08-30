package com.example.admin.project1final;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import fragment.WelcomeFragment;
import fragment.aution.AuctionFragment;
import fragment.chat.ChatFragment;
import fragment.givegift.GiveGiftFragment;
import fragment.login.LoginFragment;
import fragment.point.PointFragment;
import fragment.profile.EditProfileFragment;
import fragment.resenreport.MainFragment;
import fragment.search.SearchSettingFragment;
import fragment.setting.SettingFragment;
import fragment.setting.notifice.NotificationsFragment;
import key.name.fragment.tag.NameFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener, LoginFragment.pushToken {
    public static DrawerLayout drawerLayout;
    public static String KEY_TOKEN = "key_token";
    private String getToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment activePage = checkFragmentExist(NameFragment.loginFragment);
        initView();
        if (activePage == null) {
            showWellComeFragment();
        }
        hideActionbar();
    }

    private void showWellComeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main, new WelcomeFragment(), NameFragment.wellcomeFragment).commit();
        closeNavigation();

    }

    private Fragment checkFragmentExist(String tag) {
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
        if (lnlNotification != null)
            lnlNotification.setOnClickListener(this);
        LinearLayout lnlSearch = (LinearLayout) findViewById(R.id.lnl_search_setting);
        if (lnlSearch != null)
            lnlSearch.setOnClickListener(this);
        LinearLayout lnlProfile = (LinearLayout) findViewById(R.id.lnl_profile);
        if (lnlProfile != null)
            lnlProfile.setOnClickListener(this);
        LinearLayout lnlChat = (LinearLayout) findViewById(R.id.lnl_chat);
        if (lnlChat != null)
            lnlChat.setOnClickListener(this);
        LinearLayout lnlAuction = (LinearLayout) findViewById(R.id.lnl_aution);
        if (lnlAuction != null)
            lnlAuction.setOnClickListener(this);
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
                Fragment fragmentPoint = checkFragmentExist(NameFragment.pointFragmnet);
                if (fragmentPoint == null) {
                    changeFragment(new PointFragment(), NameFragment.pointFragmnet);
                    changeFragmentOpenNavigation();

                }

                break;
            case R.id.lnl_setting:
                Fragment fragmentSetting = checkFragmentExist(NameFragment.settingFragment);
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
                Fragment fragmentNotification = checkFragmentExist(NameFragment.nofiticationProject2);
                if (fragmentNotification == null) {
                    changeFragment(new NotificationsFragment(), NameFragment.notificationFragment);
                    closeNavigation();
/*
                    showActionbarAuction("Notification");

*/
                    hideActionbar();
                }

                break;
            case R.id.lnl_search_setting:
                Fragment fragmentSearchSetting = checkFragmentExist(NameFragment.searchSettingFragment);
                if (fragmentSearchSetting == null) {
                    SearchSettingFragment searchSettingFragment = new SearchSettingFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_TOKEN, getToken);
                    searchSettingFragment.setArguments(bundle);
                    changeFragment(searchSettingFragment, NameFragment.searchFriendFragment);
                    closeNavigation();
                    hideActionbar();
                    /*showActionbarAuction("Search Friend");*/
                }

                break;
            case R.id.lnl_profile:
                Fragment fragmentProfile = checkFragmentExist(NameFragment.editProfileFragment);
                if (fragmentProfile == null) {
                    changeFragment(new EditProfileFragment(), NameFragment.editProfileFragment);
                    closeNavigation();
                }

                break;
            case R.id.lnl_chat:
                Fragment chatFragment = checkFragmentExist(NameFragment.chatFragment);
                if (chatFragment == null) {
                    changeFragment(new ChatFragment(), NameFragment.chatFragment);
                    closeNavigation();
                }

                break;
            case R.id.lnl_aution:
                Fragment autionFragment = checkFragmentExist(NameFragment.autionFragment);
                if (autionFragment == null) {
                    changeFragment(new AuctionFragment(), NameFragment.autionFragment);
                    showActionbarAuction("Auction");
                }
                break;
            case R.id.lnl_give_gift:
                Fragment giveGiftFragment = checkFragmentExist(NameFragment.giveGiftFragment);
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

    public void showActionbarSignUp() {
        if (getSupportActionBar() != null)
            getSupportActionBar().show();
        setUpLoginActionbar("Sign Up");
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

        Fragment activePageSetting = checkFragmentExist(NameFragment.settingFragment);
        if (activePageSetting != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            return;
        }
        Fragment autionFragment = checkFragmentExist(NameFragment.autionFragment);
        if (autionFragment != null) {
            showActionbarAuction("Aution");
            getSupportFragmentManager().popBackStackImmediate(
                    new MainFragment().getClass().getName(), 0);
            return;
        }
        Fragment searchFriendFragment = checkFragmentExist(NameFragment.searchFriendFragment);
        if (searchFriendFragment != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            showActionbarAuction("Search Friend");
            return;
        }
        Fragment giveGiftFragment = checkFragmentExist(NameFragment.giveGiftFragment);
        if (giveGiftFragment != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            hideActionbar();
            return;
        }
        Fragment activePageMain = checkFragmentExist(NameFragment.mainFragmnet);
        if (activePageMain != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            drawerLayout.closeDrawer(Gravity.LEFT);
            showActionbarRecentReport();
            return;
        }


        Fragment activeWelcome = checkFragmentExist(NameFragment.wellcomeFragment);

        Fragment activeLogin = checkFragmentExist(NameFragment.loginFragment);
        if (activeLogin != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            showActionbarLogin();
            getFragmentManager().popBackStack();
            return;
        }


        if (activeWelcome != null) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            hideActionbar();
            return;
        }


    }

    public void hideActionbar() {
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
    }

    @Override
    public void sendToken(String token) {
        getToken = token;
    }
}
