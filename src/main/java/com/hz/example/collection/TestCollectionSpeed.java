package com.hz.example.collection;

import com.hz.example.util.StopWatch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 集合效率测试
 */
public class TestCollectionSpeed {

	@Test
	public void test1(){
		int size = 1000000;
		StopWatch watch = new StopWatch("集合效率测试");

		watch.start("LinkedList add");
		LinkedList list = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			list.add(Math.random()*i);
		}
		watch.stop();

		watch.start("LinkedList get");
		for (Object object : list) {
//			System.out.println(object);
		}
		watch.stop();

		watch.start("ArrayList add");
		ArrayList list2 = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list2.add(Math.random()*i);
		}
		watch.stop();

		watch.start("ArrayList get");
		for (Object object : list2) {
//			System.out.println(object);
		}
		watch.stop();

		watch.start("HashSet add");
		Set set = new HashSet();
		for (int i = 0; i < size; i++) {
			set.add(Math.random()*i);
		}
		watch.stop();

		watch.start("HashSet get");
		for (Object object : set) {
//			System.out.println(object);
		}
		watch.stop();

		System.out.println();
		System.out.println(watch.prettyPrint());
	}
}
