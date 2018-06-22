package com.hz.example.algorithm;

import com.hz.example.util.StopWatch;

import java.util.Arrays;
import java.util.Random;

/**
 * 查找
 *
 * @author hezhao
 * @Time 2016年3月17日 下午5:08:06
 * @Description 无
 * @version V 1.0
 */
public class Lookup {
	static int[] array = new int[2000000];
	static int key = 1515581;
	static int key_index = 1459023;

	static {
		// 插入1w个随机数到数组中
		for (int i = 0; i < array.length; i++) {
			int value = new Random().nextInt(3000000);
			if(value!=key)	array[i] = value;
		}
		array[key_index] = key;
	}

	public static void main(String[] args) {
		StopWatch watch = new StopWatch("查找");

		String msg_sequence = "顺序查找";
		watch.start(msg_sequence);
		int index = sequenceSearch(array, key);
		watch.stop();
		System.out.println(msg_sequence + " - 已经在数组中找到 ["+array[index]+"] ，索引位置为： " + index);

		String msg_binary = "二分查找";
		watch.start(msg_binary);
		int[] clone = array.clone();
		Arrays.sort(clone);
		int key_2 = clone[key_index];
		int index_binary = sequenceSearch(clone, key_2);
		watch.stop();
		System.out.println(msg_binary + " - 已经在数组中找到 ["+clone[index_binary]+"]，索引位置为： " + index_binary);

		System.out.println();
		System.out.println(watch.prettyPrint());
	}

	// 顺序查找
	public static int sequenceSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			// 查找成功，返回序列号
			if (array[i] == key) {
				return i;
			}
		}
		// 未能查找，返回-1
		return -1;
	}

	// 二分查找 | 折半查找
	// 第一： 数组必须有序
	// 第二： 这种查找只限于线性的顺序存储结构。
	public static int binarySearch(int[] array, int key) {
		// 最低线
		int low = 0;
		// 最高线
		int high = array.length - 1;
		while (low <= high) {
			// 取中间值
			int middle = (low + high) / 2;
			if (array[middle] == key) {
				return middle;
			} else if (array[middle] > key) {
				// 下降一半
				high = middle - 1;
			} else {
				// 上升一半
				low = middle + 1;
			}
		}
		// 未找到
		return -1;
	}
}