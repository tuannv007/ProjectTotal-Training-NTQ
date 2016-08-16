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

import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import key.api.BaseApiFragment;
import key.api.KeyParam;
import key.name.fragment.tag.NameFragment;
import user.User;

/**
 * Created by admin on 8/10/2016.
 */
public class SignUpFragment extends BaseApiFragment implements View.OnClickListener {
    protected EditText edtEmail, edtPassword, edtUsername, edtBirthDay;
    private User user;
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
        ((MainActivity) getActivity()).showActionbarSignUp();
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

        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        user.setBirthday(birthDayConfig);
        user.setGender(getGender());
        if (email.isEmpty()) {
            Toast.makeText(getActivity(), "Email not empty", Toast.LENGTH_LONG).show();
        } else if (password.isEmpty()) {
            Toast.makeText(getActivity(), "Password not empty", Toast.LENGTH_LONG).show();
        } else if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(getActivity(), "Email and Password not empty", Toast.LENGTH_LONG).show();
        } else {
            new RegisterAsyncTask().execute(KeyParam.mUrl);
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
                object.put(KeyParam.KeyApi, "register_version_2");
                object.put(KeyParam.KeyApiUserName, user.getUsername());
                object.put(KeyParam.KeyApiEmail, user.getEmail());
                object.put(KeyParam.KeyApiPassword, md5(user.getPassword()));
                object.put(KeyParam.KeyApiBirthDay, user.getBirthday());
                object.put(KeyParam.KeyApiInterIn, 0);
                object.put(KeyParam.KeyApiDeviceID, "android");
                object.put(KeyParam.KeyApiNotifyToken, "sjdks");
                object.put(KeyParam.KeyApiDeviceType, KeyParam.Android);
                object.put(KeyParam.KeyApiLoginTime, "20120223123412");
                object.put(KeyParam.KeyApiIvtCode, "gshd");
                object.put(KeyParam.KeyApiOriginalPass, user.getPassword());
                object.put(KeyParam.KeyApiGender, user.getGender());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            s = sendRequest(params[0], object.toString(), 15000, 15000);
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            showError(s, new LoginFragment(), NameFragment.loginFragment);
        }


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