package fragment.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.admin.project1final.R;

/**
 * Created by admin on 7/19/2016.
 */
public class MyDialogShowAgeSearch extends DialogFragment implements NumberPicker.OnValueChangeListener, View.OnClickListener {
    public static final String KEY_NEW_VAL_AGE_ONE = "key_new_val_age_one";
    public static final int REQUEST_CODE_DIALOG_AGE = 3;
    public static final String KEY_NEW_VAL_AGE_TWO = "key_new_val_age_two";
    private NumberPicker numberPickerLeft, numberPickerRight;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_number_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().setTitle(getString(R.string.offage));
        numberPickerLeft = (NumberPicker) view.findViewById(R.id.numberPicker);
        numberPickerRight = (NumberPicker) view.findViewById(R.id.numberPicker2);
        Button btnCancel = (Button) view.findViewById(R.id.btn_cancle);
        Button btnOk = (Button) view.findViewById(R.id.btn_ok);
        numberPickerLeft.setMaxValue(100);
        numberPickerLeft.setMinValue(1);
        numberPickerRight.setMaxValue(100);
        numberPickerRight.setMinValue(1);
        numberPickerLeft.setOnValueChangedListener(this);
        numberPickerRight.setOnValueChangedListener(this);
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
    }

    private void sendAgeToSearchSetting(int RESULT_CODE) {
        Intent intent = new Intent();
        intent.putExtra(KEY_NEW_VAL_AGE_ONE, numberPickerLeft.getValue() + "");
        intent.putExtra(KEY_NEW_VAL_AGE_TWO, numberPickerRight.getValue() + "");
        if (getFragmentManager() != null)
            getTargetFragment().onActivityResult(getTargetRequestCode(), RESULT_CODE, intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                sendAgeToSearchSetting(REQUEST_CODE_DIALOG_AGE);
                this.dismiss();

                break;
        }
    }
}
