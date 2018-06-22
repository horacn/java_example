package com.hz.example.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找出一个数组中所有不重复的字符组合
 */
public class TestSearchNotRepetitionStr {
	public static void main(String[] args) {
		String[] strs = {"a","b","c","d","e","f","g","h","i","j"};
		
		List<String> words = new ArrayList<String>();
		
		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < strs.length; j++) {
				if(!words.contains(strs[i]+strs[j]) && !words.contains(strs[j]+strs[i])){
					words.add(strs[i]+strs[j]);
				}
			}
		}
		
		System.out.println("size: " + words.size());
		System.out.println("========================================");
		for (int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i));
		}
		
	}
}
