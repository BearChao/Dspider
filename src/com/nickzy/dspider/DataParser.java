package com.nickzy.dspider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataParser {
	public static boolean dataParser(String content,Spider spider){
		int data_s=1;//匹配值数目的临时变量
		System.out.println("匹配数据开始...");
		boolean flag=false;
		Map<Integer,List> map= new HashMap<Integer,List>();
		List<String> datas = new ArrayList<String>(spider.getRegex_data());//得到匹配内容的正则列表
		Iterator<String> iterator = datas.iterator();
		while(iterator.hasNext()){
			List<String> l= new ArrayList<String>();
			l = FunctionKit.doRegex(content, iterator.next());//获取匹配列表
			map.put(data_s,l);
			data_s ++;
		}
			if(!map.isEmpty()){
				flag = true;
				PipelineQuee.addElem(map);
				System.out.println("匹配数据完毕...");
			}else
				System.out.println("没有获得匹配文本");		
		
		return flag;
	}
	
	public static boolean urlParser(String content,Spider spider){
		System.out.println("匹配网页地址开始...");
		boolean flag = false;
		List<String> urls = new ArrayList<String>(spider.getRegex_url());
		Iterator<String> iterator = urls.iterator();
		while(iterator.hasNext()){
			List<String> links = new ArrayList<String>();
			links = FunctionKit.doRegex(content,(String)iterator.next());
			if(!links.isEmpty()){
				for(String s:links) 
					UnreadQuee.addElem(s);
				flag = true;
			}
		}
		return flag;	
	}
}
