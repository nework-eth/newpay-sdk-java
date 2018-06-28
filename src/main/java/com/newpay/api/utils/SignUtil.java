package com.newpay.api.utils;

import java.util.Arrays;
import java.util.Map;

/**
 * 签名工具类
 *
 * @Authro sumz
 * @Email mingzhi@pmcaff.com
 * @Date 2018/6/6
 */
public class SignUtil {

	/**
	 * 参数字典排序
	 */
	public static String sortParameters(String... parameterArray) {
		// 参数进行字典排序
		Arrays.sort(parameterArray);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < parameterArray.length; i++) {
			content.append(parameterArray[i]);
		}
		return content.toString();
	}
}
