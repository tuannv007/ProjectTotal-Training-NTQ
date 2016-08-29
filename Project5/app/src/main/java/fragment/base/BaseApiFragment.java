package fragment.base;

import android.support.annotation.StringRes;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by admin on 8/11/2016.
 */
public class BaseApiFragment extends BaseFragment {
    public static final int error_01 = 1;
    public static final int error_02 = 2;
    public static final int error_03 = 3;
    public static final int error_11 = 11;
    public static final int error_14 = 14;
    public static final int error_12 = 12;
    public static final int error_21 = 21;
    public static final int error_15 = 15;
    public static final int error_10 = 10;
    public static final int error_20 = 20;
    public static final int error_81 = 81;


    public void showToastMessage(String Message) {
        Toast.makeText(getActivity(), Message, Toast.LENGTH_LONG).show();
    }

    public void showToastMessage(@StringRes int textRes) {
        Toast.makeText(getActivity(), textRes, Toast.LENGTH_LONG).show();
    }

    //FIXME Change the parameter of this method ( the real value is integer )
    public void showResultFromServer(int values) {
        if (values == error_01) {
            showToastMessage("UNKNOWN_MESSAGE");
        } else if (values == error_02) {
            showToastMessage("WRONG_DATA_FORMAT");
        }
    }

    protected String convertToMd5(String s) {
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
