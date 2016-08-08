package fragment;

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

/**
 * Created by admin on 7/13/2016.
 * Lựa chọn đơn vị đo distan in để đưa vào Account trong Setting
 */
public class DistanceInFragment extends BaseFragment implements View.OnClickListener {
    public static final String KEY_DATA_DISTANCE = "key_data_distance";
    public static final int REQUES_CODE = 1;
    public static final String KEY_TOTAL_VALUES = "key_total_values";
    public static String name;
    private Button btnBack;
    private RadioButton rdbMiles;
    private RadioGroup group;
    public static final String KEY_SAVING_DISTANCEIN = "key_saving_distancein";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.distance_in_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBack = (Button) view.findViewById(R.id.btn_back_distance);
        btnBack.setOnClickListener(this);
        rdbMiles = (RadioButton) view.findViewById(R.id.rdbMiles);
        group = (RadioGroup) view.findViewById(R.id.rdg);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                sendData();
            }
        });
    }

    public void sendData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(KEY_SAVING_DISTANCEIN, getActivity().MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (rdbMiles.isChecked()) {
            editor.putString(KEY_TOTAL_VALUES, "Miles");
        } else {
            editor.putString(KEY_TOTAL_VALUES, "Kilomets");
        }
        editor.apply();
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
