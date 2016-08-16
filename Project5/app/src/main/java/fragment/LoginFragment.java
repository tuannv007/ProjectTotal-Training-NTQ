package fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import org.json.JSONException;
import org.json.JSONObject;

import key.api.BaseApiFragment;
import key.api.KeyParam;
import key.name.fragment.tag.NameFragment;
import user.User;

/**
 * Created by admin on 7/7/2016.
 */
public class LoginFragment extends BaseApiFragment implements View.OnClickListener {
    private static final String KEY_SAVING_LOGIN = "key_saving_login";
    private static final String KEY_PASSWORD = "key_password";
    private static final String KEY_USERNAME = "key_username";
    private EditText edtUsername, edtPassword;
    private Button btnLogin, btnBack, btnForgot;
    private AlertDialog.Builder alertDialog;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private User user;

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
               /* if () {
                    MainFragment main = new MainFragment();
                    changeFragment(main, NameFragment.mainFragmnet);
                } else {
                    showDialogError();
                }*/
                loginUser();
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

    private void loginUser() {
        String email = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (email.isEmpty()) {
            showMessage("Email not empty");
        } else if (password.isEmpty()) {
            showMessage("Password not empty");
        } else {
            user = new User();
            user.setEmail(email);
            user.setPassword(password);
            new LoginAsyncTask().execute(KeyParam.mUrl, user.getEmail(), md5(user.getPassword()));
        }
    }

    private class LoginAsyncTask extends AsyncTask<String, Void, String> {
        private String s;

        @Override
        protected String doInBackground(String... params) {
            JSONObject object = new JSONObject();

            try {
                String keyLogin = "login";
                String keyAndroid = "android";
                object.put(KeyParam.KeyApi, keyLogin);
                object.put(KeyParam.KeyApiEmail, params[1]);
                object.put(KeyParam.KeyApiPassword, params[2]);
                object.put(KeyParam.KeyApiDeviceID, keyAndroid);
                object.put(KeyParam.KeyApiNotifyToken, "sjdks");
                object.put(KeyParam.KeyApiDeviceType, KeyParam.Android);
                object.put(KeyParam.KeyApiLoginTime, "20160223123412");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            s = sendRequest(params[0], object.toString(), 15000, 15000);

            return s;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonReader = new JSONObject(s);
                JSONObject jSonObject = jsonReader.getJSONObject("data");
                String token = jSonObject.getString("token");
                String ueser_id =jSonObject.getString("user_id");
                Log.i("tag",token);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            showError(s, new MainFragment(), NameFragment.mainFragmnet);
        }
    }
}
