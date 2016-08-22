package key.api;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

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
import java.util.HashMap;

import fragment.BaseFragment;
import fragment.LoginFragment;
import key.name.fragment.tag.NameFragment;

/**
 * Created by admin on 8/11/2016.
 */
public class BaseApiFragment extends BaseFragment {
    public static final String error_01 = "{\"code\":01}";
    public static final String error_02 = "{\"code\":02}";
    public static final String error_03 = "{\"code\":03}";
    public static final String error_11 =  "{\"code\":11}";
    public static final String error_14 =  "{\"code\":14}";
    public static final String error_12 =  "{\"code\":12}";
    public static final String error_21 =  "{\"code\":21}";
    public static final String error_15 =  "{\"code\":15}";
    public static final String error_10 =  "{\"code\":10}";
    public static final String error_20 =  "{\"code\":20}";
    public static final String error_81 =  "{\"code\":81}";


    public void showMessage(String Message) {
        Toast.makeText(getActivity(), Message, Toast.LENGTH_LONG).show();
    }

    public void showError(String s) {
        if (s.equalsIgnoreCase(error_01)) {
            showMessage("UNKNOWN_MESSAGE");
        }
        else if (s.equalsIgnoreCase(error_02)) {
            showMessage("WRONG_DATA_FORMAT");
        }
    }
    protected String md5(String s) {
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

}
