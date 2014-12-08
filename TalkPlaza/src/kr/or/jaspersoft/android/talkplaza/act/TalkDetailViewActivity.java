package kr.or.jaspersoft.android.talkplaza.act;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import kr.or.jaspersoft.android.talkplaza.R;
import kr.or.jaspersoft.android.talkplaza.common.core.BaseActivity;
import kr.or.jaspersoft.android.talkplaza.common.core.Constant;
import kr.or.jaspersoft.android.talkplaza.common.obj.Talk;
import kr.or.jaspersoft.android.talkplaza.common.ref.AppManager;
import kr.or.jaspersoft.android.talkplaza.common.ref.HttpAgent;
import kr.or.jaspersoft.android.talkplaza.common.util.LogUtil;
import kr.or.jaspersoft.android.talkplaza.common.util.ToastUtil;
import kr.or.jaspersoft.android.talkplaza.common.widget.HorizontalListView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * <pre>
 * ##################################################################
 * 수다 상세 보기 Activity
 * ##################################################################
 * </pre>
 */
public class TalkDetailViewActivity extends BaseActivity implements OnClickListener {
	
	static Talk talk;
	static TextView mTvTalkContent;
	static Button mBtnTalkWrite;
	static Button mBtnPlazaGo;
	static Button mBtnGraphView;
	static HorizontalListView mHlvDwTalkList;
	static TalkAdapter mTalkAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talkdetail);
        
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
			AppManager.startActivity(TalkDetailViewActivity.this, intent);
        }
        
        mTvTalkContent = (TextView) findViewById(R.id.tv_talk_content);
        mTvTalkContent.setText(talk.content);
        
        mBtnTalkWrite = (Button) findViewById(R.id.btn_talk_write);
        mBtnPlazaGo = (Button) findViewById(R.id.btn_plaza_go);
        mBtnGraphView = (Button) findViewById(R.id.btn_graph_view);
        mBtnTalkWrite.setOnClickListener(this);
        mBtnPlazaGo.setOnClickListener(this);
        mBtnGraphView.setOnClickListener(this);
        
        mHlvDwTalkList = (HorizontalListView) findViewById(R.id.hlv_dw_talk_list);
        mTalkAdapter = new TalkAdapter();
        mHlvDwTalkList.setAdapter(mTalkAdapter);
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
    		LogUtil.log("수다 작성가기");
    		intent = new Intent(globalContext, TalkWriteActivity.class);
    		intent.putExtra(Constant.TALK, talk);
    		AppManager.startActivity(TalkDetailViewActivity.this, intent, true);
    		break;
		//
		// 수다 광장으로 가기
		//
    	case R.id.btn_plaza_go:
    		intent = new Intent(globalContext, TalkPlazaActivity.class);
    		AppManager.startActivity(TalkDetailViewActivity.this, intent, true);
    		break;
		//
		// 그래프로 보러 가기
		//
    	case R.id.btn_graph_view:
    		intent = new Intent(globalContext, TalkGraphViewActivity.class);
    		intent.putExtra(Constant.TALK, talk);
    		AppManager.startActivity(TalkDetailViewActivity.this, intent, false);
    		break;
    	}
	}
    
    /** Down(Below) Talk List View Adapter */
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
