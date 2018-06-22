package com.hz.example.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class TestMyArrayList {
//	public static void main(String[] args) {
//		StringBuilder str1 = new StringBuilder("hello");
//		StringBuilder str2 = str1;
//		str2.append(",world");
//		System.out.println(str1.toString());
		
//		Boolean b = true;
//		xxx(b);
//		System.out.println(b);
		
//	}
	
	public static void main(String[] args) {
		List<Integer> list = new MyArrayList<>(3);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(9);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(9);
//		list.remove(1);
//		list.remove((Object)9);
		ArrayList<Integer> myArrayList = new ArrayList<>();
		myArrayList.add(1);
		myArrayList.add(2);
		myArrayList.add(32);
//		list.removeAll(myArrayList);
		
//		list.add(2, 45);
//		list.addAll(myArrayList);
//		list.addAll(3,myArrayList);
		
//		List<Integer> subList = list.subList(2, 5);
		
//		Object[] array = list.toArray();
		
		System.out.println(list.indexOf(9));
		System.out.println(list.lastIndexOf(9));
		System.out.println(list.contains(91));
		System.out.println(list.containsAll(myArrayList));
		
		
		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+",");
		}
	}
	
	public static void xxx(Boolean b){
		b=!b;
		System.out.println(b);
	}
}
