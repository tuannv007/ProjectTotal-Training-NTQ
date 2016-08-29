package fragment.setting.deactive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.project1final.R;

import fragment.base.BaseFragment;

/**
 * Created by admin on 7/13/2016.
 */
public class DeactivateAccount extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.deactive_account_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnBack = (Button) view.findViewById(R.id.btn_back_termofservice);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_termofservice:
                goBack();
                openDrawerLayout();
                break;
        }
    }
}
