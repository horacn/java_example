package com.hz.example.javafeatures.java8;

public class TestFormula {

	public static void main(String[] args) {
		Formula formula = new Formula() {
		    @Override
		    public double calculate(double a) {
		        return sqrt(a * 100);
		    }
		};
		System.out.println(formula.calculate(100));     // 100.0
		System.out.println(formula.sqrt(16));           // 4.0
		System.out.println(formula.square(3));			//9.0
		System.out.println(formula.power(2, 5));		//32.0
	
	}
}
