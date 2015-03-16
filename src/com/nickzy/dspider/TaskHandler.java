package com.nickzy.dspider;

import java.util.List;

/**
 * @author zynick
 *
 */
public class TaskHandler extends Thread{
	Spider spider;
	public TaskHandler(Spider spider){
		this.spider = spider;
		UnreadQuee.addElem(spider.getStart_url());
		System.out.println("一个线程开始...");
		start();
	}

	@Override
	public void run() {
		while(!UnreadQuee.isEmpty()){
		String content = Downloader.getContentFromUrl(UnreadQuee.outElem());//调用下载器
		String links = FunctionKit.getHrefOfContent(content);//存储符合要求的链接地址
		List<String> data = DataParser.dataParser(content,spider);//匹配网页内容
		List<String> link = DataParser.linkParser(content,spider);//匹配网页内的链接地址
		for(String s:link){
			UnreadQuee.addElem(s);
			//System.out.println(s);
			}
		//UnreadQuee.outElem();
        System.out.println(UnreadQuee.size() + "--待处理的链接数");  
        System.out.println(FinishQuee.size() + "--已处理的页面数"); 
		DataSolver.dataSolver(data);//保存解析后的内容
		}
	}
	
}
