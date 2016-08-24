package key.api;

import android.support.annotation.StringRes;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import fragment.BaseFragment;

/**
 * Created by admin on 8/11/2016.
 */
public class BaseApiFragment extends BaseFragment {
    public static final String error_01 = "{\"code\":01}";
    public static final String error_02 = "{\"code\":02}";
    public static final String error_03 = "{\"code\":03}";
    public static final String error_11 = "{\"code\":11}";
    public static final String error_14 = "{\"code\":14}";
    public static final String error_12 = "{\"code\":12}";
    public static final String error_21 = "{\"code\":21}";
    public static final String error_15 = "{\"code\":15}";
    public static final String error_10 = "{\"code\":10}";
    public static final String error_20 = "{\"code\":20}";
    public static final String error_81 = "{\"code\":81}";


    public void showMessage(String Message) {
        Toast.makeText(getActivity(), Message, Toast.LENGTH_LONG).show();
    }

    public void showMessage(@StringRes int textRes) {
        Toast.makeText(getActivity(), textRes, Toast.LENGTH_LONG).show();
    }

    //FIXME Change the parameter of this method ( the real value is integer )
    public void showError(String s) {
        if (s.equalsIgnoreCase(error_01)) {
            showMessage("UNKNOWN_MESSAGE");
        } else if (s.equalsIgnoreCase(error_02)) {
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
