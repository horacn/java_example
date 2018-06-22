package com.hz.example.thread.xc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Working extends Thread{
	
	private Integer num = 0;
	
	public void workAM(){
		System.out.println("进入线程：" + Thread.currentThread().getName());
		
		num++;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
		
		String now = sdf.format(new Date());
		
		System.out.println(now + "  ::  上午需要工作！！   "+num);

	}

	@Override
	public void run() {
		workAM();
	}

}
