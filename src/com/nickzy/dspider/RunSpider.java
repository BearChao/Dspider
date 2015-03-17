package com.nickzy.dspider;

public class RunSpider {

	public static void main(String[] args) {
		Spider spider = new Spider();
		spider.setStart_url("http://www.appinn.com/");
		spider.setRegex_data("<div id=\"post.+\\n+.+title=\"(.+)\"");
		spider.setRegex_url("(http://www.appinn.com/page/\\d{0,1}/)|");
		TaskHandler th = new TaskHandler(spider);
	}

}
