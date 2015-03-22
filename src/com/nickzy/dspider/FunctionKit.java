package com.nickzy.dspider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionKit {
	public static int depth = 0;
	public static int threads = 1;
	public static boolean thread = false;
	public static int reg_datas = 1;//查找数据正则表达式数量
	public static int reg_urls = 1;
	public static boolean isDone = false;//程序执行结束标记
	
	
	//获取匹配的值
	public static List<String> doRegex(String content,String regex){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(content);
		String[] data = null;
		 List<String> list = new ArrayList<String>();
		while(m.find()){
			String s = m.group(1);
			if(s!=null)//非空判断，有时因为正则式的原因会输出一个null
			list.add(s);
			}	
		return removeDuplicate(list);
	}
	
	//List去重复，使用hashset不保证顺序
	 public static List removeDuplicate(List list)   { 
		 Set set  =   new  HashSet(); 
	     List newList  =   new  ArrayList(); 
	     for(Iterator iter  =  list.iterator(); iter.hasNext();) { 
	         Object element  =  iter.next(); 
	         if  (set.add(element)) 
	            newList.add(element); 
	     } 
	     list.clear(); 
	     list.addAll(newList); 
		    return list; 
		} 
	 
	 public static String getHrefOfInOut(String href)  
	    {  
	        /* 内外部链接最终转化为完整的链接格式 */
	        String resultHref = null;  
	     
	        /* 判断是否为外部链接 */
	        if (href.startsWith("http://"))  
	        {  
	            resultHref = href;  
	        } else
	        {  
	            /* 如果是内部链接,则补充完整的链接地址,其他的格式忽略不处理,如：a href="#" */
	            if (href.startsWith("/"))  
	            {  
	                resultHref = "http://www.oschina.net" + href;  
	            }  
	        }  
	     
	        return resultHref;  
	    }  
	 
	 public static String getHrefOfContent(String content)  
	    {  
	        System.out.println("解析地址开始");  
	        StringBuffer sb = new StringBuffer();
	        String[] contents = content.split("<a href=\"");  
	        for (int i = 1; i < contents.length; i++)  
	        {  
	            int endHref = contents[i].indexOf("\"");  
	     
	            String aHref = getHrefOfInOut(contents[i].substring(  
	                    0, endHref));  
	           
	            if (aHref != null)  
	            {  
	                String href = getHrefOfInOut(aHref);  
	     
	                if (!UnreadQuee.isContains(href)  
	                        //&& href.indexOf("/code/explore") != -1  
	                        && !FinishQuee.isContains(href))  
	                {  
	                    sb.append(href);
	                    sb.append("|");
	                }  
	            }  
	        }  

	        return sb.toString();
	     
	    }  
}
