package kr.or.jaspersoft.android.wordsympathy.act;

import kr.or.jaspersoft.android.wordsympathy.R;
import kr.or.jaspersoft.android.wordsympathy.common.act.BaseActivity;
import android.os.Bundle;

/**
 * <pre>
 * ###############################################################################
 * 단어 느낌 목록 페이지
 * ###############################################################################
 * </pre>
 */
public class WordFeelingListActivity extends BaseActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_word_feeling_list);
    }
}
