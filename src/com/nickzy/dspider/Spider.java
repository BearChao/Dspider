package com.nickzy.dspider;

/**
 * @author zynick
 *
 */
public class Spider {
	private String start_url;
	private String regex_url;
	private String regex_data;
	private int depth;
	
	public Spider(String start_url,String regex_url,String regex_data){
		this.start_url = start_url;
		this.regex_url = regex_url;
		this.regex_data = regex_data;
		this.depth = FunctionKit.depth;
	}
	
	public Spider() {
		
	}

	public String getStart_url() {
		return start_url;
	}
	public void setStart_url(String start_url) {
		this.start_url = start_url;
	}
	public String getRegex_url() {
		return regex_url;
	}
	public void setRegex_url(String regex_url) {
		this.regex_url = regex_url;
	}
	public String getRegex_data() {
		return regex_data;
	}
	public void setRegex_data(String regex_data) {
		this.regex_data = regex_data;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
}
