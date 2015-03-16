package com.nickzy.dspider;

public class RunSpider {

	public static void main(String[] args) {
		Spider spider = new Spider();
		spider.setStart_url("http://www.appinn.com/");
		spider.setRegex_data("<h2 class=\"entry-title\"><a href.+\">(.+)+</a></h2>");
		spider.setRegex_url("(http://www.appinn.com/page/[2,5]/)|");
		TaskHandler th = new TaskHandler(spider);


	}

}
