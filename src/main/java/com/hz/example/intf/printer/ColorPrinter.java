package com.hz.example.intf.printer;

public class ColorPrinter implements Printer{

	@Override
	public void print(Paper p) {
		System.out.println("ColorPrinter is work,paper type is :"+p.getType());
	}

}
