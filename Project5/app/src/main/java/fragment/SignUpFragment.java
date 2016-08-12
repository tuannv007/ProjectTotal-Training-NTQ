package fragment;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;

import key.api.KeyErrorFragment;
import user.User;

/**
 * Created by admin on 8/10/2016.
 */
public class SignUpFragment extends KeyErrorFragment implements View.OnClickListener {
    protected EditText edtEmail, edtPassword, edtUsername, edtBirthDay;
    private User users;
    private SimpleDateFormat dateFormatter;
    private Calendar newCalendar;
    private DatePickerDialog fromDatePickerDialog;
    private RadioButton rdbMale, rdbFemale;
    private RadioGroup rdbGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.signup_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtEmail = (EditText) view.findViewById(R.id.edt_register_mail);
        edtPassword = (EditText) view.findViewById(R.id.edt_register_password);
        Button btnRegister = (Button) view.findViewById(R.id.btn_register);
        edtUsername = (EditText) view.findViewById(R.id.edt_username);
        edtBirthDay = (EditText) view.findViewById(R.id.edt_birthday);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        rdbMale = (RadioButton) view.findViewById(R.id.rdb_gender_male);
        rdbFemale = (RadioButton) view.findViewById(R.id.rdb_gender_female);
        rdbGroup = (RadioGroup) view.findViewById(R.id.group);
        newCalendar = Calendar.getInstance();
        configDialog();
        btnRegister.setOnClickListener(this);
        edtBirthDay.setOnClickListener(this);
        ((MainActivity)getActivity()).showActionbarSignUp();
    }

    private void configDialog() {
        fromDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                edtBirthDay.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }

    private void registerUser() {
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        String username = edtUsername.getText().toString();
        String birthday = edtBirthDay.getText().toString();
        String birthDayConfig = birthday.replace("-", "");

        users = new User();
        users.setEmail(email);
        users.setPassword(password);
        users.setUsername(username);
        users.setBirthday(birthDayConfig);
        users.setGender(getGender());
        if (email.isEmpty()) {
            Toast.makeText(getActivity(), "Email not empty", Toast.LENGTH_LONG).show();
        } else if (password.isEmpty()) {
            Toast.makeText(getActivity(), "Password not empty", Toast.LENGTH_LONG).show();
        } else if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(getActivity(), "Email and Password not empty", Toast.LENGTH_LONG).show();
        } else {
            new RegisterAsyncTask().execute("http://14.160.24.93:9119");
        }

    }

    private int getGender() {
        if (rdbFemale.isChecked()) return 0;
        else return 1;
    }

    private class RegisterAsyncTask extends AsyncTask<String, Void, String> {

        private String s;

        @Override
        protected String doInBackground(String... params) {
            final JSONObject object = new JSONObject();
            try {
                object.put("api", "register_version_2");
                object.put("user_name", users.getUsername());
                object.put("email", users.getEmail());
                object.put("pwd", md5(users.getPassword()));
                object.put("bir", users.getBirthday());
                object.put("inters_in", 0);
                object.put("device_id", "android");
                object.put("notify_token", "sjdks");
                object.put("device_type", 0);
                object.put("login_time", "20120223123412");
                object.put("ivt_code", "gshd");
                object.put("original_pwd", users.getPassword());
                object.put("gender", users.getGender());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            s = sendRequest(params[0], object.toString(), 15000, 15000);
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            showError(s);
        }


    }


    private String md5(String s) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            BigInteger i = new BigInteger(1, m.digest());
            return String.format("%1$032x", i);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String sendRequest(String url, String inputString, int timeoutConnect, int timeoutRead) {
        String outputData;
        StringBuilder postData = new StringBuilder();
        URL u;
        HttpURLConnection conn = null;
        OutputStream out;
        InputStreamReader isr;
        BufferedReader buf;
        try {
            u = new URL(url);

            //open connection
            conn = (HttpURLConnection) u.openConnection();
            conn.setConnectTimeout(timeoutConnect);
            conn.setReadTimeout(timeoutRead);


            // post method
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            // data to send
            postData.append(inputString);
            String encodedData = postData.toString();
            // send data by byte
            conn.setRequestProperty("Content-Language", "en-US");
            conn.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            conn.setRequestProperty("Content-Length",
                    Integer.toString(encodedData.getBytes().length));
            byte[] postDataByte = postData.toString().getBytes("UTF-8");
            out = conn.getOutputStream();
            out.write(postDataByte);

            // get data from server
            isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
            buf = new BufferedReader(isr);
            // write
            outputData = buf.readLine();
            if (out != null)
                out.close();
            isr.close();
            buf.close();
            return outputData;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.disconnect();
        }
        return "";
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                registerUser();
                break;
            case R.id.edt_birthday:
                fromDatePickerDialog.show();
                break;

        }
    }

}