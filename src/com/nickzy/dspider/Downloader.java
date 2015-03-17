package com.nickzy.dspider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Downloader implements  Runnable {
	Spider spider;
	public Downloader(Spider spider){
		this.spider = spider;
	}
	@Override
	public void run() {
		String threadid = "线程"+Thread.currentThread().getName()+":";
		System.out.println("------------------进入"+threadid);
		System.out.println(threadid+"检测到"+UnreadQuee.size()+"条url记录");
		while(!UnreadQuee.isEmpty()){
			String url = UnreadQuee.outElem();
			if(!FinishQuee.isContains(url)){
				FinishQuee.addElem(url);
				StringBuffer sb = new StringBuffer(); 
					try{
							System.out.println(threadid+"正在下载："+url);
							HttpURLConnection huc = (HttpURLConnection)new URL(url).openConnection();
							huc.setConnectTimeout(10000);
							huc.setDoOutput(true);
							huc.setUseCaches(false);
							BufferedReader reader = new BufferedReader(new InputStreamReader(huc.getInputStream()));
							String line;
							while((line = reader.readLine()) != null){
								sb.append(line);
								sb.append("\n");
								}
							reader.close();

							System.out.println(threadid+"下载完毕");
							String content = sb.toString();
							String links = FunctionKit.getHrefOfContent(content);//存储符合要求的链接地址
							List<String> link = DataParser.linkParser(content,spider);//匹配网页内的链接地址
							for(String s:link) 
								UnreadQuee.addElem(s);	
							List<String> data = DataParser.dataParser(content,spider);//匹配网页内容
														
					        System.out.println(threadid+"待处理的链接数"+UnreadQuee.size());  
					        System.out.println(threadid+"已处理的页面数"+FinishQuee.size()); 
							DataSolver.dataSolver(data);//保存解析后的内容
							
					}catch (Exception e){
							System.err.println(threadid+"下载失败");
							//e.printStackTrace();
					}
			}
		}System.out.println(threadid+"成功退出");
	}
}
