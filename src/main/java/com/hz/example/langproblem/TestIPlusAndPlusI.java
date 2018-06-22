package com.hz.example.langproblem;

/**
 * i++ 和 ++i
 */
public class TestIPlusAndPlusI {
	public static void main(String[] args) {
		int x=8, y=2, z;

		x = ++x * y;
		System.out.println(x); // 18

		z = x / y++;
		System.out.println(z); // 9
	}
}
