package com.nickzy.dspider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionKit {
	public static int depth = 0;
	//获取匹配的值
	public static List<String> doRegex(String content,String regex){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(content);
		String[] data = null;
		 List<String> list = new ArrayList<String>();
		while(m.find())
			list.add(m.group());	
		return removeDuplicate(list);
	}
	//List去重复，使用hashset不保证顺序
	 public static List removeDuplicate(List list)   { 
		    HashSet h  =   new  HashSet(list); 
		    list.clear(); 
		    list.addAll(h); 
		    return list; 
		} 
}
