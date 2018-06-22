package com.hz.example.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestRead {
	public static void main(String[] args) throws Exception {
//		StringBuilder sb = new StringBuilder();
//		try(  
//                //创建字符输出流,使用java7新特性，自动关闭资源  
//                FileReader fr =  new FileReader("C:/Users/Administrator/Documents/Tencent Files/1439293823/FileRecv/new 1.txt");  
//        ){  
//            //创建一个长度为32的字符数组,数组不够大，需要多次读取，但是不会出现中文注释乱码问题  
//            char[] cbuf = new char[32];  
//            //用于保存实际读取的字符数  
//            int hasRead = 0;  
//            //使用循环读取数据  
//            while((hasRead = fr.read(cbuf)) > 0){  
//                String str = new String(cbuf,0,hasRead);
//                if(str.contains("host")){
//                	System.out.println(str);
//                }
//            	sb.append(str);
//            }  
//            fr.close();
//            
//        }catch(IOException ex){  
//              
//            ex.printStackTrace();  
//        }
          
		
		
//		 FileReader fr = new FileReader("C:/Users/Administrator/Documents/Tencent Files/1439293823/FileRecv/new 1.txt");
//		    try {
//		        int i;
//		        while ((i = fr.read()) != -1) {
//		            System.out.print((char) i);
//		        }
//		    } finally {
//		        fr.close();
//		    }
		
		FileReader fr =  new FileReader ("C:/Users/Administrator/Documents/Tencent Files/1439293823/FileRecv/new 1.txt");

        BufferedReader br = new BufferedReader (fr);

        String s;

         while ((s = br.readLine() )!=null) {
        	 if(s.contains("host") || s.contains("app")){
             	System.out.println(s);
             }
           

          }

        fr.close();

  }
	}
