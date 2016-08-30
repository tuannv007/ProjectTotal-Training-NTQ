package com.example.admin.project1final;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import fragment.chat.ChatFragment;
import key.name.fragment.tag.NameFragment;

/**
 * Created by admin on 7/24/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    void changeFragment(Fragment myFragment, String Tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main, myFragment, Tag).addToBackStack(Tag).commit();
    }

    public void setUpActionbarAuction(String contentText) {
        drawerLayout = MainActivity.drawerLayout;
        if (getSupportActionBar() == null) return;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.menu_drawer);
        View view = getSupportActionBar().getCustomView();
        ImageView imvOpen = (ImageView) view.findViewById(R.id.imvDrawerOpenAution);
        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0, 0);
        imvOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        TextView txtTitle = (TextView) view.findViewById(R.id.txt_title);
        FrameLayout frmChatMessage = (FrameLayout) view.findViewById(R.id.frm_chat_message_aution);
        frmChatMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new ChatFragment(), NameFragment.chatFragment);
            }
        });
        txtTitle.setText(contentText);
    }

    public void setUpRecenreport(String contentText) {
        drawerLayout = MainActivity.drawerLayout;
        if (getSupportActionBar() == null) return;
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBar ab = getSupportActionBar();
        ab.setCustomView(R.layout.header_setting_layout);
        View v = LayoutInflater
                .from(ab.getThemedContext())
                .inflate(R.layout.header_setting_layout, null);
        ImageView imvOpen = (ImageView) v.findViewById(R.id.imvOpenDrawer);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT);
        ab.setCustomView(v, params);
        Toolbar parent = (Toolbar) v.getParent();
        parent.setContentInsetsAbsolute(0, 0);
        imvOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        TextView mTitleTextView = (TextView) v.findViewById(R.id.txtContentSetting);
        mTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mTitleTextView.setText(contentText);
    }

    public void setUpLoginActionbar(String contentText) {
        drawerLayout = MainActivity.drawerLayout;
        if (getSupportActionBar() == null) return;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.header_layout);
        View view = getSupportActionBar().getCustomView();
        Button btnBack = (Button) view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        TextView mTitleTextView = (TextView) view.findViewById(R.id.txtContentHeader);
        Toolbar parent = (Toolbar) view.getParent();
        parent.setContentInsetsAbsolute(0, 0);
        mTitleTextView.setText(contentText);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return false;
    }
}
