package com.nickzy.dspider;

public class TaskHandler extends Thread{
	public TaskHandler(Spider spider){
		UnreadQuee.addElem(spider.getStart_url());
		start();
	}

	@Override
	public void run() {
		System.out.println("一个线程开始...");
		String content = Downloader.getContentFromUrl(UnreadQuee.outElem());
		String data = DataParser.dataParser(content);
		DataSolver.dataSolver(data);
		
	}
	
}
