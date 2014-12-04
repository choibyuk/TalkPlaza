package kr.or.jaspersoft.android.talkplaza.common.obj;

/**
 * <pre>
 * ##################################################################
 * Activity ��Ÿ ������ Ŭ����
 * ##################################################################
 * </pre>
 */
public class ActivityMetaData {
	/** Activity Ŭ���� ��Ī(��Ű�� ����) */
	public String fullName = "";
	/** ȸ�� ������ �ʿ� ���� */
	public boolean requiredJoin = false;
	/** �α��� �ʿ� ���� */
	public boolean requiredLogin = false;
	
	public ActivityMetaData(String fullName, boolean requiredJoin, boolean requiredLogin) {
		this.fullName = fullName;
		this.requiredJoin = requiredJoin;
		this.requiredLogin = requiredLogin;
	}
}
