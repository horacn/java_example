package com.hz.example.logic.number;

/**
 * 斐波那契数列
 */
public class TestFib {
	public static void main(String args[]){
		int i;
		for(i=1; i<=100; i++)
			System.out.println(i + " " + fib(i));
	}

	public static int fib(int x) {
		if(x==1 || x==2)
			return 1;
		else
			return fib(x-1) + fib(x-2);
	}

}
