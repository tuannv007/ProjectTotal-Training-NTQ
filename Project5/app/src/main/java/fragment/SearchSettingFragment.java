package fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
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

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import key.api.KeyParam;
import key.api.listconversation.KeyListConversation;
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
    private Button btnNear, btnCity, btnState, btnCountry, btnWord, btnCancelSearchSetting, btnInterredted1, btnInterredted2, btnInterredted3;
    private Button btnShome1, btnShome2, btnShome3;
    private TextView txtAge, txtRthnicity;
    private String valuesAge;
    private String valuesAgeTwo;
    private MyDialogShowAgeSearch dialogShowAgeSearch;
    private SearchEthnicityFragment searchEthnicityFragment;
    private ArrayList<String> valueSearch = new ArrayList<>();
    private NumberPicker picker;
    private String test;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String isWord = "word";
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
    private String nameShowMe;

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
        btnCancelSearchSetting = (Button) view.findViewById(R.id.btn_cancel_search_Setting);
        txtRthnicity = (TextView) view.findViewById(txt_of_ethnicity);
        btnInterredted1 = (Button) view.findViewById(R.id.interredted_one);
        btnInterredted2 = (Button) view.findViewById(R.id.interredted_2);
        btnInterredted3 = (Button) view.findViewById(R.id.interredted_3);
        btnShome1 = (Button) view.findViewById(R.id.showme_1);
        btnShome2 = (Button) view.findViewById(R.id.showme_2);
        btnShome3 = (Button) view.findViewById(R.id.showme_3);
        Button btnSearch = (Button) view.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);
        btnCancelSearchSetting.setOnClickListener(this);
        txtAge.setOnClickListener(this);
        txtRthnicity.setOnClickListener(this);
        btnWord.setOnClickListener(this);
        btnNear.setOnClickListener(this);
        btnCity.setOnClickListener(this);
        btnCountry.setOnClickListener(this);
        btnState.setOnClickListener(this);
        btnShome1.setOnClickListener(this);
        btnShome2.setOnClickListener(this);
        btnShome3.setOnClickListener(this);
        btnInterredted1.setOnClickListener(this);
        btnInterredted2.setOnClickListener(this);
        btnInterredted3.setOnClickListener(this);
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
                valueSearch.clear();
                break;
            case R.id.btn_word:
                changeBackgroundSearchSetting(btnWord, R.drawable.search_setting_btn_world_checked);
                resetBackdround(btnCountry, R.drawable.search_setting_btn_country);
                resetBackdround(btnCity, R.drawable.search_setting_btn_city);
                resetBackdround(btnNear, R.drawable.search_setting_btn_near);
                resetBackdround(btnState, R.drawable.search_setting_btn_state);
                arrayInteres.add(isWord);
                break;
            case R.id.btn_near:
                changeBackgroundSearchSetting(btnNear, R.drawable.search_setting_btn_near_checked);
                resetBackdround(btnCountry, R.drawable.search_setting_btn_country);
                resetBackdround(btnCity, R.drawable.search_setting_btn_city);
                resetBackdround(btnWord, R.drawable.search_setting_btn_near);
                resetBackdround(btnState, R.drawable.search_setting_btn_state);
                arrayInteres.add(isNear);
                break;
            case R.id.btn_city:
                changeBackgroundSearchSetting(btnCity, R.drawable.search_setting_btn_city_checked);
                resetBackdround(btnCountry, R.drawable.search_setting_btn_country);
                resetBackdround(btnWord, R.drawable.search_setting_btn_world);
                resetBackdround(btnNear, R.drawable.search_setting_btn_near);
                resetBackdround(btnState, R.drawable.search_setting_btn_state);
                arrayInteres.add(isCity);
                break;
            case R.id.btn_state:
                changeBackgroundSearchSetting(btnState, R.drawable.search_setting_btn_state_checked);
                resetBackdround(btnCountry, R.drawable.search_setting_btn_country);
                resetBackdround(btnCity, R.drawable.search_setting_btn_city);
                resetBackdround(btnNear, R.drawable.search_setting_btn_near);
                resetBackdround(btnWord, R.drawable.search_setting_btn_world);
                arrayInteres.add(isState);
                break;
            case R.id.btn_country:
                changeBackgroundSearchSetting(btnCountry, R.drawable.search_setting_btn_country_checked);
                resetBackdround(btnWord, R.drawable.search_setting_btn_world);
                resetBackdround(btnCity, R.drawable.search_setting_btn_city);
                resetBackdround(btnNear, R.drawable.search_setting_btn_near);
                resetBackdround(btnState, R.drawable.search_setting_btn_state);
                arrayInteres.add(isCountry);
                break;
            case R.id.interredted_one:
                changeBackgroundSearchSetting(btnInterredted1, R.drawable.search_setting_btn_near_checked);
                resetBackdround(btnInterredted2, R.drawable.search_setting_btn_near);
                resetBackdround(btnInterredted3, R.drawable.search_setting_btn_near);
                arrayIn.add(isInterredOne);
                break;
            case R.id.interredted_2:
                changeBackgroundSearchSetting(btnInterredted2, R.drawable.search_setting_btn_near_checked);
                resetBackdround(btnInterredted1, R.drawable.search_setting_btn_near);
                resetBackdround(btnInterredted3, R.drawable.search_setting_btn_near);
                arrayIn.add(isInterredTwo);
                break;
            case R.id.interredted_3:
                changeBackgroundSearchSetting(btnInterredted3, R.drawable.search_setting_btn_near_checked);
                resetBackdround(btnInterredted2, R.drawable.search_setting_btn_near);
                resetBackdround(btnInterredted1, R.drawable.search_setting_btn_near);
                arrayIn.add(isInterredThree);
                break;
            case R.id.showme_1:
                changeBackgroundSearchSetting(btnShome1, R.drawable.search_setting_btn_city_checked);
                resetBackdround(btnShome2, R.drawable.search_setting_btn_city);
                resetBackdround(btnShome3, R.drawable.search_setting_btn_city);
                arrShowMe.add(isShowMe1);
                break;
            case R.id.showme_2:
                changeBackgroundSearchSetting(btnShome2, R.drawable.search_setting_btn_city_checked);
                resetBackdround(btnShome1, R.drawable.search_setting_btn_city);
                resetBackdround(btnShome3, R.drawable.search_setting_btn_city);
                arrShowMe.add(isShowMe2);
                break;
            case R.id.showme_3:
                changeBackgroundSearchSetting(btnShome3, R.drawable.search_setting_btn_city_checked);
                resetBackdround(btnShome2, R.drawable.search_setting_btn_city);
                resetBackdround(btnShome1, R.drawable.search_setting_btn_city);
                arrShowMe.add(isShowMe3);
                break;
            case R.id.btn_cancel_search_Setting:
                goBack();
                openDrawerLayout();
                break;
            case R.id.btnSearch:
                new SearchFriendAsyncTask().execute(KeyParam.mUrl);
                break;
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MyDialogShowAgeSearch.REQUES_CODE_DIALOG_AGE) {
            valuesAge = data.getStringExtra(MyDialogShowAgeSearch.KEY_NEWVAL_AGE_ONE);
            valuesAgeTwo = data.getStringExtra(MyDialogShowAgeSearch.KEY_NEWVAL_AGE_TWO);
            Log.e("nt", valuesAge + "to" + valuesAgeTwo);
            txtAge.setText(valuesAge + " and " + valuesAgeTwo);
        }
        if (requestCode == SearchEthnicityFragment.KEY_REQUES) {
            valueSearch = data.getStringArrayListExtra(SearchEthnicityFragment.KEYSEARCH_ETHNICITY);

        }

    }

    @Override
    public void onPause() {
        super.onPause();
        txtRthnicity.setText("");
        arrayInteres.size();
        saveDataBySharePreference();
    }

    @Override
    public void onResume() {
        super.onResume();
        restoreDataSharePreference();
        check();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    private void saveDataBySharePreference() {
        editor = sharedPreferences.edit();
        if (!txtAge.getText().toString().equals(""))
            editor.putString(KEY_AGE, txtAge.getText().toString());
        if (!txtRthnicity.getText().toString().equals(""))
            editor.putString(KEY_ETHNICITY, txtRthnicity.getText().toString());
        if (arrayInteres.size() > 0) {
            String name = arrayInteres.get(arrayInteres.size() - 1);
            editor.putString(KEY_NAME, name);
        } else if (arrayInteres.size() == -1) {
            return;
        }
        if (arrayIn.size() > 0) {
            String nameInterred = arrayIn.get(arrayIn.size() - 1);
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
        if (!valuesEthnicity.equals("")) txtRthnicity.setText(valuesEthnicity);
        String getNameInter = sharedPreferences.getString(KEY_INTER, "");
        String getName = sharedPreferences.getString(KEY_NAME, "");
        String getNameShowMe = sharedPreferences.getString(KEY_SHOWME, "");
        if (getName.equalsIgnoreCase(isNear)) {
            changeBackgroundSearchSetting(btnNear, R.drawable.search_setting_btn_near_checked);

        } else if (getName.equalsIgnoreCase(isWord)) {
            changeBackgroundSearchSetting(btnWord, R.drawable.search_setting_btn_world_checked);

        } else if (getName.equalsIgnoreCase(isCity)) {
            changeBackgroundSearchSetting(btnCity, R.drawable.search_setting_btn_near_checked);
        } else if (getName.equalsIgnoreCase(isState)) {
            changeBackgroundSearchSetting(btnState, R.drawable.search_setting_btn_state_checked);
        } else if (getName.equalsIgnoreCase(isCountry)) {
            changeBackgroundSearchSetting(btnCountry, R.drawable.search_setting_btn_country_checked);
        }
        if (getNameInter.equalsIgnoreCase(isInterredOne)) {
            changeBackgroundSearchSetting(btnInterredted1, R.drawable.search_setting_btn_near_checked);
        } else if (getNameInter.equalsIgnoreCase(isInterredTwo)) {
            changeBackgroundSearchSetting(btnInterredted2, R.drawable.search_setting_btn_near_checked);
        } else if (getNameInter.equalsIgnoreCase(isInterredThree)) {
            changeBackgroundSearchSetting(btnInterredted3, R.drawable.search_setting_btn_near_checked);
        }
        if (getNameShowMe.equalsIgnoreCase(isShowMe1)) {
            changeBackgroundSearchSetting(btnShome1, R.drawable.search_setting_btn_city_checked);
        } else if (getNameShowMe.equalsIgnoreCase(isShowMe2)) {
            changeBackgroundSearchSetting(btnShome2, R.drawable.search_setting_btn_city_checked);
        } else if (getNameShowMe.equalsIgnoreCase(isShowMe3)) {
            changeBackgroundSearchSetting(btnShome3, R.drawable.search_setting_btn_city_checked);
        }
    }

    private void check() {
        for (int i = 0; i < valueSearch.size(); i++) {
            test = valueSearch.get(i).toString();
            txtRthnicity.setText(test);
        }

    }
    private class SearchFriendAsyncTask extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... params) {
            User user = new User();
            JSONObject object = new JSONObject();
            try {
                object.put(KeyParam.KeyApi,"meet_people");
                object.put("token",user.getToken());
                Log.i("Tag",user.getToken());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
