package kr.or.jaspersoft.android.talkplaza.act;

import kr.or.jaspersoft.android.talkplaza.R;
import android.app.Activity;
import android.os.Bundle;

/**
 * <pre>
 * ##################################################################
 * 도입부 Activity
 * ##################################################################
 * </pre>
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
