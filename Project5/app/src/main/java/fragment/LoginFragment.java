package fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import key.name.fragment.tag.NameFragment;

/**
 * Created by admin on 7/7/2016.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private static final String KEY_SAVING_LOGIN = "key_saving_login";
    private static final String KEY_PASSWORD = "key_password";
    private static final String KEY_USERNAME = "key_username";
    private EditText edtUsername, edtPassword;
    private Button btnLogin, btnBack, btnForgot;
    private AlertDialog.Builder alertDialog;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View view) {
        edtUsername = (EditText) view.findViewById(R.id.edtUsername);
        edtPassword = (EditText) view.findViewById(R.id.edtPassword);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        alertDialog = new AlertDialog.Builder(getActivity());
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                if ("admin".equals(edtUsername.getText().toString()) && "admin".equals(edtPassword.getText().toString())) {
                    MainFragment main = new MainFragment();
                    changeFragment(main, NameFragment.mainFragmnet);
                } else {
                    showDialogError();
                }
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        saveUsernameAndPassword();
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).showActionbarLogin();
        restoreLogin();
    }

    private void showDialogError() {
        alertDialog.setTitle("Login error !");
        alertDialog.setMessage("ReInput Email or Password");
        alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        alertDialog.create();
        alertDialog.show();
    }

    private void saveUsernameAndPassword() {
        sharedPreferences = getActivity().getSharedPreferences(KEY_SAVING_LOGIN, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (!edtUsername.getText().toString().isEmpty() && !edtPassword.getText().toString().isEmpty()) {
            editor.putString(KEY_USERNAME, edtUsername.getText().toString());
            editor.putString(KEY_PASSWORD, edtPassword.getText().toString());
        }
        editor.apply();
    }

    private void restoreLogin() {
        sharedPreferences = getActivity().getSharedPreferences(KEY_SAVING_LOGIN, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(KEY_USERNAME, "");
        String password = sharedPreferences.getString(KEY_PASSWORD, "");
        edtPassword.setText(password);
        edtUsername.setText(username);
    }
}
