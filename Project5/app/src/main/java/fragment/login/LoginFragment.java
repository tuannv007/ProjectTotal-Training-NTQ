package fragment.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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

import fragment.base.BaseApiFragment;
import fragment.resenreport.MainFragment;
import fragment.signup.SignUpFragment;
import key.api.KeyParam;
import key.name.fragment.tag.NameFragment;
import singleton.pattemdesign.MySingleton;
import user.User;

/**
 * Created by admin on 7/7/2016.
 */
public class LoginFragment extends BaseApiFragment implements View.OnClickListener {
    private static final String KEY_SAVING_LOGIN = "key_saving_login";
    private static final String KEY_PASSWORD = "key_password";
    private static final String KEY_USERNAME = "key_username";
    private EditText edtUsername, edtPassword;
    private Button btnBack;
    private Button btnForgot;
    private AlertDialog.Builder alertDialog;
    private SharedPreferences sharedPreferences;
    private User user;
    private String tokenUserSignUp;
    private String emailReceiveFromSignUp;
    private String passwordReceiveFromSignUp;
    private ProgressDialog dialog;
    private int resultFromServer;
    private pushToken listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment_layout, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) return;
        else {
            emailReceiveFromSignUp = getArguments().getString(SignUpFragment.KEY_EMAIL);
            passwordReceiveFromSignUp = getArguments().getString(SignUpFragment.KEY_PASSWORD);

        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        edtUsername.setText(emailReceiveFromSignUp);
        edtPassword.setText(passwordReceiveFromSignUp);
    }

    private void initView(View view) {
        edtUsername = (EditText) view.findViewById(R.id.edtUsername);
        edtPassword = (EditText) view.findViewById(R.id.edtPassword);
        Button btnLogin = (Button) view.findViewById(R.id.btnLogin);
        alertDialog = new AlertDialog.Builder(getActivity());
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                showProgressbar();
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
            restoreUsernameAndPassword();
    }

    private void saveUsernameAndPassword() {
        sharedPreferences = getActivity().getSharedPreferences(KEY_SAVING_LOGIN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!edtUsername.getText().toString().isEmpty() && !edtPassword.getText().toString().isEmpty()) {
            editor.putString(KEY_USERNAME, edtUsername.getText().toString());
            editor.putString(KEY_PASSWORD, edtPassword.getText().toString());
        }
        editor.apply();
    }

    private void restoreUsernameAndPassword() {
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
            showToastMessage(getString(R.string.emailNotEmpty));
        } else if (password.isEmpty()) {
            showToastMessage(getString(R.string.passwordNotEmpty));
        } else {
            user = new User();
            user.setEmail(emailReceiveFromSignUp);
            user.setPassword(passwordReceiveFromSignUp);
            if (getArguments() == null) {
                user.setEmail(email);
                user.setPassword(password);
            }
            pushDataToServer();
        }
    }

    private void showProgressbar() {
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage(getString(R.string.loading));
        dialog.show();
    }

    private void pushDataToServer() {
        HashMap<String, Object> object = new HashMap<>();
        String keyLogin = "login";
        String keyAndroid = "android";

        object.put(KeyParam.KeyApi, keyLogin);
        object.put(KeyParam.KeyApiEmail, user.getEmail());
        object.put(KeyParam.KeyApiPassword, convertToMd5(user.getPassword()));
        object.put(KeyParam.KeyApiDeviceID, keyAndroid);
        object.put(KeyParam.KeyApiNotifyToken, "sjdks");
        object.put(KeyParam.KeyApiDeviceType, KeyParam.Android);
        object.put(KeyParam.KeyApiLoginTime, "20160223123412");

        RequestQueue queue = MySingleton.getInstance(getActivity()).
                getRequestQueue();
        String mUrl = KeyParam.mUrl;

        JsonObjectRequest request = new JsonObjectRequest(mUrl, new JSONObject(object),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("tag", response.toString());
                        dialog.dismiss();
                        try {
                            resultFromServer = response.getInt("code");
                            if (resultFromServer == 0) {
                                JSONObject reJsonObject = response.getJSONObject("data");
                                tokenUserSignUp = reJsonObject.getString("tokenUserSignUp");
                                listener.sendToken(tokenUserSignUp);
                            }

                            Log.e("demo", resultFromServer + "");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        /*showResultFromServer(response.toString());*/
                        showResultFromServer(resultFromServer);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        queue.add(request);
        MySingleton.getInstance(getActivity()).addToRequestQueue(request);
    }

    public void showResultFromServer(int values) {
        super.showResultFromServer(values);
        if (values == (error_02)) {
            showToastMessage(getString(R.string.WRONG_DATA_FORMAT));
        } else if (values == (error_10)) {
            showToastMessage(getString(R.string.EMAIL_NOT_FOUND));
        } else if (values == (error_20)) {
            showToastMessage(getString(R.string.INCORRECT_PASSWORD));
        } else if (values == (error_81)) {
            showToastMessage(getString(R.string.LOCKED_USER));
        } else {
            showToastMessage(getString(R.string.LoginSuccessfully));
            changeFragment(new MainFragment(), NameFragment.mainFragmnet);
        }
    }

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
