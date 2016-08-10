package fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.project1final.R;
import com.viewpagerindicator.CirclePageIndicator;

import key.name.fragment.tag.NameFragment;
import myadapter.WellcomeAdapter;

/**
 * Created by admin on 7/27/2016.
 */
public class WellcomeFragment extends BaseFragment implements View.OnClickListener {
    int[] image = {R.drawable.splash_intro1, R.drawable.bg_image2, R.drawable.bg_images};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wellcome_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.vpg_image);
        CirclePageIndicator indicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
        Button btnLogin = (Button) view.findViewById(R.id.btn_login_wellcome);
        WellcomeAdapter wellcomeAdapter = new WellcomeAdapter(getActivity(), image);
        viewPager.setAdapter(wellcomeAdapter);
        indicator.setViewPager(viewPager);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(7 * density);
        indicator.setStrokeColor(Color.WHITE);
        indicator.setStrokeWidth(1 * density);
        btnLogin.setOnClickListener(this);
        if (getActivity().getActionBar() != null)
            getActivity().getActionBar().hide();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_wellcome:
                changeFragment(new LoginFragment(), NameFragment.loginFragment);
                break;
        }
    }
}
