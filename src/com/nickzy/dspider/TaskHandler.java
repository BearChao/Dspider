package com.nickzy.dspider;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;


/**
 * @author zynick
 *
 */
public class TaskHandler {
	int threads = FunctionKit.threads;//默认线程数
	Spider spider;
	long start = System.currentTimeMillis(); 
	public TaskHandler(Spider spider){
		this.spider = spider;
		Iterator iterator = spider.getStart_url().iterator();
		while(iterator.hasNext())
		UnreadQuee.addElem((String) iterator.next());
		System.out.println("------------------一个线程开始："+Thread.currentThread().getName()+"线程");
		System.out.println("------------------检测到"+UnreadQuee.size()+"条url记录");
		//threads = 3;//测试时修改线程数量
		start();
	}

	public void start() {
			CountDownLatch countDownLatch = new CountDownLatch(threads);
			DataSolver ds = new DataSolver();//开启数据处理线程
			ds.start();
			System.out.println("解析器开启成功");
			for(int i=1;i<=threads;i++){
				Downloader downloader = new Downloader(spider,countDownLatch);
				Thread thread = new Thread(downloader,String.valueOf(i));
				System.out.println("------------------创建线程"+i+"线程");
				thread.start();//调用下载器	
				try {
					Thread.sleep(1000);//多线程开启延时
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
			System.out.println("------------------"+threads+"个线程开启完毕");
			


			//DataSolver.dataSolver();//在数据获取完毕后进行解析，方便调试
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("任务完成");
			FunctionKit.isDone = true;
			long end = System.currentTimeMillis();  
	        System.out.println("执行时长：" + (end - start)); 
			
	}
}
	
