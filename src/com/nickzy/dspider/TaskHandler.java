package com.nickzy.dspider;


/**
 * @author zynick
 *
 */
public class TaskHandler {
	int threads = FunctionKit.threads;//默认线程数
	Spider spider;
	public TaskHandler(Spider spider){
		this.spider = spider;
		UnreadQuee.addElem(spider.getStart_url());
		System.out.println("------------------一个线程开始："+Thread.currentThread().getName()+"线程");
		System.out.println("------------------检测到"+UnreadQuee.size()+"条url记录");
		threads = 3;
		start();
	}

	public void start() {

			for(int i=1;i<=threads;i++){
				Downloader downloader = new Downloader(spider);
				Thread thread = new Thread(downloader,String.valueOf(i));
				System.out.println("------------------创建线程"+i+"线程");
				thread.start();//调用下载器	
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
			System.out.println("------------------"+threads+"个线程开启完毕");
			
	}
}
	
