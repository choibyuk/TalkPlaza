package kr.or.jaspersoft.android.talkplaza.act;

import kr.or.jaspersoft.android.talkplaza.R;
import kr.or.jaspersoft.android.talkplaza.common.core.BaseActivity;
import android.os.Bundle;

/**
 * <pre>
 * ##################################################################
 * 수다 상세 보기 Activity
 * ##################################################################
 * </pre>
 */
public class TalkDetailViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talkdetail);
    }
}
