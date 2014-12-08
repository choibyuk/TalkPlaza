package kr.or.jaspersoft.android.talkplaza.act;

import java.io.Serializable;

import kr.or.jaspersoft.android.talkplaza.R;
import kr.or.jaspersoft.android.talkplaza.common.core.BaseActivity;
import kr.or.jaspersoft.android.talkplaza.common.core.Constant;
import kr.or.jaspersoft.android.talkplaza.common.obj.Talk;
import kr.or.jaspersoft.android.talkplaza.common.ref.AppManager;
import kr.or.jaspersoft.android.talkplaza.common.util.ToastUtil;
import kr.or.jaspersoft.android.talkplaza.common.widget.NodeTreeView;
import android.content.Intent;
import android.os.Bundle;

/**
 * <pre>
 * ##################################################################
 * 수다 그래프 보기 Activity
 * ##################################################################
 * </pre>
 */
public class TalkGraphViewActivity extends BaseActivity {
	
	static Talk talk;
	static NodeTreeView mTreeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talkgraph);
        
        Bundle params = getIntent().getExtras();
        Serializable pTalk = null;
        if (params != null) {
        	pTalk = params.getSerializable(Constant.TALK);
        }
        if (pTalk != null) {
        	talk = (Talk) pTalk;
        } else {
        	ToastUtil.show(globalContext, R.string.msg_info_lack);
        	
        	Intent intent = new Intent(globalContext, TalkPlazaActivity.class);
			AppManager.startActivity(TalkGraphViewActivity.this, intent);
        }
        
        mTreeView = (NodeTreeView) findViewById(R.id.vw_node_tree);
    }
}
