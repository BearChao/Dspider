package com.nickzy.dspider;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PipelineQuee {
	public static LinkedList<Map<Integer,List<String>>> dataQueue = new LinkedList<Map<Integer,List<String>>>();  
    
    /**队列中对应最多的数据列表数量*/
    public static final int MAX_SIZE = 10000;  
         
    public synchronized static void addElem(Map map)  
    {  
        dataQueue.add(map);  
    }  
         
    public synchronized static Map outElem()  
    {  
        return dataQueue.removeFirst();  
    }  
         
    public synchronized static boolean isEmpty()  
    {  
        return dataQueue.isEmpty();  
    }  
         
    public synchronized static int size()  
    {  
        return dataQueue.size();  
    }
}
