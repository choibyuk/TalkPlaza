package kr.or.jaspersoft.android.talkplaza.act;

import java.util.ArrayList;
import java.util.List;

import kr.or.jaspersoft.android.talkplaza.R;
import kr.or.jaspersoft.android.talkplaza.common.core.BaseActivity;
import kr.or.jaspersoft.android.talkplaza.common.obj.Talk;
import kr.or.jaspersoft.android.talkplaza.common.ref.AppManager;
import kr.or.jaspersoft.android.talkplaza.common.ref.HttpAgent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * <pre>
 * ##################################################################
 * 수다 광장 Activity
 * ##################################################################
 * </pre>
 */
public class TalkPlazaActivity extends BaseActivity implements OnClickListener {
	
	static ListView mTalkList;
	static TalkAdapter mTalkAdapter;
	static Button mBtnTalkWrite;
	static Button mBtnJoin;
	static Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talkplaza);
        
        mTalkList = (ListView) findViewById(R.id.lv_talk_list);
        mTalkAdapter = new TalkAdapter();
        mTalkList.setAdapter(mTalkAdapter);
        
        mBtnTalkWrite = (Button) findViewById(R.id.btn_talk_write);
        mBtnJoin = (Button) findViewById(R.id.btn_join);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnTalkWrite.setOnClickListener(this);
        mBtnJoin.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
        
        mTalkAdapter.talkList.addAll(HttpAgent.getDummyTalkList());
    }
    
    @Override
	public void onClick(View v) {
    	Intent intent = null;
    	
    	switch (v.getId()) {
    	//
    	// 수다 작성하러 가기
    	//
    	case R.id.btn_talk_write:
    		intent = new Intent(globalContext, TalkWriteActivity.class);
    		AppManager.startActivity(TalkPlazaActivity.this, intent, true);
    		break;
		//
		// 회원 가입하러 가기
		//
    	case R.id.btn_join:
    		intent = new Intent(globalContext, MemberJoinActivity.class);
    		AppManager.startActivity(TalkPlazaActivity.this, intent, true);
    		break;
		//
		// 로그인하러 가기
		//
    	case R.id.btn_login:
    		intent = new Intent(globalContext, MemberLoginActivity.class);
    		AppManager.startActivity(TalkPlazaActivity.this, intent, true);
    		break;
    	}
	}
    
    
    /** Talk List View Adapter */
    static class TalkAdapter extends BaseAdapter {
		private LayoutInflater inflater = (LayoutInflater) globalContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		public List<Talk> talkList = new ArrayList<Talk>();
		
		@Override
		public int getCount() {
			return talkList == null ? 0 : talkList.size();
		}

		@Override
		public Talk getItem(int position) {
			return talkList == null ? null : talkList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			TalkViewHolder talkViewHolder = null;
			if (convertView == null) {
				talkViewHolder = new TalkViewHolder();
				convertView = inflater.inflate(R.layout.adapter_talk_list_item, null);
				talkViewHolder.tvTalkContent = (TextView) convertView.findViewById(R.id.tv_talk_content);
				convertView.setTag(talkViewHolder);
			} else {
				talkViewHolder = (TalkViewHolder) convertView.getTag();
			}
			
			final Talk talk = getItem(position);
			talkViewHolder.tvTalkContent.setText(talk.content);
			return convertView;
		}
	}
	
	static class TalkViewHolder {
		public TextView tvTalkContent;
	}
}
