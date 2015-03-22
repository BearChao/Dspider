package com.nickzy.dspider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataSolver extends Thread{
	String datasaved;
	JSONObject jsonObject = new JSONObject();
	JSONArray jsonArray = new JSONArray();
	@Override
	public void run() {
		while(!FunctionKit.isDone){
			if(!PipelineQuee.isEmpty()){
				Map<Integer,List> m = PipelineQuee.outElem();
				for(int i=1;i<=FunctionKit.reg_datas;i++){
					System.out.print("第"+i+"个匹配:");
					List<String> l = new ArrayList<String>(m.get(i));
					jsonArray.put(l);
					jsonObject.put(String.valueOf(i),jsonArray);
					for(String s:l){
						System.out.print(s+"|");
					}
					System.out.println("\n");

				}
				System.out.println("--------------------------");
			}
		}
		datasaved=jsonObject.toString();
//		try {
//			writeToFile();//测试时没有选择写入文件
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	//写入数据到文件
	private void writeToFile()throws IOException{
		File file = new File("E:\\data.json");
		if(!file.exists())
			file.createNewFile();
		FileWriter writer = new FileWriter(file);
		writer.write(datasaved);
		writer.flush();
		writer.close();
	}

	//此方法设置静态为检查输出测试所用
	public static boolean dataSolver(){
		System.err.println(FunctionKit.reg_datas);
		while (!PipelineQuee.isEmpty()){
			Map<Integer,List> m = PipelineQuee.outElem();
			for(int i=1;i<=FunctionKit.reg_datas;i++){
				System.out.print("第"+i+"个匹配:");
				List<String> l = new ArrayList<String>(m.get(i));
				for(String s:l)
					System.out.print(s+"|");
				System.out.println("\n");
			}
			System.out.println("\n--------------------------");
		}
	return true;
	}
}
