package com.nickzy.dspider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {
	public static String getContentFromUrl(String url){
		StringBuffer sb = new StringBuffer(); 
		//boolean isDownloaded = false;
		try{
			System.out.println("正在下载："+url);
			FinishQuee.addElem(url);
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
			//isDownloaded = true;
			System.out.println("下载完毕");
			}catch (Exception e){
				System.err.println("下载失败");
				//isDownloaded = false;
			}
		return sb.toString();
	}
}
