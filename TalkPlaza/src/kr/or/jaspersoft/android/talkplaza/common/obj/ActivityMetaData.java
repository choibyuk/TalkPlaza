package kr.or.jaspersoft.android.talkplaza.common.obj;

/**
 * <pre>
 * ##################################################################
 * Activity 메타 데이터 클래스
 * ##################################################################
 * </pre>
 */
public class ActivityMetaData {
	/** Activity 클래스 명칭(패키지 포함) */
	public String fullName = "";
	/** 회원 가입이 필요 여부 */
	public boolean requiredJoin = false;
	/** 로그인 필요 여부 */
	public boolean requiredLogin = false;
	
	public ActivityMetaData(String fullName, boolean requiredJoin, boolean requiredLogin) {
		this.fullName = fullName;
		this.requiredJoin = requiredJoin;
		this.requiredLogin = requiredLogin;
	}
}
