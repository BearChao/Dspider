package com.nickzy.dspider;

public class RunSpider {

	public static void main(String[] args) {
		Spider spider = new Spider();
		spider.setStart_url("http://www.w3cschool.cc/java/java-regular-expressions.html");
		spider.setRegex_data("\\w+类");
		TaskHandler th = new TaskHandler(spider);


	}

}
