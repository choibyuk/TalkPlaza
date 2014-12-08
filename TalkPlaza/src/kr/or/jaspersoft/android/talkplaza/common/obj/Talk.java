package kr.or.jaspersoft.android.talkplaza.common.obj;

import java.io.Serializable;

/**
 * <pre>
 * ##################################################################
 * 수다 데이터 클래스
 * ##################################################################
 * </pre>
 */
public final class Talk implements Serializable {
	private static final long serialVersionUID = 4331622487858437907L;
	
	/** 수다 아이디 */
	public long id = 0l;
	/** 수다 상위 아이디 */
	public long upId = 0l;
	/** 수다 처음 아이디 */
	public long ogId = 0l;
	/** 수다 주제 아이디 */
	public long subjectId = 0l;
	/** 수다 주제 이름 */
	public String subjectName = "";
	/** 수다 내용 */
	public String content = "";
	/** 수다 하위 갯수 */
	public int dwCnt = 0;
	/** 수다 신고 여부 */
	public char reportYn = 'N';
	/** 수다 삭제 여부 */
	public char delYn = 'N';
	/** 수다 생성 일시 */
	public String createDt = "";
	/** 수다 생성 아이디 */
	public String createUserId = "";
	/** 수다 생성 이름 */
	public String createUserName = "";
	/** 수다 신고 일시 */
	public String reportDt = "";
	/** 수다 신고 아이디 */
	public String reportUserId = "";
	/** 수다 신고 이름 */
	public String reportUserName = "";
	/** 수다 삭제 일시 */
	public String delDt = "";
	/** 수다 삭제 아이디 */
	public String delUserId = "";
	/** 수다 삭제 이름 */
	public String delUserName = "";
	
	public Talk() {}
}
