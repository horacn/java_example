package com.hz.example.logic;

import java.util.Arrays;

/**
 * 找出最长的字符串 和 最短的字符串
 */
public class TestStringLength {
	public static void main(String[] args) {
		String str = "123\n1234\n12345\n123456\n1234567\n7777777";
		test1(str);
	}
	
	public static void test1(String str){
		String[] array = str.split("\n");
		int [] lengths = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			lengths[i] = array[i].length();
		}
		Arrays.sort(lengths);
		int min = lengths[0];
		int max = lengths[lengths.length-1];
		String minStr = "";
		String maxStr = "";
		for (int i = 0; i < lengths.length; i++) {
			if(lengths[i] == min){
				minStr += array[i]+" ";
			}
			if(lengths[i] == max){
				maxStr += array[i]+" ";
			}
		}
		System.out.println("最短:"+minStr);
		System.out.println("最长:"+maxStr);
	}
}
