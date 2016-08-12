package fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
               /* if () {
                    MainFragment main = new MainFragment();
                    changeFragment(main, NameFragment.mainFragmnet);
                } else {
                    showDialogError();
                }*/
                new AsyncLogin().execute(edtUsername.getText().toString(), edtPassword.getText().toString());
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

    private class AsyncLogin extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(getActivity());
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your php file resides
                url = new URL("http://14.160.24.93:9119?email="+params[0]+"&original_pwd="+params[1]);

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "exception";
            }
            try {
                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
               /* conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);*/
                conn.setRequestMethod("POST");

                // setDoInput and setDoOutput method depict handling of both send and receive
                conn.setDoInput(true);
                conn.setDoOutput(true);

                // Append parameters to URL
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("email", params[0])
                        .appendQueryParameter("password", params[1]);
                String query = builder.build().getEncodedQuery();

                // Open connection for sending data
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "exception";
            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread

            pdLoading.dismiss();

            if (result.equalsIgnoreCase("")) {
                /* Here launching another activity when login successful. If you persist login state
                use sharedPreferences of Android. and logout button to clear sharedPreferences.
                 */
                Toast.makeText(getActivity(), "Login thanh cong", Toast.LENGTH_LONG).show();


            } else if (result.equalsIgnoreCase("INCORRECT_PASSWORD")) {

                // If username and password does not match display a error message
                Toast.makeText(getActivity(), "Invalid email or password", Toast.LENGTH_LONG).show();

            }
        }


    }
}
