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
		start();
	}

	@Override
	public void run() {
		System.out.println("一个线程开始...");
		String content = Downloader.getContentFromUrl(UnreadQuee.outElem());//调用下载器
		List<String> data = DataParser.dataParser(content,spider);//解析下载到的内容
		DataSolver.dataSolver(data);//保存解析后的内容
		
	}
	
}
