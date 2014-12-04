package kr.or.jaspersoft.android.talkplaza.common;

import java.util.HashMap;
import java.util.Map;

import kr.or.jaspersoft.android.talkplaza.act.AppProcessActivity;
import kr.or.jaspersoft.android.talkplaza.act.MemberJoinActivity;
import kr.or.jaspersoft.android.talkplaza.act.MemberLoginActivity;
import kr.or.jaspersoft.android.talkplaza.act.MemberProfileActivity;
import kr.or.jaspersoft.android.talkplaza.act.SplashActivity;
import kr.or.jaspersoft.android.talkplaza.act.TalkDetailViewActivity;
import kr.or.jaspersoft.android.talkplaza.act.TalkGraphViewActivity;
import kr.or.jaspersoft.android.talkplaza.act.TalkPlazaActivity;
import kr.or.jaspersoft.android.talkplaza.act.TalkSubjectActivity;
import kr.or.jaspersoft.android.talkplaza.act.TalkWriteActivity;
import kr.or.jaspersoft.android.talkplaza.common.obj.ActivityMetaData;
import kr.or.jaspersoft.android.talkplaza.common.util.PreferenceUtil;
import android.content.Context;

/**
 * <pre>
 * ##################################################################
 * �� ���� Ŭ����
 * ##################################################################
 * </pre>
 */
public final class AppManager {
	/** ����� ��Ī */
	private static final String PREF_NAME = "__pref_name__";
	/** ����� ���̵� Ű */
	private static final String KEY_USER_ID = "__key_user_id__";
	/** ȸ�� ���� ���� Ű */
	private static final String KEY_JOIN = "__key_join__";
	/** �α��� ���� Ű */
	private static final String KEY_LOGIN = "__key_login__";
	/** activity ��Ÿ ������ */
	private static Map<String, ActivityMetaData> activityMetaDatas = new HashMap<String, ActivityMetaData>();
	
	static {
		activityMetaDatas.put(SplashActivity.class.getName(), 
				new ActivityMetaData(SplashActivity.class.getName(), false, false));
		activityMetaDatas.put(AppProcessActivity.class.getName(), 
				new ActivityMetaData(AppProcessActivity.class.getName(), false, false));
		activityMetaDatas.put(MemberJoinActivity.class.getName(), 
				new ActivityMetaData(MemberJoinActivity.class.getName(), false, false));
		activityMetaDatas.put(MemberLoginActivity.class.getName(), 
				new ActivityMetaData(MemberLoginActivity.class.getName(), false, false));
		activityMetaDatas.put(MemberProfileActivity.class.getName(), 
				new ActivityMetaData(MemberProfileActivity.class.getName(), true, true));
		activityMetaDatas.put(TalkDetailViewActivity.class.getName(), 
				new ActivityMetaData(TalkDetailViewActivity.class.getName(), false, false));
		activityMetaDatas.put(TalkGraphViewActivity.class.getName(), 
				new ActivityMetaData(TalkGraphViewActivity.class.getName(), true, true));
		activityMetaDatas.put(TalkPlazaActivity.class.getName(), 
				new ActivityMetaData(TalkPlazaActivity.class.getName(), false, false));
		activityMetaDatas.put(TalkSubjectActivity.class.getName(), 
				new ActivityMetaData(TalkSubjectActivity.class.getName(), true, false));
		activityMetaDatas.put(TalkWriteActivity.class.getName(), 
				new ActivityMetaData(TalkWriteActivity.class.getName(), true, true));
	}
	
	/** ����� ���̵� ���� */
	public static void setUserId(Context ctx, String userId) {
		PreferenceUtil.save(ctx, PREF_NAME, KEY_USER_ID, userId);
	}
	
	/** ����� ���̵� ��ȸ */
	public static String getUserId(Context ctx) {
		return PreferenceUtil.readString(ctx, PREF_NAME, KEY_USER_ID);
	}
	
	/** ȸ�� ���� ���� ���� */
	public static void setJoin(Context ctx, boolean isJoin) {
		PreferenceUtil.save(ctx, PREF_NAME, KEY_JOIN, isJoin);
	}
	
	/** ȸ�� ���� ���� ��ȸ */
	public static boolean isJoin(Context ctx) {
		return PreferenceUtil.readBoolean(ctx, PREF_NAME, KEY_JOIN);
	}
	
	/** �α��� ���� ���� */
	public static void setLogin(Context ctx, boolean isLogin) {
		PreferenceUtil.save(ctx, PREF_NAME, KEY_LOGIN, isLogin);
	}
	
	/** �α��� ���� ��ȸ */
	public static boolean isLogin(Context ctx) {
		return PreferenceUtil.readBoolean(ctx, PREF_NAME, KEY_LOGIN);
	}
	
	/** Activity ��Ÿ ������ ��ȸ */
	public static ActivityMetaData getActivityMetaData(String activityFullName) {
		return activityMetaDatas.get(activityFullName);
	}
}
