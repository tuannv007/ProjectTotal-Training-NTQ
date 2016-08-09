package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
    private TextView txtContentNotification;
    private Button btnSaveNotification, btnBack;
    private CheckBox ckbBuzz, ckbSomeOne, ckbAlerts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notification_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtContentNotification = (TextView) view.findViewById(R.id.txtContentHeader);
        btnSaveNotification = (Button) view.findViewById(R.id.btnForgot);
        txtContentNotification.setText(R.string.notification);
        btnSaveNotification.setText(R.string.save);
        ckbAlerts = (CheckBox) view.findViewById(R.id.ckb_alerts);
        ckbBuzz = (CheckBox) view.findViewById(R.id.ckb_buzz);
        ckbSomeOne = (CheckBox) view.findViewById(R.id.ckb_some_one);
        btnBack = (Button) view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                goBack();
                openDrawerLayout();
                break;
        }
    }
}
