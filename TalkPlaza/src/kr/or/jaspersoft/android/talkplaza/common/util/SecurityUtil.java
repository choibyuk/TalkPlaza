package kr.or.jaspersoft.android.talkplaza.common.util;

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import android.annotation.SuppressLint;
import android.util.Base64;

/**
 * <pre>
 * ###############################################################################
 * 시큐리티 유틸 클래스
 * ###############################################################################
 * </pre>
 */
public final class SecurityUtil {
	
	private static byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
	private static String sKey = "jaspersoft.or.kr.talkplaza";

	/**
	 * 패스워드 암호화
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	@SuppressLint("TrulyRandom") 
	public static String encryptPassword(String str) {
		String encStr = str;
		try {
			byte[] textBytes = str.getBytes("UTF-8");
			AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
			SecretKeySpec newKey = new SecretKeySpec(sKey.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
			//encStr = Base64.encodeBase64String(cipher.doFinal(textBytes));
			encStr = new String(Base64.encode(cipher.doFinal(textBytes), Base64.DEFAULT));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encStr;
	}
	
	/**
	 * 패스워드 복호화
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	/*public static String decryptPassword(String str) {

		String decStr = str;
		try {
			byte[] textBytes = Base64.decodeBase64(str);
			AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
			SecretKeySpec newKey = new SecretKeySpec(sKey.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
			decStr = new String(cipher.doFinal(textBytes), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decStr;
	}*/
}
