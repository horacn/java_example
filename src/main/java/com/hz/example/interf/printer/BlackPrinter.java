package com.hz.example.interf.printer;

public class BlackPrinter implements Printer{

	@Override
	public void print(Paper p) {
		System.out.println("BlackPrinter is work,paper type is :"+p.getType());
	}

}
