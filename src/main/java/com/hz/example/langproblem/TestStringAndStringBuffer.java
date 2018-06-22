package com.hz.example.langproblem;

import org.junit.Test;

/**
 * 测试String和StringBuffer的性能
 */
public class TestStringAndStringBuffer {

	/**
	 * String
	 */
	@Test
	public void test1(){
		long begin = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < 100000; i++) {
			s += i;
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin+" 毫秒");//17572 毫秒
	}

	/**
	 * StringBuffer
	 */
	@Test
	public void test2(){
		long begin = System.currentTimeMillis();
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < 100000; i++) {
			s.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin+" 毫秒");//22 毫秒
	}

	/**
	 * StringBuilder
	 */
	@Test
	public void test3(){
		long begin = System.currentTimeMillis();
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < 100000; i++) {
			s.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin+" 毫秒");//15 毫秒
	}

	/**
	 * 值传递，不会改变str的值
	 * @param str
	 */
	public String changeStr(String str){
		str = "welcome";
		return str;
	}

	@Test
	public void test4(){
		String str = "123";
		System.out.println(str);

		String newStr = changeStr(str);
		System.out.println(newStr);
		System.out.println(str);
	}
}