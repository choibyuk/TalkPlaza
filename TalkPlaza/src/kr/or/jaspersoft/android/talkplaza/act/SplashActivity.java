package kr.or.jaspersoft.android.talkplaza.act;

import kr.or.jaspersoft.android.talkplaza.R;
import kr.or.jaspersoft.android.talkplaza.common.core.BaseActivity;
import kr.or.jaspersoft.android.talkplaza.common.ref.AppManager;
import android.content.Intent;
import android.os.Bundle;

/**
 * <pre>
 * ##################################################################
 * 도입부 Activity
 * ##################################################################
 * </pre>
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000l);
					;
					Intent intent = new Intent(globalContext, TalkPlazaActivity.class);
					AppManager.startActivity(SplashActivity.this, intent);
				} catch (Exception e) {
				}
			}
        }).start();
    }
}
