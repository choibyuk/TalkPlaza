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
 * 회원 가입 Activity
 * ##################################################################
 * </pre>
 */
public class MemberJoinActivity extends BaseActivity implements OnClickListener {
	
	static EditText mEtUserId;
	static EditText mEtUserPassword;
	static EditText mEtUserPasswordConfirm;
	static EditText mEtUserName;
	static Button mBtnLogin;
	static Button mBtnConfirm;
	static Button mBtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        
        mEtUserId = (EditText) findViewById(R.id.et_user_id);
        mEtUserPassword = (EditText) findViewById(R.id.et_user_password);
        mEtUserPasswordConfirm = (EditText) findViewById(R.id.et_user_password_confirm);
        mEtUserName = (EditText) findViewById(R.id.et_user_name);
        
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnConfirm = (Button) findViewById(R.id.btn_confirm);
        mBtnCancel = (Button) findViewById(R.id.btn_cancel);
        mBtnLogin.setOnClickListener(this);
        mBtnConfirm.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }
    
    @Override
	public void onClick(View v) {
    	Intent intent = null;
    	
    	switch (v.getId()) {
    	//
    	// 로그인 페이지 가기
    	//
    	case R.id.btn_login:
    		intent = new Intent(globalContext, MemberLoginActivity.class);
    		AppManager.startActivity(MemberJoinActivity.this, intent, true);
    		break;
    	//
    	// 회원 가입하기
    	//
    	case R.id.btn_confirm:
    		final String userId = mEtUserId.getText().toString().trim();
    		if (!isValidUserId(userId)) {
    			mEtUserId.setError("제대로 입력해라....");
    			return;
    		}
    		//TODO 회원 가입 프로세스 개발
    		intent = new Intent(globalContext, TalkPlazaActivity.class);
    		AppManager.startActivity(MemberJoinActivity.this, intent, true);
    		break;
		//
		// 회원 가입 취소하기
		//
    	case R.id.btn_cancel:
    		intent = new Intent(globalContext, TalkPlazaActivity.class);
    		AppManager.startActivity(MemberJoinActivity.this, intent, true);
    		break;
    	}
	}
    
    private boolean isValidUserId(String userId) {
    	return false;
    }
}
