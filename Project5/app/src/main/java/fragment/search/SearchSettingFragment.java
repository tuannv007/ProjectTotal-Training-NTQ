package fragment.search;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import fragment.setting.ChangeBackgroundButtonStateSetting;
import fragment.dialog.MyDialogShowAgeSearch;
import key.api.KeyParam;
import singleton.pattemdesign.MySingleton;
import user.User;

import static com.example.admin.project1final.R.id.txt_of_ethnicity;

/**
 * Created by admin on 7/14/2016.
 */
public class SearchSettingFragment extends ChangeBackgroundButtonStateSetting implements View.OnClickListener {
    private static final int KEY_CODE_DIALOG_AGE = 3;
    private static final int REQUES_CODE_ETHNICITY = 1;
    private static final String KEY_BETWEEN = "key_between";
    private static final String KEY_AGE = "key_age";
    private static final String KEY_ETHNICITY = "key_ethnicity";
    private static final String KEY_NAME = "key_name";
    private static final String KEY_INTER = "key_inter";
    private static final String KEY_SHOWME = "key_showMe";
    private Button btnNear;
    private Button btnCity;
    private Button btnState;
    private Button btnCountry;
    private Button btnWord;
    private Button btnInterested1;
    private Button btnInterested2;
    private Button btnInterested3;
    private Button btnShowMe1, btnShowMe2, btnShowMe3;
    private TextView txtAge, txtRthniCity;
    private MyDialogShowAgeSearch dialogShowAgeSearch;
    private SearchEthnicityFragment searchEthnicityFragment;
    private ArrayList<String> listValuesLanguage = new ArrayList<>();
    private ArrayList<Integer> listValuesNumberOfLanguage = new ArrayList<>();
    private NumberPicker picker;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String isWorld = "world";
    private String isNear = "near";
    private String isCity = "city";
    private String isState = "state";
    private ArrayList<String> arrayInteres = new ArrayList<>();
    private ArrayList<String> arrayIn = new ArrayList<>();
    private ArrayList<String> arrShowMe = new ArrayList<>();
    private String isCountry = "country";
    private String isInterredOne = "InterredOne";
    private String isInterredTwo = "InterredTwo";
    private String isInterredThree = "InterredThree";
    private String isShowMe1 = "isShowMe1";
    private String isShowMe2 = "isShowMe2";
    private String isShowMe3 = "isShowMe3";
    private String nameShowMe = "";
    private String nameDistance = "";
    private String nameInterred = "";
    private User user;
    private int dataResultFromServer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_setting_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        dialogShowAgeSearch = new MyDialogShowAgeSearch();
        searchEthnicityFragment = new SearchEthnicityFragment();
        btnWord.setClickable(true);
        ((MainActivity) getActivity()).hideActionbar();
        sharedPreferences = getActivity().getSharedPreferences(KEY_BETWEEN, Context.MODE_PRIVATE);
    }

    private void initView(View view) {
        btnNear = (Button) view.findViewById(R.id.btn_near);
        btnCity = (Button) view.findViewById(R.id.btn_city);
        btnState = (Button) view.findViewById(R.id.btn_state);
        btnCountry = (Button) view.findViewById(R.id.btn_country);
        btnWord = (Button) view.findViewById(R.id.btn_word);
        picker = (NumberPicker) view.findViewById(R.id.numberPicker);
        txtAge = (TextView) view.findViewById(R.id.txt_of_age);
        Button btnCancelSearchSetting = (Button) view.findViewById(R.id.btn_cancel_search_Setting);
        txtRthniCity = (TextView) view.findViewById(txt_of_ethnicity);
        btnInterested1 = (Button) view.findViewById(R.id.interredted_one);
        btnInterested2 = (Button) view.findViewById(R.id.interredted_2);
        btnInterested3 = (Button) view.findViewById(R.id.interredted_3);
        btnShowMe1 = (Button) view.findViewById(R.id.showme_1);
        btnShowMe2 = (Button) view.findViewById(R.id.showme_2);
        btnShowMe3 = (Button) view.findViewById(R.id.showme_3);
        Button btnSearch = (Button) view.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);
        btnCancelSearchSetting.setOnClickListener(this);
        txtAge.setOnClickListener(this);
        txtRthniCity.setOnClickListener(this);
        btnWord.setOnClickListener(this);
        btnNear.setOnClickListener(this);
        btnCity.setOnClickListener(this);
        btnCountry.setOnClickListener(this);
        btnState.setOnClickListener(this);
        btnShowMe1.setOnClickListener(this);
        btnShowMe2.setOnClickListener(this);
        btnShowMe3.setOnClickListener(this);
        btnInterested1.setOnClickListener(this);
        btnInterested2.setOnClickListener(this);
        btnInterested3.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_of_age:
                dialogShowAgeSearch.setTargetFragment(this, KEY_CODE_DIALOG_AGE);
                dialogShowAgeSearch.show(getFragmentManager(), "");
                break;
            case txt_of_ethnicity:
                searchEthnicityFragment.setTargetFragment(this, REQUES_CODE_ETHNICITY);
                changeFragment(searchEthnicityFragment, "SearchEthnicityFragment");
                listValuesLanguage.clear();
                break;
            case R.id.btn_word:
                changeBackgroundSearchSetting(btnWord, R.drawable.search_setting_btn_world_checked);
                resetBackground(btnCountry, R.drawable.search_setting_btn_country);
                resetBackground(btnCity, R.drawable.search_setting_btn_city);
                resetBackground(btnNear, R.drawable.search_setting_btn_near);
                resetBackground(btnState, R.drawable.search_setting_btn_state);
                arrayInteres.add(isWorld);
                break;
            case R.id.btn_near:
                changeBackgroundSearchSetting(btnNear, R.drawable.search_setting_btn_near_checked);
                resetBackground(btnCountry, R.drawable.search_setting_btn_country);
                resetBackground(btnCity, R.drawable.search_setting_btn_city);
                resetBackground(btnWord, R.drawable.search_setting_btn_near);
                resetBackground(btnState, R.drawable.search_setting_btn_state);
                arrayInteres.add(isNear);
                break;
            case R.id.btn_city:
                changeBackgroundSearchSetting(btnCity, R.drawable.search_setting_btn_city_checked);
                resetBackground(btnCountry, R.drawable.search_setting_btn_country);
                resetBackground(btnWord, R.drawable.search_setting_btn_world);
                resetBackground(btnNear, R.drawable.search_setting_btn_near);
                resetBackground(btnState, R.drawable.search_setting_btn_state);
                arrayInteres.add(isCity);
                break;
            case R.id.btn_state:
                changeBackgroundSearchSetting(btnState, R.drawable.search_setting_btn_state_checked);
                resetBackground(btnCountry, R.drawable.search_setting_btn_country);
                resetBackground(btnCity, R.drawable.search_setting_btn_city);
                resetBackground(btnNear, R.drawable.search_setting_btn_near);
                resetBackground(btnWord, R.drawable.search_setting_btn_world);
                arrayInteres.add(isState);
                break;
            case R.id.btn_country:
                changeBackgroundSearchSetting(btnCountry, R.drawable.search_setting_btn_country_checked);
                resetBackground(btnWord, R.drawable.search_setting_btn_world);
                resetBackground(btnCity, R.drawable.search_setting_btn_city);
                resetBackground(btnNear, R.drawable.search_setting_btn_near);
                resetBackground(btnState, R.drawable.search_setting_btn_state);
                arrayInteres.add(isCountry);
                break;
            case R.id.interredted_one:
                changeBackgroundSearchSetting(btnInterested1, R.drawable.search_setting_btn_near_checked);
                resetBackground(btnInterested2, R.drawable.search_setting_btn_near);
                resetBackground(btnInterested3, R.drawable.search_setting_btn_near);
                arrayIn.add(isInterredOne);
                break;
            case R.id.interredted_2:
                changeBackgroundSearchSetting(btnInterested2, R.drawable.search_setting_btn_near_checked);
                resetBackground(btnInterested1, R.drawable.search_setting_btn_near);
                resetBackground(btnInterested3, R.drawable.search_setting_btn_near);
                arrayIn.add(isInterredTwo);
                break;
            case R.id.interredted_3:
                changeBackgroundSearchSetting(btnInterested3, R.drawable.search_setting_btn_near_checked);
                resetBackground(btnInterested2, R.drawable.search_setting_btn_near);
                resetBackground(btnInterested1, R.drawable.search_setting_btn_near);
                arrayIn.add(isInterredThree);
                break;
            case R.id.showme_1:
                changeBackgroundSearchSetting(btnShowMe1, R.drawable.search_setting_btn_city_checked);
                resetBackground(btnShowMe2, R.drawable.search_setting_btn_city);
                resetBackground(btnShowMe3, R.drawable.search_setting_btn_city);
                arrShowMe.add(isShowMe1);
                break;
            case R.id.showme_2:
                changeBackgroundSearchSetting(btnShowMe2, R.drawable.search_setting_btn_city_checked);
                resetBackground(btnShowMe1, R.drawable.search_setting_btn_city);
                resetBackground(btnShowMe3, R.drawable.search_setting_btn_city);
                arrShowMe.add(isShowMe2);
                break;
            case R.id.showme_3:
                changeBackgroundSearchSetting(btnShowMe3, R.drawable.search_setting_btn_city_checked);
                resetBackground(btnShowMe2, R.drawable.search_setting_btn_city);
                resetBackground(btnShowMe1, R.drawable.search_setting_btn_city);
                arrShowMe.add(isShowMe3);
                break;
            case R.id.btn_cancel_search_Setting:
                goBack();
                openDrawerLayout();
                break;
            case R.id.btnSearch:
                searchFriendBySetting();
                break;
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MyDialogShowAgeSearch.REQUEST_CODE_DIALOG_AGE) {
            String valuesAge = data.getStringExtra(MyDialogShowAgeSearch.KEY_NEW_VAL_AGE_ONE);
            String valuesAgeTwo = data.getStringExtra(MyDialogShowAgeSearch.KEY_NEW_VAL_AGE_TWO);
            Log.e("nt", valuesAge + "to" + valuesAgeTwo);
            txtAge.setText(valuesAge + " and " + valuesAgeTwo);
        }
        if (requestCode == SearchEthnicityFragment.KEY_REQUEST) {
            listValuesLanguage = data.getStringArrayListExtra(SearchEthnicityFragment.KEY_SEARCH_ETHNICITY);
            listValuesNumberOfLanguage = data.getIntegerArrayListExtra(SearchEthnicityFragment.KEY_ID_LANGUAGE);
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        txtRthniCity.setText("");
        arrayInteres.size();
        saveDataBySharePreference();
    }

    @Override
    public void onResume() {
        super.onResume();
        restoreDataSharePreference();
        getValuesLanguage();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void saveDataBySharePreference() {
        editor = sharedPreferences.edit();
        if (!txtAge.getText().toString().equals(""))
            editor.putString(KEY_AGE, txtAge.getText().toString());
        if (!txtRthniCity.getText().toString().equals(""))
            editor.putString(KEY_ETHNICITY, txtRthniCity.getText().toString());
        if (arrayInteres.size() > 0) {
            nameDistance = arrayInteres.get(arrayInteres.size() - 1);
            editor.putString(KEY_NAME, nameDistance);
        } else if (arrayInteres.size() == -1) {
            return;
        }
        if (arrayIn.size() > 0) {
            nameInterred = arrayIn.get(arrayIn.size() - 1);
            editor.putString(KEY_INTER, nameInterred);
        } else if (arrayIn.size() == -1) {
            return;
        }
        if (arrShowMe.size() > 0) {
            nameShowMe = arrShowMe.get(arrShowMe.size() - 1);
            editor.putString(KEY_SHOWME, nameShowMe);
        } else if (arrShowMe.size() == -1) {
            return;
        }

        editor.apply();
    }

    private void restoreDataSharePreference() {
        sharedPreferences = getActivity().getSharedPreferences
                (KEY_BETWEEN, Context.MODE_PRIVATE);
        String dt = sharedPreferences.getString(KEY_AGE, "");
        String valuesEthnicity = sharedPreferences.getString(KEY_ETHNICITY, "");
        txtAge.setText(dt);
        if (!valuesEthnicity.equals("")) txtRthniCity.setText(valuesEthnicity);
        String getNameInter = sharedPreferences.getString(KEY_INTER, "");
        String getName = sharedPreferences.getString(KEY_NAME, "");
        String getNameShowMe = sharedPreferences.getString(KEY_SHOWME, "");

        if (getName.equalsIgnoreCase(isNear)) {
            changeBackgroundSearchSetting(btnNear, R.drawable.search_setting_btn_near_checked);

        } else if (getName.equalsIgnoreCase(isWorld)) {
            changeBackgroundSearchSetting(btnWord, R.drawable.search_setting_btn_world_checked);

        } else if (getName.equalsIgnoreCase(isCity)) {
            changeBackgroundSearchSetting(btnCity, R.drawable.search_setting_btn_near_checked);
        } else if (getName.equalsIgnoreCase(isState)) {
            changeBackgroundSearchSetting(btnState, R.drawable.search_setting_btn_state_checked);
        } else if (getName.equalsIgnoreCase(isCountry)) {
            changeBackgroundSearchSetting(btnCountry, R.drawable.search_setting_btn_country_checked);
        }

        if (getNameInter.equalsIgnoreCase(isInterredOne)) {
            changeBackgroundSearchSetting(btnInterested1, R.drawable.search_setting_btn_near_checked);
        } else if (getNameInter.equalsIgnoreCase(isInterredTwo)) {
            changeBackgroundSearchSetting(btnInterested2, R.drawable.search_setting_btn_near_checked);
        } else if (getNameInter.equalsIgnoreCase(isInterredThree)) {
            changeBackgroundSearchSetting(btnInterested3, R.drawable.search_setting_btn_near_checked);
        }

        if (getNameShowMe.equalsIgnoreCase(isShowMe1)) {
            changeBackgroundSearchSetting(btnShowMe1, R.drawable.search_setting_btn_city_checked);
        } else if (getNameShowMe.equalsIgnoreCase(isShowMe2)) {
            changeBackgroundSearchSetting(btnShowMe2, R.drawable.search_setting_btn_city_checked);
        } else if (getNameShowMe.equalsIgnoreCase(isShowMe3)) {
            changeBackgroundSearchSetting(btnShowMe3, R.drawable.search_setting_btn_city_checked);
        }
    }

    private void getValuesLanguage() {
        for (int i = 0; i < listValuesLanguage.size(); i++) {
            String test = listValuesLanguage.get(i).toString();
            txtRthniCity.setText(test);
        }

    }

    private String getTokenFromUserLogin() {
        if (getArguments() == null) return "";
        else {
            return getArguments().getString(MainActivity.KEY_TOKEN);
        }
    }
    // Split Age. Get age Max and Min , using push data to server
    private void splitAge() {
        String age = txtAge.getText().toString();
        if (!age.isEmpty()) {
            String ageSplit[] = age.split(" ");
            int lower_age = Integer.parseInt(ageSplit[0]);
            int upper_age = Integer.parseInt(ageSplit[2]);
            user.setLower_age(lower_age);
            user.setUpper_age(upper_age);
        }

    }

    private void setDistance() {
        int near = 0, city = 1, stage = 2, country = 3, world = 4;
        if (nameDistance.equalsIgnoreCase(isNear)) {
            user.setNameDistance(near);
        } else if (nameDistance.equalsIgnoreCase(isCity)) {
            user.setNameDistance(city);
        } else if (nameDistance.equalsIgnoreCase(isState)) {
            user.setNameDistance(stage);
        } else if (nameDistance.equalsIgnoreCase(isCountry)) {
            user.setNameDistance(country);
        } else if (nameDistance.equalsIgnoreCase(isWorld)) {
            user.setNameDistance(world);
        }
    }

    private void setShowMe() {
        int male = 0, female = 1, both = 2;
        if (nameShowMe.equalsIgnoreCase(isShowMe1)) {
            user.setNameShowme(male);
        } else if (nameShowMe.equalsIgnoreCase(isShowMe2)) {
            user.setNameShowme(female);
        } else if (nameShowMe.equalsIgnoreCase(isShowMe3)) {
            user.setNameShowme(both);
        }
    }

    private void searchFriendBySetting() {
        String token = getTokenFromUserLogin();
        user = new User();
        setShowMe();
        setInterred();
        setDistance();
        splitAge();

        HashMap<String, Object> object = new HashMap<>();
        object.put(KeyParam.KeyApi, "meet_people");
        object.put("token", token);
        object.put("show_me", user.getNameShowme());
        object.put("inters_in", user.getNameInterred());
        object.put("lower_age", user.getLower_age());
        object.put("upper_age", user.getUpper_age());
        object.put("ethn", listValuesNumberOfLanguage);
        object.put("long", 2);
        object.put("lat", 2);
        object.put("distance", user.getNameDistance());
        object.put("skip", 1);
        object.put("take", 1);

        JsonObjectRequest request = new JsonObjectRequest(KeyParam.mUrl, new JSONObject(object),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("tagSearchSetting", response.toString());
                        try {
                            dataResultFromServer = response.getInt("code");
                            if (dataResultFromServer == 0) {
                                showResultFrmServer(dataResultFromServer);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        MySingleton.getInstance(getActivity()).addToRequestQueue(request);
    }

    private void setInterred() {
        int male = 0, female = 1, both = 2;
        if (nameInterred.equalsIgnoreCase(isInterredOne)) {
            user.setNameInterred(male);
        } else if (nameInterred.equalsIgnoreCase(isInterredTwo))
            user.setNameInterred(female);
        else if (nameInterred.equalsIgnoreCase(isInterredThree))
            user.setNameInterred(both);
    }

    private void showResultFrmServer(int values) {
        showResultFromServer(values);
        if (values == (error_03)) {
            showToastMessage("Invalidate_Token");
        } else {
            showToastMessage("Search Successfully ! ");
        }
    }
}
