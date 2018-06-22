package com.hz.example.langproblem;

import java.io.UnsupportedEncodingException;

public class TestEncoding {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "sdsd";
		String destination = "adsd";

		// 判断当前字符串的编码格式
		if(destination.equals(new String(destination.getBytes("ISO8859-1"), "ISO8859-1"))) {
			destination = new String(destination.getBytes("ISO8859-1"),"UTF-8");
		}

		System.out.println("中文");

        System.out.println("中文".getBytes());

        System.out.println("中文".getBytes("GB2312"));

        System.out.println("中文".getBytes("ISO8859_1"));

        System.out.println(new String("中文".getBytes()));

        System.out.println(new String("中文".getBytes(), "GB2312"));

        System.out.println(new String("中文".getBytes(), "ISO8859_1"));

        System.out.println(new String("中文".getBytes("GB2312")));

        System.out.println(new String("中文".getBytes("GB2312"), "GB2312"));

        System.out.println(new String("中文".getBytes("GB2312"), "ISO8859_1"));

        System.out.println(new String("中文".getBytes("ISO8859_1")));

        System.out.println(new String("中文".getBytes("ISO8859_1"), "GB2312"));

        System.out.println(new String("中文".getBytes("ISO8859_1"), "ISO8859_1"));
	}
}