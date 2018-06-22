package com.hz.example.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestRead2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFileByLines("C:/Users/Administrator/Documents/Tencent Files/1439293823/FileRecv/new 1.txt","C:/Users/Administrator/Documents/Tencent Files/1439293823/FileRecv/new 2.txt"); 
	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 * 
	 * @param fileName
	 *            文件名
	 */
	public static void readFileByLines(String fileName,String fileNames) {
		File file = new File(fileName);
		File files=new File(fileNames);
		BufferedReader reader = null;  
		FileWriter writer=null;
		try { 
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			writer=new FileWriter(files);
			String tempString = null;
			// 查询到
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				if(tempString.contains("s8url") || tempString.contains("lat")){  
					writer.write(tempString+"\r\n");   
					System.out.println(tempString);
                 
				} 
			} 
			      reader.close();    
			      writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}
