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
 * 앱 관리 클래스
 * ##################################################################
 * </pre>
 */
public final class AppManager {
	/** 저장소 명칭 */
	private static final String PREF_NAME = "__pref_name__";
	/** 사용자 아이디 키 */
	private static final String KEY_USER_ID = "__key_user_id__";
	/** 회원 가입 여부 키 */
	private static final String KEY_JOIN = "__key_join__";
	/** 로그인 여부 키 */
	private static final String KEY_LOGIN = "__key_login__";
	/** activity 메타 데이터 */
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
	
	/** 사용자 아이디 저장 */
	public static void setUserId(Context ctx, String userId) {
		PreferenceUtil.save(ctx, PREF_NAME, KEY_USER_ID, userId);
	}
	
	/** 사용자 아이디 조회 */
	public static String getUserId(Context ctx) {
		return PreferenceUtil.readString(ctx, PREF_NAME, KEY_USER_ID);
	}
	
	/** 회원 가입 여부 저장 */
	public static void setJoin(Context ctx, boolean isJoin) {
		PreferenceUtil.save(ctx, PREF_NAME, KEY_JOIN, isJoin);
	}
	
	/** 회원 가입 여부 조회 */
	public static boolean isJoin(Context ctx) {
		return PreferenceUtil.readBoolean(ctx, PREF_NAME, KEY_JOIN);
	}
	
	/** 로그인 여부 저장 */
	public static void setLogin(Context ctx, boolean isLogin) {
		PreferenceUtil.save(ctx, PREF_NAME, KEY_LOGIN, isLogin);
	}
	
	/** 로그인 여부 조회 */
	public static boolean isLogin(Context ctx) {
		return PreferenceUtil.readBoolean(ctx, PREF_NAME, KEY_LOGIN);
	}
	
	/** Activity 메타 데이터 조회 */
	public static ActivityMetaData getActivityMetaData(String activityFullName) {
		return activityMetaDatas.get(activityFullName);
	}
}
