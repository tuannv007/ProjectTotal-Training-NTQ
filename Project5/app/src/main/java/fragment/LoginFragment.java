package fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

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
    private String token;
    private String email;
    private String password;
    private String emailRecever;
    private String passwordRecever;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment_layout, container, false);

    }

  /*  public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) return;
        else {
            emailRecever = getArguments().getString(SignUpFragment.KEY_EMAIL);
            passwordRecever = getArguments().getString(SignUpFragment.KEY_PASSWORD);

        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        edtUsername.setText(emailRecever);
        edtPassword.setText(passwordRecever);
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
        if (getArguments() == null)
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
        email = edtUsername.getText().toString();
        password = edtPassword.getText().toString();

        if (email.isEmpty()) {
            showMessage("Email not empty");
        } else if (password.isEmpty()) {
            showMessage("Password not empty");
        } else {
            user = new User();
            user.setEmail(emailRecever);
            user.setPassword(passwordRecever);
            if (getArguments() == null) {
                user.setEmail(email);
                user.setPassword(password);
            }
            postDataLogin();
        }
    }

    private void postDataLogin() {
        HashMap<String, Object> object = new HashMap<>();
        String keyLogin = "login";
        String keyAndroid = "android";
        object.put(KeyParam.KeyApi, keyLogin);
        object.put(KeyParam.KeyApiEmail, user.getEmail());
        object.put(KeyParam.KeyApiPassword, md5(user.getPassword()));
        object.put(KeyParam.KeyApiDeviceID, keyAndroid);
        object.put(KeyParam.KeyApiNotifyToken, "sjdks");
        object.put(KeyParam.KeyApiDeviceType, KeyParam.Android);
        object.put(KeyParam.KeyApiLoginTime, "20160223123412");
        RequestQueue mRequestQueue = Volley.newRequestQueue(getActivity());
        String mUrl = KeyParam.mUrl;
        JsonObjectRequest request = new JsonObjectRequest(mUrl, new JSONObject(object),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("tag", response.toString());
                        try {
                            JSONObject reJsonObject = response.getJSONObject("data");
                            token = reJsonObject.getString("token");
                            listener.sendToken(token);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        showErrorLogin(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        mRequestQueue.add(request);
    }

    private void showErrorLogin(String s) {
        showError(s);
        if (s.equalsIgnoreCase(error_02)) {
            showMessage("WRONG_DATA_FORMAT");
        } else if (s.equalsIgnoreCase(error_10)) {
            showMessage("EMAIL_NOT_FOUND");
        } else if (s.equalsIgnoreCase(error_20)) {
            showMessage("INCORRECT_PASSWORD");
        } else if (s.equalsIgnoreCase(error_81)) {
            showMessage(" LOCKED _USER");
        } else {
            showMessage("Login Successfully");
            changeFragment(new MainFragment(), NameFragment.mainFragmnet);
        }

    }

    private pushToken listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof pushToken)
            listener = (pushToken) getActivity();
        else
            throw new ClassCastException(context.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");

    }

    public interface pushToken {
        void sendToken(String token);
    }
}
