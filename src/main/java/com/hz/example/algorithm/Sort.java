package com.hz.example.algorithm;

import com.hz.example.util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 八大排序
 *
 * @author hezhao
 * @Time 2016年3月17日 上午10:15:38
 * @Description 无
 * @version V 1.0
 */
public class Sort {

	static int[] array = new int[2000];

	static {
		// 插入1w个随机数到数组中
		for (int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(100000);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		StopWatch watch = new StopWatch("排序");

		String msg_arrays = "Arrays.sort排序";
		watch.start(msg_arrays);
		int[] clone_arrays = array.clone();
		Arrays.sort(clone_arrays);
		watch.stop();
		printTop10(clone_arrays, msg_arrays);

		String msg_parallelSort = "Arrays.parallelSort排序";
		watch.start(msg_parallelSort);
		int[] clone_parallelSort = array.clone();
		Arrays.parallelSort(clone_parallelSort);
		watch.stop();
		printTop10(clone_parallelSort, msg_parallelSort);

		String msg1 = "冒泡排序";
		watch.start(msg1);
		int[] clone1 = array.clone();
		bubbleSort(clone1);
		watch.stop();
		printTop10(clone1, msg1);

		String msg2 = "快速排序";
		watch.start(msg2);
		int[] clone2 = array.clone();
		quickSort(clone2, 0, clone2.length-1);
		watch.stop();
		printTop10(clone2, msg2);

		String msg3 = "直接插入排序";
		watch.start(msg3);
		int[] clone3 = array.clone();
		insertSort(clone3);
		watch.stop();
		printTop10(clone3, msg3);

		String msg4 = "希尔排序";
		watch.start(msg4);
		int[] clone4 = array.clone();
		shellSort(clone4);
		watch.stop();
		printTop10(clone4, msg4);

		String msg5 = "简单选择排序";
		watch.start(msg5);
		int[] clone5 = array.clone();
		selectSort(clone5);
		watch.stop();
		printTop10(clone5, msg5);

		String msg6 = "堆排序";
		watch.start(msg6);
		int[] clone6 = array.clone();
		heapSort(clone6);
		watch.stop();
		printTop10(clone6, msg6);

		String msg7 = "归并排序";
		watch.start(msg7);
		int[] clone7 = array.clone();
		mergingSort(clone7, 0, clone7.length - 1);
		watch.stop();
		printTop10(clone7, msg7);

		String msg8 = "基数排序";
		watch.start(msg8);
		int[] clone8 = array.clone();
		radixSort(clone8);
		watch.stop();
		printTop10(clone8, msg8);

		System.out.println();
		System.out.println(watch.prettyPrint());
	}

	// 冒泡排序
	public static void bubbleSort(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	// 快速排序
	public static void quickSort(int[] array, int low, int high) {
		if (array == null || array.length == 0) {
			return;
		}
		if (low < high) {
			int middle = getMiddle(array, low, high); // 将list数组进行一分为二
			quickSort(array, low, middle - 1); // 对低字表进行递归排序
			quickSort(array, middle + 1, high); // 对高字表进行递归排序
		}
	}

	// 快排 返回中轴
	public static int getMiddle(int[] array, int low, int high) {
		int tmp = array[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && array[high] >= tmp) {
				high--;
			}
			array[low] = array[high]; // 比中轴小的记录移到低端
			while (low < high && array[low] <= tmp) {
				low++;
			}
			array[high] = array[low]; // 比中轴大的记录移到高端
		}
		array[low] = tmp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}

	// 直接插入排序
	public static void insertSort(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int temp = 0;
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			temp = array[i];
			for (; j >= 0 && temp < array[j]; j--) {
				array[j + 1] = array[j]; // 将大于temp的值整体后移一个单位
			}
			array[j + 1] = temp;
		}
	}

	// 希尔排序（最小增量排序）
	public static void shellSort(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		double d1 = array.length;
		int temp = 0;
		while (true) {
			d1 = Math.ceil(d1 / 2);
			int d = (int) d1;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < array.length; i += d) {
					int j = i - d;
					temp = array[i];
					for (; j >= 0 && temp < array[j]; j -= d) {
						array[j + d] = array[j];
					}
					array[j + d] = temp;
				}
			}
			if (d == 1)
				break;
		}
	}

	// 简单选择排序
	public static void selectSort(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int position = 0;
		for (int i = 0; i < array.length; i++) {
			int j = i + 1;
			position = i;
			int temp = array[i];
			for (; j < array.length; j++) {
				if (array[j] < temp) {
					temp = array[j];
					position = j;
				}
			}
			array[position] = array[i];
			array[i] = temp;
		}
	}

	// 堆排序
	public static void heapSort(int[] a) {
		int arrayLength = a.length;
		// 循环建堆
		for (int i = 0; i < arrayLength - 1; i++) {
			// 建堆
			buildMaxHeap(a, arrayLength - 1 - i);
			// 交换堆顶和最后一个元素
			swap(a, 0, arrayLength - 1 - i);
		}
	}

	public static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	// 对data数组从0到lastIndex建大顶堆
	public static void buildMaxHeap(int[] data, int lastIndex) {
		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k保存正在判断的节点
			int k = i;
			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				// k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				// 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if (biggerIndex < lastIndex) {
					// 若果右子节点的值较大
					if (data[biggerIndex] < data[biggerIndex + 1]) {
						// biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				// 如果k节点的值小于其较大的子节点的值
				if (data[k] < data[biggerIndex]) {
					// 交换他们
					swap(data, k, biggerIndex);
					// 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	// 归并排序
	public static void mergingSort(int[] data, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			// 找出中间索引
			int center = (left + right) / 2;
			// 对左边数组进行递归
			mergingSort(data, left, center);
			// 对右边数组进行递归
			mergingSort(data, center + 1, right);
			// 合并
			merge(data, left, center, right);

		}
	}

	public static void merge(int[] data, int left, int center, int right) {
		// TODO Auto-generated method stub
		int[] tmpArr = new int[data.length];
		int mid = center + 1;
		// third记录中间数组的索引
		int third = left;
		int tmp = left;
		while (left <= center && mid <= right) {
			// 从两个数组中取出最小的放入中间数组
			if (data[left] <= data[mid]) {
				tmpArr[third++] = data[left++];
			} else {
				tmpArr[third++] = data[mid++];
			}
		}
		// 剩余部分依次放入中间数组
		while (mid <= right) {
			tmpArr[third++] = data[mid++];
		}
		while (left <= center) {
			tmpArr[third++] = data[left++];
		}
		// 将中间数组中的内容复制回原数组
		while (tmp <= right) {
			data[tmp] = tmpArr[tmp++];
		}
	}

	//基数排序
	public static void radixSort(int[] array) {
		// 首先确定排序的趟数;
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int time = 0;
		// 判断位数;
		while (max > 0) {
			max /= 10;
			time++;
		}
		// 建立10个队列;
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}
		// 进行time次分配和收集;
		for (int i = 0; i < time; i++) {
			// 分配数组元素;
			for (int j = 0; j < array.length; j++) {
				// 得到数字的第time+1位数;
				int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(array[j]);
				queue.set(x, queue2);
			}
			int count = 0;// 元素计数器;
			// 收集队列元素;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					ArrayList<Integer> queue3 = queue.get(k);
					array[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
	}

	// 输出前十个数字
	public static void printTop10(int[] result, String msg) {
		System.out.print("[" + msg + "] 输出前十个数:");
		for (int i = 0; i < 10; i++) {
			System.out.print(result[i]);
			if (i < 9)
				System.out.print(",");
		}
		System.out.println();
	}
}
