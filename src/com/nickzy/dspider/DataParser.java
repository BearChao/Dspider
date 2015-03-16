package com.nickzy.dspider;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
	public static List<String> dataParser(String content,Spider spider){
		
		System.out.println("匹配数据开始...");
		List<String> list = new ArrayList<String>();
		list = FunctionKit.doRegex(content,spider.getRegex_data() );
		if (list.isEmpty())
			System.out.println("没有获得匹配文本");
		else
			System.out.println("匹配数据完毕...");

		return list;
	}
	public static List<String> linkParser(String content,Spider spider){
		System.out.println("匹配网页地址开始...");
		List<String> link = new ArrayList<String>();
		link = FunctionKit.doRegex(content, spider.getRegex_url());
		if (link.isEmpty())
			System.out.println("没有获得匹配的链接");
		return link;
	}
}
