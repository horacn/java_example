package com.hz.example.intf.printer;

public class Factory {
	public static void main(String[] args) {
		
		Paper a4 = new A4Paper();
		Paper a5 = new A5Paper();
		
		Printer bp = new BlackPrinter();
		Printer cp = new ColorPrinter();
		
		bp.print(a4);
		bp.print(a5);
		cp.print(a4);
		cp.print(a5);
		
	}
}
