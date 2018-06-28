package com.newpay.api;

import java.util.HashMap;
import java.util.Map;

import com.newpay.api.utils.RSAUtils;
import com.newpay.api.utils.SignUtil;

public class NewpayClient {
	public String getSign(String privateKey, String... parameterArray) {
		String contentParameters = SignUtil.sortParameters(parameterArray);
		try {
			return RSAUtils.sign(contentParameters.getBytes(), privateKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Boolean verify(String publicKey, String sign,String... parameterArray) {
		String contentParameters = SignUtil.sortParameters(parameterArray);
		try {
			return RSAUtils.verify(contentParameters.getBytes(), publicKey,sign);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Map<String, String> genKeyPair() {
		try {
			Map<String, Object> keyMap = RSAUtils.genKeyPair();
			Map<String, String> keyPairMap = new HashMap<String, String>();
			keyPairMap.put("PublicKey", RSAUtils.getPublicKey(keyMap));
			keyPairMap.put("PrivateKey", RSAUtils.getPrivateKey(keyMap));
			return keyPairMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
