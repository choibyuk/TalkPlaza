package kr.or.jaspersoft.android.talkplaza.act;

import java.io.Serializable;

import kr.or.jaspersoft.android.talkplaza.R;
import kr.or.jaspersoft.android.talkplaza.common.core.BaseActivity;
import kr.or.jaspersoft.android.talkplaza.common.core.Constant;
import kr.or.jaspersoft.android.talkplaza.common.obj.Talk;
import kr.or.jaspersoft.android.talkplaza.common.ref.AppManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * <pre>
 * ##################################################################
 * 수다 작성 Activity
 * ##################################################################
 * </pre>
 */
public class TalkWriteActivity extends BaseActivity implements OnClickListener {
	
	static Talk upTalk;
	static EditText mEtTalkContent;
	static Button mBtnConfirm;
	static Button mBtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talkwrite);
        
        Bundle params = getIntent().getExtras();
        Serializable pTalk = null;
        if (params != null) {
        	pTalk = params.getSerializable(Constant.TALK);
        }
        if (pTalk != null) {
        	upTalk = (Talk) pTalk;
        } else {
        	upTalk = new Talk();
        }
        
        mEtTalkContent = (EditText) findViewById(R.id.et_talk_content);
        
        mBtnConfirm = (Button) findViewById(R.id.btn_confirm);
        mBtnCancel = (Button) findViewById(R.id.btn_cancel);
        mBtnConfirm.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }
    
    @Override
	public void onClick(View v) {
    	Intent intent = null;
    	
    	switch (v.getId()) {
    	//
    	// 수다 작성하기
    	//
    	case R.id.btn_confirm:
    		//TODO 수다 작성 프로세스 개발
    		intent = new Intent(globalContext, TalkPlazaActivity.class);
    		AppManager.startActivity(TalkWriteActivity.this, intent, true);
    		break;
		//
		// 수다 작성 취소하기
		//
    	case R.id.btn_cancel:
    		if (upTalk.id == 0l) {
    			intent = new Intent(globalContext, TalkPlazaActivity.class);
    		} else {
    			intent = new Intent(globalContext, TalkDetailViewActivity.class);
    			intent.putExtra(Constant.TALK, upTalk);
    		}
    		AppManager.startActivity(TalkWriteActivity.this, intent, true);
    		break;
    	}
	}
}
