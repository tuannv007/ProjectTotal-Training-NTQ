package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.admin.project1final.R;

/**
 * Created by admin on 7/19/2016.
 */
public class MyDialogShowAgeSearch extends DialogFragment implements NumberPicker.OnValueChangeListener, View.OnClickListener {
    public static final String KEY_NEWVAL_AGE_ONE = "key_newval_age_one";
    public static final int REQUES_CODE_DIALOG_AGE = 3;
    public static final String KEY_NEWVAL_AGE_TWO ="key_newval_age_two" ;
    private NumberPicker numberPicker1, numberPicker2;
    private Button btnCancel, btnOk;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_number_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().setTitle(R.string.offage);
        numberPicker1 = (NumberPicker) view.findViewById(R.id.numberPicker);
        numberPicker2 = (NumberPicker) view.findViewById(R.id.numberPicker2);
        btnCancel = (Button) view.findViewById(R.id.btn_cancle);
        btnOk = (Button) view.findViewById(R.id.btn_ok);
        numberPicker1.setMaxValue(100);
        numberPicker1.setMinValue(1);
        numberPicker2.setMaxValue(100);
        numberPicker2.setMinValue(1);
        numberPicker1.setOnValueChangedListener(this);
        numberPicker2.setOnValueChangedListener(this);
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
    }

    private void sendAgeToSearchSetting(int RESULT_CODE) {
        Intent intent = new Intent();
        intent.putExtra(KEY_NEWVAL_AGE_ONE, numberPicker1.getValue() + "");
        intent.putExtra(KEY_NEWVAL_AGE_TWO, numberPicker2.getValue() + "");
        if (getFragmentManager() != null)
            getTargetFragment().onActivityResult(getTargetRequestCode(), RESULT_CODE, intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                sendAgeToSearchSetting(REQUES_CODE_DIALOG_AGE);
                this.dismiss();

                break;
        }
    }
}
