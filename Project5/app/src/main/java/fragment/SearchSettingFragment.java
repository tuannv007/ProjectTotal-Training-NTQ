package fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import java.util.ArrayList;

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
    private static final String KEY_WORD = "key_word";
    private static final String KEY_NEAR = "key_near";
    private boolean isClicked=true;

    public static SearchSettingFragment newInstance() {

        Bundle args = new Bundle();

        SearchSettingFragment fragment = new SearchSettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

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
        editor = sharedPreferences.edit();
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
                break;
            case R.id.btn_near:
                changeBackgroundSearchSetting(btnNear, R.drawable.search_setting_btn_near_checked);
                resetBackdround(btnCountry, R.drawable.search_setting_btn_country);
                resetBackdround(btnCity, R.drawable.search_setting_btn_city);
                resetBackdround(btnWord, R.drawable.search_setting_btn_near);
                resetBackdround(btnState, R.drawable.search_setting_btn_state);
                break;
            case R.id.btn_city:
                changeBackgroundSearchSetting(btnCity, R.drawable.search_setting_btn_city_checked);
                resetBackdround(btnCountry, R.drawable.search_setting_btn_country);
                resetBackdround(btnWord, R.drawable.search_setting_btn_world);
                resetBackdround(btnNear, R.drawable.search_setting_btn_near);
                resetBackdround(btnState, R.drawable.search_setting_btn_state);
                break;
            case R.id.btn_state:
                changeBackgroundSearchSetting(btnState, R.drawable.search_setting_btn_state_checked);
                resetBackdround(btnCountry, R.drawable.search_setting_btn_country);
                resetBackdround(btnCity, R.drawable.search_setting_btn_city);
                resetBackdround(btnNear, R.drawable.search_setting_btn_near);
                resetBackdround(btnWord, R.drawable.search_setting_btn_world);
                break;
            case R.id.btn_country:
                changeBackgroundSearchSetting(btnCountry, R.drawable.search_setting_btn_country_checked);
                resetBackdround(btnWord, R.drawable.search_setting_btn_world);
                resetBackdround(btnCity, R.drawable.search_setting_btn_city);
                resetBackdround(btnNear, R.drawable.search_setting_btn_near);
                resetBackdround(btnState, R.drawable.search_setting_btn_state);
                break;
            case R.id.interredted_one:
                changeBackgroundSearchSetting(btnInterredted1, R.drawable.search_setting_btn_near_checked);
                resetBackdround(btnInterredted2, R.drawable.search_setting_btn_near);
                resetBackdround(btnInterredted3, R.drawable.search_setting_btn_near);
                break;
            case R.id.interredted_2:
                changeBackgroundSearchSetting(btnInterredted2, R.drawable.search_setting_btn_near_checked);
                resetBackdround(btnInterredted1, R.drawable.search_setting_btn_near);
                resetBackdround(btnInterredted3, R.drawable.search_setting_btn_near);
                break;
            case R.id.interredted_3:
                changeBackgroundSearchSetting(btnInterredted3, R.drawable.search_setting_btn_near_checked);
                resetBackdround(btnInterredted2, R.drawable.search_setting_btn_near);
                resetBackdround(btnInterredted1, R.drawable.search_setting_btn_near);
                break;
            case R.id.showme_1:
                changeBackgroundSearchSetting(btnShome1, R.drawable.search_setting_btn_city_checked);
                resetBackdround(btnShome2, R.drawable.search_setting_btn_city);
                resetBackdround(btnShome3, R.drawable.search_setting_btn_city);
                break;
            case R.id.showme_2:
                changeBackgroundSearchSetting(btnShome2, R.drawable.search_setting_btn_city_checked);
                resetBackdround(btnShome1, R.drawable.search_setting_btn_city);
                resetBackdround(btnShome3, R.drawable.search_setting_btn_city);
                break;
            case R.id.showme_3:
                changeBackgroundSearchSetting(btnShome3, R.drawable.search_setting_btn_city_checked);
                resetBackdround(btnShome2, R.drawable.search_setting_btn_city);
                resetBackdround(btnShome1, R.drawable.search_setting_btn_city);

                break;
            case R.id.btn_cancel_search_Setting:
                goBack();
                openDrawerLayout();
                break;

        }
        editor.commit();
    }

    private void saveButtonToShare() {
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
        saveDataBySharePreference();
        txtRthnicity.setText("");
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
        if (!txtAge.getText().toString().equals(""))
            editor.putString(KEY_AGE, txtAge.getText().toString());
        if (!txtRthnicity.getText().toString().equals(""))
            editor.putString(KEY_ETHNICITY, txtRthnicity.getText().toString());
        if (btnWord.isClickable()){
            editor.putBoolean(KEY_WORD, true);
        }else  if (btnNear.isClickable()){
            editor.putBoolean(KEY_NEAR,true);
        }

        editor.apply();

    }

    private void restoreDataSharePreference() {
        sharedPreferences = getActivity().getSharedPreferences
                (KEY_BETWEEN, Context.MODE_PRIVATE);
        String dt = sharedPreferences.getString(KEY_AGE, "");
        String valuesEthnicity = sharedPreferences.getString(KEY_ETHNICITY, "");
        if (dt.equals("")) return;
        txtAge.setText(dt);
        if (!valuesEthnicity.equals("")) txtRthnicity.setText(valuesEthnicity);
        boolean btnRestoreWord = sharedPreferences.getBoolean(KEY_WORD, false);
        if (btnRestoreWord) {
            changeBackgroundSearchSetting(btnWord, R.drawable.search_setting_btn_world_checked);
            return;
        }
        boolean btmRestoreNear =sharedPreferences.getBoolean(KEY_NEAR,false);
        if (btmRestoreNear){
            changeBackgroundSearchSetting(btnNear, R.drawable.search_setting_btn_near_checked);
            return;
        }

    }

    private void check() {
        for (int i = 0; i < valueSearch.size(); i++) {
            test = valueSearch.get(i).toString();
            txtRthnicity.setText(test);
        }

    }
}
