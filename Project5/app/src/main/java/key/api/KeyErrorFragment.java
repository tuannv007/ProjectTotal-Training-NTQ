package key.api;

import android.widget.Toast;

import fragment.BaseFragment;

/**
 * Created by admin on 8/11/2016.
 */
public class KeyErrorFragment extends BaseFragment {
    public static final String error_01 = "{\"code\":1}";
    public static final String error_02 = "{\"code\":2}";
    public static final String error_11 =  "{\"code\":11}";
    public static final String error_14 =  "{\"code\":14}";
    public static final String error_12 =  "{\"code\":12}";
    public static final String error_21 =  "{\"code\":21}";
    public static final String error_15 =  "{\"code\":15}";


    private void showMessage(String Message) {
        Toast.makeText(getActivity(), Message, Toast.LENGTH_LONG).show();
    }

    public void showError(String s) {
        if (s.equalsIgnoreCase(error_01)) {
            showMessage("UNKNOWN_MESSAGE");
        } else if (s.equalsIgnoreCase(error_02)) {
            showMessage("WRONG_DATA_FORMAT");
        } else if (s.equalsIgnoreCase(error_11)) {
            showMessage("INVALID_EMAIL");
        } else if (s.equalsIgnoreCase(error_12)) {
            showMessage("EMAIL_REGISTERED");
        } else if (s.equalsIgnoreCase(error_14)) {
            showMessage("INVALID_USER_NAME");
        } else if (s.equalsIgnoreCase(error_21)) {
            showMessage("INVALID_PASSWORD");
        }else if (s.equalsIgnoreCase(error_15)){
            showMessage("ERROR");
        }else {
            showMessage("REGISTER SUCCESSFULLY");
        }

    }

}
