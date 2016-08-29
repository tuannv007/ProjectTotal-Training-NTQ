package fragment.setting.distance;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.admin.project1final.R;

import fragment.base.BaseFragment;

/**
 * Created by admin on 7/13/2016.
 * Lựa chọn đơn vị đo distan in để đưa vào Account trong Setting
 */
public class DistanceInFragment extends BaseFragment implements View.OnClickListener/*RadioGroup.OnCheckedChangeListener*/ {
    public static final String KEY_DATA_DISTANCE = "key_data_distance";
    public static final int REQUEST_CODE = 1;
    public static final String KEY_TOTAL_VALUES = "key_total_values";
    public static final String KEY_SAVING_DISTANCE_IN = "key_saving_distance_in";
    public static String name;
    private RadioButton rdbMiles, rdbKilometer;
    private SharedPreferences sharedPreferences;
    private String KEY_MILES = "key_miles";
    private String KEY_KILOMETER = "key_kilometer";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.distance_in_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnBack = (Button) view.findViewById(R.id.btn_back_distance);
        btnBack.setOnClickListener(this);
        rdbMiles = (RadioButton) view.findViewById(R.id.rdbMiles);
        rdbKilometer = (RadioButton) view.findViewById(R.id.rdb_kilomet);
        RadioGroup group = (RadioGroup) view.findViewById(R.id.rdg);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                sendData();
            }
        });
        sharedPreferences = getActivity().getSharedPreferences(KEY_SAVING_DISTANCE_IN, Context.MODE_PRIVATE);
    }

    public void sendData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (rdbMiles.isChecked()) {
            editor.putString(KEY_TOTAL_VALUES, "Miles");
            editor.putBoolean(KEY_MILES, true);
        } else {
            editor.putString(KEY_TOTAL_VALUES, "Kilometer");
            editor.putBoolean(KEY_KILOMETER, true);
        }
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        boolean rdbChooseMiles = sharedPreferences.getBoolean(KEY_MILES, false);
        rdbMiles.setChecked(rdbChooseMiles);
        boolean rdbChooseKilometer = sharedPreferences.getBoolean(KEY_KILOMETER, false);
        rdbKilometer.setChecked(rdbChooseKilometer);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_distance:
                goBack();
                openDrawerLayout();
                break;
        }
    }
}
