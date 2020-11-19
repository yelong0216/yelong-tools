package org.yelong.tools.net.ipv4;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * ipv4工具类
 * 
 * @since 1.0
 */
public final class Ipv4Utils {

	private Ipv4Utils() {
	}

	/**
	 * 判断ip前三段是否相同
	 * 
	 * @param ip1 判断的第一个ip
	 * @param ip2 判断的第二个ip
	 * @return <code>true</code> 相同
	 */
	public static boolean validateFirstThreeSection(String ip1, String ip2) {
		// 起始IP和结束IP的前三个段必须相同
		ip1 = ip1.substring(0, ip1.lastIndexOf("."));
		ip2 = ip2.substring(0, ip2.lastIndexOf("."));
		return ip1.equals(ip2);
	}

	/**
	 * 是否以ipv4地址
	 * 
	 * @param ipAddr ip地址
	 * @return <code>true</code> 是ipv4地址
	 */
	public static boolean isValidIpv4Addr(String ipAddr) {
		if (StringUtils.isBlank(ipAddr)) {
			return false;
		}
		String regex = "(^((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})"
				+ "([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})$)";
		ipAddr = Normalizer.normalize(ipAddr, Form.NFKC);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ipAddr);
		return matcher.matches();
	}

	/**
	 * 是否时ipv4地址，且最后一段是 *
	 * 
	 * @param ipAddr ip地址
	 * @return <code>true</code> 是ipv4地址，且最后一段是 *
	 */
	public static boolean isValidIpv4AddrLastStar(String ipAddr) {
		if (StringUtils.isBlank(ipAddr)) {
			return false;
		}
		String regex = "(^((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})"
				+ "([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){2})[.][*]$)";
		ipAddr = Normalizer.normalize(ipAddr, Form.NFKC);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ipAddr);
		return matcher.matches();
	}

}
