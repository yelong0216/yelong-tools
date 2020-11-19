package org.yelong.tools.net.ipv4;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * ipv4地址
 * 
 * @since 1.0
 */
public class Ipv4 {

	private final String ipv4;

	private final Integer oneSection;

	private final String oneSectionStr;

	private final Integer twoSection;

	private final String twoSectionStr;

	private final Integer threeSection;

	private final String threeSectionStr;

	private final Integer fourSection;

	private final String fourSectionStr;

	public Ipv4(String ipv4) {
		if (StringUtils.isBlank(ipv4)) {
			throw new IllegalArgumentException("ipv4 address must not be empty");
		}
		this.ipv4 = ipv4;
		String[] ipv4Section = ipv4.split("[.]");// 分割方法用的是正则。而 . 是正则中的特殊符号。所以使用 [.]
		List<String> ipv4SectionList = Arrays.asList(ipv4Section);
		oneSectionStr = get(ipv4SectionList, 0);
		oneSection = valueOf(oneSectionStr);
		twoSectionStr = get(ipv4SectionList, 1);
		twoSection = valueOf(twoSectionStr);
		threeSectionStr = get(ipv4SectionList, 2);
		threeSection = valueOf(threeSectionStr);
		fourSectionStr = get(ipv4SectionList, 3);
		fourSection = valueOf(fourSectionStr);
	}

	public String getIpv4() {
		return ipv4;
	}

	public Integer getOneSection() {
		return oneSection;
	}

	public String getOneSectionStr() {
		return oneSectionStr;
	}

	public Integer getTwoSection() {
		return twoSection;
	}

	public String getTwoSectionStr() {
		return twoSectionStr;
	}

	public Integer getThreeSection() {
		return threeSection;
	}

	public String getThreeSectionStr() {
		return threeSectionStr;
	}

	public Integer getFourSection() {
		return fourSection;
	}

	public String getFourSectionStr() {
		return fourSectionStr;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ipv4)) {
			return false;
		}
		Ipv4 ipv4 = (Ipv4) obj;
		return this.ipv4.equals(ipv4.ipv4);
	}

	private static Integer valueOf(String str) {
		try {
			return Integer.valueOf(str);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 返回列表中指定位置的元素。如果指定位置不存在元素则返回 <code>null</code>
	 * 
	 * @param <T>   {@link List}的对象类型
	 * @param list  获取值的 {@link List} 允许为 <code>null</code>
	 * @param index 获取的索引
	 * @return 位于指定索引处的对象，如果不存在则为 <code>null</code>
	 */
	private static <T> T get(List<T> list, int index) {
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		if (index < 0 || index >= list.size()) {
			return null;
		}
		return list.get(index);
	}

}
