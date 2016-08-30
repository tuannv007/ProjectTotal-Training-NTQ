package fragment.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.admin.project1final.MainActivity;
import com.example.admin.project1final.R;

import java.util.ArrayList;

import fragment.base.BaseFragment;

/**
 * Created by admin on 7/15/2016.
 */
public class SearchEthnicityFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    public static final String KEY_SEARCH_ETHNICITY = "key_search_ethnicity";
    public static final int KEY_REQUEST = 1;
    public static final String KEY_ID_LANGUAGE = "key_id_language";
    public static ArrayList<String> listDataLanguage = new ArrayList<>();
    private CheckBox ckbAll, ckbLatina, ckbAfrican, ckbNative, ckbAsian, ckbIndian, ckbIlander, ckbWhile, ckbEastearn, ckbMutil;
    private ArrayList<Integer> listNumberOfLanguage = new ArrayList<>();
    private int idLanguage;

    public static SearchEthnicityFragment newInstance() {

        Bundle args = new Bundle();

        SearchEthnicityFragment fragment = new SearchEthnicityFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_ethnicity_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        ((MainActivity) getActivity()).hideActionbar();
    }

    private void initView(View view) {
        Button btnCancel = (Button) view.findViewById(R.id.btn_cancel_search_Ethnicity);
        ckbAll = (CheckBox) view.findViewById(R.id.ckbAll);
        ckbLatina = (CheckBox) view.findViewById(R.id.ckbLatina);
        ckbAfrican = (CheckBox) view.findViewById(R.id.ckb_african);
        ckbNative = (CheckBox) view.findViewById(R.id.ckb_native);
        ckbAsian = (CheckBox) view.findViewById(R.id.ckb_asian);
        ckbIndian = (CheckBox) view.findViewById(R.id.ckb_indian);
        ckbIlander = (CheckBox) view.findViewById(R.id.ckb_islander);
        ckbWhile = (CheckBox) view.findViewById(R.id.ckb_while);
        ckbEastearn = (CheckBox) view.findViewById(R.id.ckb_easten);
        ckbMutil = (CheckBox) view.findViewById(R.id.ckb_mutil);
        Button btnDone = (Button) view.findViewById(R.id.btnDoneSearchEthnicity);
        btnDone.setOnClickListener(this);
        ckbLatina.setOnCheckedChangeListener(this);
        ckbAfrican.setOnCheckedChangeListener(this);
        ckbNative.setOnCheckedChangeListener(this);
        ckbIndian.setOnCheckedChangeListener(this);
        ckbAll.setOnCheckedChangeListener(this);
        ckbIlander.setOnCheckedChangeListener(this);
        ckbWhile.setOnCheckedChangeListener(this);
        ckbEastearn.setOnCheckedChangeListener(this);
        ckbMutil.setOnCheckedChangeListener(this);
        ckbAsian.setOnCheckedChangeListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.ckbAll:
                if (isChecked) {
                    ckbLatina.setChecked(false);
                    ckbAfrican.setChecked(false);
                    ckbNative.setChecked(false);
                    ckbIndian.setChecked(false);
                    ckbIlander.setChecked(false);
                    ckbWhile.setChecked(false);
                    ckbEastearn.setChecked(false);
                    ckbMutil.setChecked(false);
                    ckbAsian.setChecked(false);

                } else {
                    ckbAll.setChecked(false);

                }
                break;
            case R.id.ckb_african:
                if (isChecked) {
                    ckbAll.setChecked(false);

                }
                break;
            case R.id.ckb_asian:
                if (isChecked) {

                    ckbAll.setChecked(false);
                }
                break;
            case R.id.ckbLatina:
                if (isChecked) {
                    ckbAll.setChecked(false);

                }
                break;
            case R.id.ckb_easten:
                if (isChecked) {

                    ckbAll.setChecked(false);
                }
                break;
            case R.id.ckb_indian:
                if (isChecked) {

                    ckbAll.setChecked(false);
                }

                break;
            case R.id.ckb_mutil:
                if (isChecked) {

                    ckbAll.setChecked(false);
                }

                break;
            case R.id.ckb_islander:
                if (isChecked) {
                    ckbAll.setChecked(false);

                }
                break;
            case R.id.ckb_while:
                if (isChecked) {

                    ckbAll.setChecked(false);
                }
                break;
            case R.id.ckb_native:
                if (isChecked) {
                    ckbAll.setChecked(false);
                }
                break;
        }
    }

    private void sendData(int RequestCode) {
        String language = "";
        int idAsia = 3, idLatina = 0, idAfrican = 1, idNative = 2, idIndian = 4, idPacific = 5, idWhile = 6, idEaster = 7, idMutil = 8;
        Intent intent = new Intent();
        if (ckbAll.isChecked()) {
            language += "All,";
            listNumberOfLanguage.add(null);
        }
        if (ckbAsian.isChecked()) {
            language += "Asian,";
            listNumberOfLanguage.add(idAsia);
        }
        if (ckbNative.isChecked()) {
            language += "Native,";
            listNumberOfLanguage.add(idNative);
        }
        if (ckbLatina.isChecked()) {
            language += "Latina,";
            listNumberOfLanguage.add(idLatina);
        }

        if (ckbMutil.isChecked()) {
            language += "mutil,";
            listNumberOfLanguage.add(idMutil);
        }
        if (ckbAfrican.isChecked()) {
            language += "African,";
            listNumberOfLanguage.add(idAfrican);
        }
        if (ckbEastearn.isChecked()) {
            language += "Eastearn,";
            listNumberOfLanguage.add(idEaster);
        }
        if (ckbIlander.isChecked()) {
            language += "Islander,";
            listNumberOfLanguage.add(idIndian);
        }
        if (ckbWhile.isChecked()) {
            language += "While,";
            listNumberOfLanguage.add(idWhile);
        }
        listDataLanguage.add(language);
        if (listDataLanguage.size() != 0) {
            intent.putStringArrayListExtra(KEY_SEARCH_ETHNICITY, listDataLanguage);
        }
        if (listNumberOfLanguage.size() != 0) {
            intent.putIntegerArrayListExtra(KEY_ID_LANGUAGE, listNumberOfLanguage);
        }

        getTargetFragment().onActivityResult(getTargetRequestCode(), RequestCode, intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDoneSearchEthnicity:
                sendData(KEY_REQUEST);
                goBack();
                break;
            case R.id.btn_cancel_search_Ethnicity:
                goBack();
                openDrawerLayout();
                break;
        }
    }
}
