package fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.admin.project1final.R;

/**
 * Created by admin on 7/12/2016.
 */
public class NotificationsFragment extends BaseFragment implements View.OnClickListener {
    private static final String KEY_ALERT = "key_alert";
    private static final String KEY_SOMEONE = "key_someone";
    private static final String KEY_BUZZ = "key_buzz";
    private CheckBox ckbBuzz, ckbSomeOne, ckbAlerts;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String KEY_NOTIFICATION="key_notification";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notification_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtContentNotification = (TextView) view.findViewById(R.id.txtContentHeader);
        Button btnSaveNotification = (Button) view.findViewById(R.id.btnForgot);
        txtContentNotification.setText(R.string.notification);
        btnSaveNotification.setText(R.string.save);
        ckbAlerts = (CheckBox) view.findViewById(R.id.ckb_alerts);
        ckbBuzz = (CheckBox) view.findViewById(R.id.ckb_buzz_notification);
        ckbSomeOne = (CheckBox) view.findViewById(R.id.ckb_some_one);
        Button btnBack = (Button) view.findViewById(R.id.btnBack);
        ckbAlerts.setOnClickListener(this);
        ckbBuzz.setOnClickListener(this);
        ckbSomeOne.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        sharedPreferences = getActivity().getSharedPreferences(KEY_NOTIFICATION, Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                goBack();
                openDrawerLayout();
                break;
            case R.id.ckb_alerts:
               saveToSharePre(ckbAlerts,KEY_ALERT);
                break;
            case R.id.ckb_buzz_notification:
                saveToSharePre(ckbBuzz,KEY_BUZZ);
                break;
            case R.id.ckb_some_one :
                saveToSharePre(ckbSomeOne,KEY_SOMEONE);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        restoreDataFromSharePre();
    }

    private void saveToSharePre(CheckBox checked, String key){
        editor=sharedPreferences.edit();
        if (checked.isChecked()){
            editor.putBoolean(key,true);
        }else{
            editor.putBoolean(key,false);
        }
        editor.apply();
    }
    private void restoreDataFromSharePre(){
        boolean ckbRestoreBuzz = sharedPreferences.getBoolean(KEY_BUZZ, false);
        ckbBuzz.setChecked(ckbRestoreBuzz);
        boolean ckbRestoreAlert = sharedPreferences.getBoolean(KEY_ALERT, false);
        ckbAlerts.setChecked(ckbRestoreAlert);
        boolean ckbRestoreSomeOne = sharedPreferences.getBoolean(KEY_SOMEONE, false);
        ckbSomeOne.setChecked(ckbRestoreSomeOne);
    }
}
