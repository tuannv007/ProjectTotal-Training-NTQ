package fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.admin.project1final.R;

/**
 * Created by admin on 7/13/2016.
 */
public class TermOfServiceFragment extends BaseFragment implements View.OnClickListener {
    private static final java.lang.String WEBSITE_NAME = "http://manutd.com";
    private WebView webView;
    private Button btnBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.terfofservice_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView = (WebView) view.findViewById(R.id.webLoadData);
        btnBack = (Button) view.findViewById(R.id.btn_back_termofservice);
        btnBack.setOnClickListener(this);
        loadData();
    }

    private void loadData() {
        final ProgressDialog dialog = new ProgressDialog(getActivity());
        WebSettings settings = webView.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        WebViewClient webViewClient = new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                dialog.dismiss();
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                dialog.setMessage("Loading");
                dialog.show();
                dialog.setCanceledOnTouchOutside(false);
            }
        };
        webView.loadUrl(WEBSITE_NAME);
        webView.setWebViewClient(webViewClient);
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
