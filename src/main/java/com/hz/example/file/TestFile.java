package com.hz.example.file;

import java.io.File;

public class TestFile {
	public static void main(String[] args) {
		File file = new File("d:/wjj");
		//文件夹名称
		System.out.println("文件夹名称： "+file.getName()+" - "+file.length());
		String[] list = file.list();
		
		//如果 是目录
		if(file.isDirectory()){
			
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				long gb = 1024*1024*1024;
				long mb = 1024*1024;
				long kb = 1024;
				String size = "";
				double length = files[i].length();
				
				if(length > gb){
					//大于1GB
					size = Math.round(length/gb*100.0)/100.0+" gb";
				}else if(length > mb){
					//大于1MB
					size = Math.round(length/mb*100.0)/100.0+" mb";
				}else if(length > kb){
					//大于1KB
					size = Math.round(length/kb*100.0)/100.0+" kb";
				}else{
					//小于1KB
					size = length+" b";
				}
				System.out.println(files[i].getName()+" - "+size);
			}
		}
	}
}
