package key.api;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import fragment.BaseFragment;

/**
 * Created by admin on 8/11/2016.
 */
public class BaseApiFragment extends BaseFragment {
    public static final String error_01 = "{\"code\":1}";
    public static final String error_02 = "{\"code\":2}";
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

    public void showError(String s, Fragment myFragment,String Tag) {
        if (s.equalsIgnoreCase(error_01)) {
            showMessage("UNKNOWN_MESSAGE");
        }else if (s.equalsIgnoreCase(error_10)){
            showMessage("Email not found ! pleas sign in");
        }else if (s.equalsIgnoreCase(error_20)){
            showMessage("Input correct password");
        }else if (s.equalsIgnoreCase(error_81)){
            showMessage("Looked user by admin");
        }
        else if (s.equalsIgnoreCase(error_02)) {
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
          /*  showMessage("REGISTER SUCCESSFULLY");*/
            changeFragment(myFragment,Tag);
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

    protected String sendRequest(String url, String inputString, int timeoutConnect, int timeoutRead) {
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
            //set time out
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
}
