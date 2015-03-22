package com.nickzy.dspider;

public class RunSpider {

	public static void main(String[] args) {
		Spider spider = new Spider();
		spider.addStart_url("http://www.appinn.com/");//开始url
		spider.addRegex_data("<div id=\"post-.*\n*.*<h2.*title=\"(.*)\">");//第一个匹配项
		spider.addRegex_data("<div id=\"post-.*\n*.*a href=\"(.*)\" rel");//第二个匹配项
		spider.addRegex_url("(http://www.appinn.com/page/\\d)");//匹配爬取页面
		FunctionKit.threads = 2;//默认线程数量
		TaskHandler th = new TaskHandler(spider);//开启爬虫
	}

}
