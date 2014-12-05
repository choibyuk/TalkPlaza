package kr.or.jaspersoft.android.talkplaza.act;

import kr.or.jaspersoft.android.talkplaza.R;
import kr.or.jaspersoft.android.talkplaza.common.core.BaseActivity;
import android.os.Bundle;

/**
 * <pre>
 * ##################################################################
 * 회원 프로필 Activity
 * ##################################################################
 * </pre>
 */
public class MemberProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
