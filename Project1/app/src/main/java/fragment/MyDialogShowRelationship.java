package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.admin.project1final.R;

/**
 * Created by admin on 7/19/2016.
 */
public class MyDialogShowRelationship extends android.support.v4.app.DialogFragment implements CompoundButton.OnCheckedChangeListener {
    public static final int RESULT_CODE = 4;
    public static final String KEY_DIALOG = "key_dialog";
    private RadioButton rdbAskme, rdbSinger, rdbRelationship, rdbMaried, rdbComparicate, rdbOpenRelationship, rdbSeparate, rdbDivocred, rdbUnion;
    private RadioGroup group;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle(R.string.chooseItem);
        return inflater.inflate(R.layout.dialog_choose_editprofile_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rdbAskme = (RadioButton) view.findViewById(R.id.rdb_Askme);
        rdbRelationship = (RadioButton) view.findViewById(R.id.rdb_relationship);
        rdbMaried = (RadioButton) view.findViewById(R.id.rdb_maried);
        rdbComparicate = (RadioButton) view.findViewById(R.id.rdb_compalicate);
        rdbSinger = (RadioButton) view.findViewById(R.id.rdb_singer);
        rdbOpenRelationship = (RadioButton) view.findViewById(R.id.rdb_open_relationship);
        rdbSeparate = (RadioButton) view.findViewById(R.id.rdb_separated);
        rdbDivocred = (RadioButton) view.findViewById(R.id.rdb_divorced);
        rdbUnion = (RadioButton) view.findViewById(R.id.rdb_union);
        rdbAskme.setOnCheckedChangeListener(this);
        rdbRelationship.setOnCheckedChangeListener(this);
        rdbMaried.setOnCheckedChangeListener(this);
        rdbComparicate.setOnCheckedChangeListener(this);
        rdbSinger.setOnCheckedChangeListener(this);
        rdbOpenRelationship
                .setOnCheckedChangeListener(this);
        rdbSeparate.setOnCheckedChangeListener(this);
        rdbDivocred.setOnCheckedChangeListener(this);
        rdbUnion.setOnCheckedChangeListener(this);


    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Intent intent = new Intent();
        switch (buttonView.getId()) {
            case R.id.rdb_Askme:
                intent.putExtra(KEY_DIALOG, "Askme");

                break;
            case R.id.rdb_relationship:
                intent.putExtra(KEY_DIALOG, "relationship");

                break;
            case R.id.rdb_compalicate:
                intent.putExtra(KEY_DIALOG, "Compalicate");

                break;
            case R.id.rdb_singer:
                intent.putExtra(KEY_DIALOG, "singer");

                break;
            case R.id.rdb_open_relationship:
                intent.putExtra(KEY_DIALOG, "open Relationship");

                break;
            case R.id.rdb_separated:
                intent.putExtra(KEY_DIALOG, "separated");

                break;
            case R.id.rdb_divorced:
                intent.putExtra(KEY_DIALOG, "divorced");

                break;
            case R.id.rdb_maried:
                intent.putExtra(KEY_DIALOG, "maried");

                break;
            case R.id.rdb_union:
                intent.putExtra(KEY_DIALOG, "union");

                break;
        }
        if (getTargetFragment() != null) {
            getTargetFragment().onActivityResult(getTargetRequestCode(), RESULT_CODE, intent);
        }
        dismiss();
    }

    private void setCheck() {

    }
}
