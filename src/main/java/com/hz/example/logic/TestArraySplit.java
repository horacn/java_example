package com.hz.example.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 业务逻辑：给你一个不为空的数组，如果有一个地方可以拆分数组，拆分之后的数组 一方的数字的总和等于另一方的数字的总和。那就返回true
 * @author hezhao
 * @Time   2016年6月15日 下午1:06:19
 * @Description 无
 * @Version V 1.0
 */
public class TestArraySplit {
	public static void main(String[] args) {
		boolean b1 = canBlance(Arrays.asList(1, 1, 1, 2, 1)); //true
		boolean b2 = canBlance(Arrays.asList(2, 1, 1, 2, 1)); //false
		boolean b3 = canBlance(Arrays.asList(10, 10)); //true
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}
	
	public static boolean canBlance(List<Integer> list){
		Integer sum = 0;
		for (Integer i : list) {
			sum += i;
		}
		
		List<Integer> before = new ArrayList<>();
		List<Integer> after = new ArrayList<>();
		Integer sum_flag = 0;
		for (Integer j : list) {
			sum_flag += j;
			if(sum_flag > sum/2){
				after.add(j);
			}else{
				before.add(j);
			}
		}
		
		Integer sum_before = 0;
		Integer sum_after = 0;
		for (Integer x : before) {
			sum_before+=x;
		}
		for (Integer y : after) {
			sum_after+=y;
		}

		return sum_before == sum_after;
	}
}