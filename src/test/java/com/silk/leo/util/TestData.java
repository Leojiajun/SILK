package com.silk.leo.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class TestData {
	private String filePath;
	private String nextLine[];
	List<String[]> approvalList = new ArrayList<String[]>();
	CSVReader reader;
	
	private String value;
	
	public TestData(String filePath){
		this.filePath = filePath;
	}
	
	/**
	 * @author leo
	 * @param columnName列名
	 * @param lineName行名
	 * @return
	 */
	public String getTestData(String columnName,String lineName){
				
		try {
			reader = new CSVReader(new FileReader(filePath));
			try {
				while ((nextLine = reader.readNext()) != null) {
					//System.out.println("aa");
					approvalList.add(nextLine);					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//获取某一列
			int count = 0;
			int index = 0;
			
			for(String j:approvalList.get(0)){
				count++;
				if(j.equals(columnName)){
					index = count-1;
				}
			}
					
			
			//获取某一行
			for(String[] i : approvalList){
				if(i[0].equals(lineName))
					   value = i[index].toString();
			}
							
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	
	
	
	public static void main(String[] args){
		TestData a = new TestData(System.getProperty("user.dir")+"\\Tools\\testdata.csv");
		

		
		System.out.println(a.getTestData("username", "integration_login")+":"+a.getTestData("password", "integration_login"));
		
	}
}
