package kr.or.jaspersoft.android.talkplaza.act;

import kr.or.jaspersoft.android.talkplaza.R;
import kr.or.jaspersoft.android.talkplaza.common.core.BaseActivity;
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
 * 로그인 Activity
 * ##################################################################
 * </pre>
 */
public class MemberLoginActivity extends BaseActivity implements OnClickListener {
	
	static EditText mEtUserId;
	static EditText mEtUserPassword;
	static Button mBtnJoin;
	static Button mBtnConfirm;
	static Button mBtnCancel;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        mEtUserId = (EditText) findViewById(R.id.et_user_id);
        mEtUserPassword = (EditText) findViewById(R.id.et_user_password);
        
        mBtnJoin = (Button) findViewById(R.id.btn_join);
        mBtnConfirm = (Button) findViewById(R.id.btn_confirm);
        mBtnCancel = (Button) findViewById(R.id.btn_cancel);
        mBtnJoin.setOnClickListener(this);
        mBtnConfirm.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }
    
    
    @Override
	public void onClick(View v) {
    	Intent intent = null;
    	
    	switch (v.getId()) {
    	//
    	// 회원가입 페이지 가기
    	//
    	case R.id.btn_join:
    		intent = new Intent(globalContext, MemberJoinActivity.class);
    		AppManager.startActivity(MemberLoginActivity.this, intent, true);
    		break;
    	//
    	// 로그인 하기
    	//
    	case R.id.btn_confirm:
    		//TODO 로그인 프로세스 개발
    		intent = new Intent(globalContext, TalkPlazaActivity.class);
    		AppManager.startActivity(MemberLoginActivity.this, intent, true);
    		break;
		//
		// 로그인 취소하기
		//
    	case R.id.btn_cancel:
    		intent = new Intent(globalContext, TalkPlazaActivity.class);
    		AppManager.startActivity(MemberLoginActivity.this, intent, true);
    		break;
    	}
	}
}
