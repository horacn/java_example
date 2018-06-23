package com.hz.example.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		/**
		 * 基于TCP协议的Socket通信，实现用户登录，服务端
		*/
		ServerSocket serverSocket = null;
		//2、调用accept()方法开始监听，等待客户端的连接
		Socket socket = null;
		//3、获取输入流，并读取客户端信息
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		//4、获取输出流，响应客户端的请求
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			serverSocket = new ServerSocket(10086);
			socket = serverSocket.accept();
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info =null;
			while((info=br.readLine())!=null){
			System.out.println("Hello,我是服务器，客户端说："+info);
			}
			socket.shutdownInput();//关闭输入流
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("Hello World！");
			pw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//5、关闭资源
			try {
				pw.close();
				os.close();
				br.close();
				isr.close();
				is.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
