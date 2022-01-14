package com.m1.d014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

public class Test {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		 Runtime runtime=Runtime.getRuntime();
		 Process proc = runtime.exec("ssh-keygen -t rsa -b 4096 -f buffplum -P \"\"");
		 BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		 BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		 String output = "";
		 String sInOut="";
		 String sErr="";
		 while ((sInOut = stdInput.readLine()) != null) {
		     output += sInOut + "\n";
		 }

		 while ((sErr = stdError.readLine()) != null) {
		      output += sErr + "\n";
		 }
		 System.out.println(output);
		//Map<String, Object> map = getMiYao();
		//System.out.println(map.get("public_key"));
		//System.out.println(map.get("private_key"));
	}

	/**
	 * @desc 获取秘钥
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static Map<String, Object> getMiYao() throws NoSuchAlgorithmException {
		Map<String, Object> map = new HashMap<>();
		KeyPairGenerator ppp = KeyPairGenerator.getInstance("RSA");
		KeyPair keyPair = ppp.genKeyPair();
		PublicKey public_key = keyPair.getPublic();
		PrivateKey private_key = keyPair.getPrivate();

		map.put("public_key", Base64.encodeBase64String(public_key.getEncoded()));
		map.put("private_key", Base64.encodeBase64String(private_key.getEncoded()));
		return map;
	}

}
