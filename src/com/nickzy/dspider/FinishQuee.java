package com.nickzy.dspider;

import java.util.HashSet;

public class FinishQuee {
	public static HashSet<String> visitedUrlQueue = new HashSet<String>();  
    
    public synchronized static void addElem(String url)  
    {  
        visitedUrlQueue.add(url);  
    }  
     
    public synchronized static boolean isContains(String url)  
    {  
        return visitedUrlQueue.contains(url);  
    }  
     
    public synchronized static int size()  
    {  
        return visitedUrlQueue.size();  
    }  
}
