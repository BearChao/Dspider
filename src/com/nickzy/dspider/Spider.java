package com.nickzy.dspider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zynick
 *
 */
public class Spider {
	private List<String> start_url = new ArrayList<String>();//初始URL
	private List<String> regex_url = new ArrayList<String>();//匹配链接列表
	private List<String> regex_data = new ArrayList<String>();//匹配内容列表
	private int depth;
	
	
	public Spider() {
		this.depth = FunctionKit.depth;
	}

	public List<String> getStart_url() {
		return start_url;
	}
	public void addStart_url(String start_url) {
		this.start_url.add(start_url);
	}
	public List<String> getRegex_url() {
		return regex_url;
	}
	public void addRegex_url(String regex_url) {
		this.regex_url.add(regex_url);
	}
	public List<String> getRegex_data() {
		return regex_data;
	}
	public void addRegex_data(String regex_data) {
		this.regex_data.add(regex_data);
		FunctionKit.reg_datas = this.regex_data.size();
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
}
