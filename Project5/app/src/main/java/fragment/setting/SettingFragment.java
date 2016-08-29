package fragment.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import fragment.base.BaseFragment;
import fragment.point.PointFragment;
import fragment.setting.changepassword.ChangePasswordFragment;
import fragment.setting.deactive.DeactivateAccount;
import fragment.setting.distance.DistanceInFragment;
import fragment.setting.notifice.NotificationsFragment;
import fragment.setting.teamofservice.TermOfServiceFragment;
import key.name.fragment.tag.NameFragment;

/**
 * Created by admin on 7/12/2016.
 */
public class SettingFragment extends BaseFragment implements View.OnClickListener/*, CompoundButton.OnCheckedChangeListener*/ {
    private static final int REQUEST_CODE = 1;
    private static final String KEY_SAVING = "key_saving";
    private static final String KEY_SOUND = "key_sound";
    private static final String KEY_VIBRATION = "key_vibration";
    private static final String TAG = "SettingFragment";
    private TextView txtContentSetting, txtSetDistanceReport;
    private CheckBox ckbSound, ckbVibration;
    private String values;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.setting_layout, container, false);
    }

    private void init() {
        sharedPreferences = getActivity().getSharedPreferences(KEY_SAVING, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        init();
        drawerLayout = MainActivity.drawerLayout;
    }

    private void initView(View view) {
        txtContentSetting = (TextView) view.findViewById(R.id.txtContentSetting);
        Button btnSaveSetting = (Button) view.findViewById(R.id.btnSaveSetting);
        LinearLayout lnlNotification = (LinearLayout) view.findViewById(R.id.lnl_notificationRecent);
        lnlNotification.setOnClickListener(this);
        LinearLayout lnlChangePassword = (LinearLayout) view.findViewById(R.id.lnl_change_password);
        lnlChangePassword.setOnClickListener(this);
        LinearLayout lnlDeactivateAccount = (LinearLayout) view.findViewById(R.id.lnlDeactivateAccount);
        lnlDeactivateAccount.setOnClickListener(this);
        LinearLayout lnlTermOfService = (LinearLayout) view.findViewById(R.id.lnl_term_of_service);
        lnlTermOfService.setOnClickListener(this);
        LinearLayout lnlDistanceIn = (LinearLayout) view.findViewById(R.id.lnl_distance);
        lnlDistanceIn.setOnClickListener(this);
        txtSetDistanceReport = (TextView) view.findViewById(R.id.txt_set_report);
        ckbSound = (CheckBox) view.findViewById(R.id.ckb_sound);
        ckbVibration = (CheckBox) view.findViewById(R.id.ckb_vibration);
       /* ckbVibration.setOnCheckedChangeListener(this);
        ckbSound.setOnCheckedChangeListener(this);*/
        ImageView imvOpenDrawerLayout = (ImageView) view.findViewById(R.id.imvOpenDrawer);
        imvOpenDrawerLayout.setOnClickListener(this);
        btnSaveSetting.setOnClickListener(this);
        ckbSound.setOnClickListener(this);
        ckbVibration.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lnl_notificationRecent:
                NotificationsFragment notificationsFragment = new NotificationsFragment();
                changeFragment(notificationsFragment, NameFragment.notificationFragment);
                closeDrawerLayout();
                break;
            case R.id.lnl_change_password:
                changeFragment(new ChangePasswordFragment(), NameFragment.changePasswordFragment);
                closeDrawerLayout();
                break;
            case R.id.lnlDeactivateAccount:
                changeFragment(new DeactivateAccount(), NameFragment.DeactivateAccountFragment);
                closeDrawerLayout();
                break;
            case R.id.lnl_term_of_service:
                changeFragment(new TermOfServiceFragment(), NameFragment.TermOfServiceFragment);
                closeDrawerLayout();
                break;
            case R.id.lnl_distance:
                DistanceInFragment distanceInFragment = new DistanceInFragment();
                distanceInFragment.setTargetFragment(this, REQUEST_CODE);
                changeFragment(distanceInFragment, NameFragment.DistanceInFragment);
                closeDrawerLayout();
                break;
            case R.id.imvOpenDrawer:
                openDrawerLayout();
                break;
            case R.id.lnl_point:
                getFragmentManager().beginTransaction().replace(R.id.sub_screen, new PointFragment(), "").addToBackStack(null).commit();
                break;
            case R.id.btnSaveSetting:
                Toast.makeText(getActivity(), "Save Succesfuly", Toast.LENGTH_LONG).show();
                break;
            case R.id.ckb_sound:
                if (ckbSound.isChecked()) {
                    editor.putBoolean(KEY_SOUND, true);
                } else {
                    editor.putBoolean(KEY_SOUND, false);
                }
                editor.commit();

                break;
            case R.id.ckb_vibration:
                if (ckbVibration.isChecked()) {
                    editor.putBoolean(KEY_VIBRATION, true);
                } else {
                    editor.putBoolean(KEY_VIBRATION, false);
                }
                editor.commit();

                break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DistanceInFragment.REQUEST_CODE) {
            values = data.getStringExtra(DistanceInFragment.KEY_DATA_DISTANCE);
            Log.e(TAG, values);
        } else {
            Log.e(TAG, "error");
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        drawerLayout.closeDrawer(Gravity.LEFT);
        txtSetDistanceReport.setText(values);
        restoreDataSharePreference();
        resumeDistaninValues();
        ((MainActivity) getActivity()).hideActionbar();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void restoreDataSharePreference() {
        boolean ckbCheckSound = sharedPreferences.getBoolean(KEY_SOUND, false);
        ckbSound.setChecked(ckbCheckSound);
        boolean ckbViReciver = sharedPreferences.getBoolean(KEY_VIBRATION, false);
        ckbVibration.setChecked(ckbViReciver);
    }

    // fix lỗi
    /*@Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (ckbSound.isChecked()) {
            editor.putBoolean(KEY_SOUND, true);
        } else {
            editor.putBoolean(KEY_SOUND, false);
        }
        if (ckbVibration.isChecked()) {
            editor.putBoolean(KEY_VIBRATION, true);
        } else {
            editor.putBoolean(KEY_VIBRATION, false);
        }
        editor.commit();
    }*/
    private void resumeDistaninValues() {
        SharedPreferences shareDistance = getActivity().getSharedPreferences(DistanceInFragment.KEY_SAVING_DISTANCE_IN, Activity.MODE_PRIVATE);
        String dt = shareDistance.getString(DistanceInFragment.KEY_TOTAL_VALUES, "");
        txtSetDistanceReport.setText(dt);
    }
}
