package kr.or.jaspersoft.android.talkplaza.common.util;

import android.util.Log;

/**
 * <pre>
 * ###############################################################################
 * 로그 유틸 클래스
 * ###############################################################################
 * </pre>
 */
public final class LogUtil {

	private static final String _TAG = "TalkPlaza";

	/**
	 * 로그 출력
	 * @param msg
	 */
	public static void log(String msg) {
		Log.v(_TAG, msg);
	}
}
