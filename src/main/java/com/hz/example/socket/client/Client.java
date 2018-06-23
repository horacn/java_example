package com.hz.example.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		//客户端
		//1、创建客户端Socket，指定服务器地址和端口
		Socket socket = null;
		//2、获取输出流，向服务器端发送信息
		OutputStream os = null;
		PrintWriter pw = null;
		//3、获取输入流，并读取服务器端的响应信息
		InputStream is = null;
		BufferedReader br = null;
		try {
			socket = new Socket("127.0.0.1",10086);
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("用户名：admin；密码：admin");
			pw.flush();
			socket.shutdownOutput();
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info=br.readLine())!=null){
			 System.out.println("Hello,我是客户端，服务器说："+info);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//4、关闭资源
				br.close();
				is.close();
				pw.close();
				os.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		  
	}
}
