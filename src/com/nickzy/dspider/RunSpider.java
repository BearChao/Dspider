package com.nickzy.dspider;

public class RunSpider {

	public static void main(String[] args) {
		Spider spider = new Spider();
		spider.setStart_url("http://localhost:8080/test.html");
		TaskHandler th = new TaskHandler(spider);


	}

}
