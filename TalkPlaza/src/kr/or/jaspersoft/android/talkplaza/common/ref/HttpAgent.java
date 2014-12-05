package kr.or.jaspersoft.android.talkplaza.common.ref;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.jaspersoft.android.talkplaza.common.obj.Talk;

/**
 * <pre>
 * ##################################################################
 * 서버 통신 클래스
 * ##################################################################
 * </pre>
 */
public final class HttpAgent {
	
	public static List<Talk> getDummyTalkList() {
		List<Talk> talkList = new ArrayList<Talk>();
		
		Talk talk1 = new Talk();
		talk1.id = 1000l;
		talk1.content = "첫 번째 대화 내용입니다.";
		talkList.add(talk1);
		
		Talk talk2 = new Talk();
		talk2.id = 1001l;
		talk2.content = "두 번째 대화 내용입니다.";
		talkList.add(talk2);
		
		return talkList;
	}

	public static void post(String url, Map<String, String> params) {
		//TODO HttpAgent 구현
	}
}
