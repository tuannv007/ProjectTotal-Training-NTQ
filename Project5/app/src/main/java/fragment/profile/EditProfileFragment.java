package fragment.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import fragment.base.BaseFragment;
import fragment.dialog.MyDialogShowRelationship;

/**
 * Created by admin on 7/19/2016.
 */
public class EditProfileFragment extends BaseFragment implements View.OnClickListener {
    private static final int REQUEST_CODE = 4;
    private static final String KEY_SAVING_EDIT_PROFILE = "key_saving_edit_profile";
    private static final String KEY_INFORMATION = "key_information";
    private FragmentManager manager;
    private TextView txtStatus;
    private String values;
    private SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.editprofile_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View btnCancel = view.findViewById(R.id.btnCancelEditProfile);
        RelativeLayout rltRelationship = (RelativeLayout) view.findViewById(R.id.rlt_relationship);
        rltRelationship.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        manager = getFragmentManager();
        txtStatus = (TextView) view.findViewById(R.id.txtStatus);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlt_relationship:
                MyDialogShowRelationship dialogShowRelationship = new MyDialogShowRelationship();
                dialogShowRelationship.setTargetFragment(this, REQUEST_CODE);
                dialogShowRelationship.show(manager, "");
                this.onPause();
                break;
            case R.id.btnCancelEditProfile:
                goBack();
                openDrawerLayout();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EditProfileFragment.REQUEST_CODE) {
            values = data.getStringExtra(MyDialogShowRelationship.KEY_DIALOG);
            txtStatus.setText(values);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        restoreDataSharePreference();
        ((MainActivity) getActivity()).hideActionbar();
    }

    @Override
    public void onPause() {
        super.onPause();
        saveDataBySharePreference();
    }

    private void saveDataBySharePreference() {
        sharedPreferences = getActivity().getSharedPreferences(KEY_SAVING_EDIT_PROFILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (values != null)
            editor.putString(KEY_INFORMATION, values);
        editor.apply();
    }

    private void restoreDataSharePreference() {
        sharedPreferences = getActivity().getSharedPreferences
                (KEY_SAVING_EDIT_PROFILE, Context.MODE_PRIVATE);
        //lấy giá trị checked ra, nếu không thấy thì giá trị mặc định là false
        String dt = sharedPreferences.getString(KEY_INFORMATION, "");
        if (dt.equals("")) return;
        txtStatus.setText(dt);
    }
}
