package location;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.tuannv007.weatherforecast.R;

import org.json.JSONException;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;

import base.BaseFragment;


/**
 * Created by admin on 8/28/2016.
 */
public class MyDefaultLocation extends BaseFragment {
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000;
    private static final float MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 0;
    private TextView txtDate;
    private String longitude, latitude;
    private String linkDefaultLocation = "";

    private String TAG = "MyDefaultLocation";
    private ProgressDialog dialog;
    private CoordinatorLayout coordinatorLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.default_location_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        getDateDefault();
        getDefaultLocation();
        showDialog();
        if (checkStatusInternet()){
            getDataJsonFromServer();
        }else {
            dialog.dismiss();
            showErrorNotInternet();
        }
    }
    // init view
    private void initView(View view){
        txtDate = (TextView) view.findViewById(R.id.txt_default_location_time);
        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinatorLayout);
    }
    // Check status internet. if not connect internet then show error
    private void showErrorNotInternet() {
        Snackbar snackbar = Snackbar.make(coordinatorLayout,getString(R.string.notInternet),Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    // Get default location of user
    private void getDefaultLocation() {
        LocationManager mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mLocationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                MINIMUM_TIME_BETWEEN_UPDATES,
                MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
                new MyLocationListener());
        Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        longitude = location.getLongitude() + "";
        latitude = location.getLatitude() + "";
        String keyApi = "706bde0b46846d0958eef7aa860ced53";
        linkDefaultLocation = "http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + keyApi;

    }
    // Get date default in device android
    private void getDateDefault() {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        txtDate.setText(date);
    }
    // Show dialog before show main data
    private void showDialog() {
        dialog = new ProgressDialog(getActivity());
        dialog.show();
        dialog.setMessage(getString(R.string.loading));
    }
    // Get data from Server by Volley
    private void getDataJsonFromServer() {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                linkDefaultLocation, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                dialog.dismiss();
                try {
                    String name = response.getString("name");
                    JSONObject object = response.getJSONObject("wind");
                    double nameCity = object.getDouble("speed");
                    Log.e("tag",nameCity+"");
                    Log.e("tag",name);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getActivity(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
/*
        AppControllerRequesVolley.getInstance().addToRequestQueue(jsonObjReq);
*/
        Volley.newRequestQueue(getActivity()).add(jsonObjReq);
    }

    private class MyLocationListener
            implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            longitude = String.valueOf(location.getLongitude());
            latitude = String.valueOf(location.getLatitude());
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle b) {
        }

        @Override
        public void onProviderDisabled(String s) {
        }

        @Override
        public void onProviderEnabled(String s) {
        }
    }


}
