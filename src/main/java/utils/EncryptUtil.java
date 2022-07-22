package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

	//生のパスワード文字列とpepper文字列を連結した文字列をSHA-256関数でハッシュ化して返却する
	public static String getPasswordEncrypt(String plainPass, String pepper) {
		String ret = "";

		if(plainPass != null && !plainPass.equals("")) {
			byte[] bytes;
			String password = plainPass + pepper;
			try {
				bytes = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
			}catch(NoSuchAlgorithmException ex) {

			}
		}

		return ret;
	}

}
