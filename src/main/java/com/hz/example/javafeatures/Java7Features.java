package com.hz.example.javafeatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
/**
 * JDK 1.7 新特性
 *
 * @author hezhao
 * @Time   2016年3月2日 下午4:52:00
 * @Description 无
 * @version V 1.0
 */
public class Java7Features {

	/**
	 * switch中可以使用字串了
	 */
	@Test
	public void test1() {
		switch1();
		System.out.println("==========");
		switch2();
		System.out.println("==========");
		switch3();
	}

	private void switch1() {
		int i = 2;
		switch (i) {
			case 1:
				System.out.println("a");
				break;
			case 2:
				System.out.println("b");
				break;
			case 3:
				System.out.println("c");
				break;
			default:
				System.out.println("!");
				break;
		}
	}
	private void switch2() {
		char i = 'a';
		byte j = 'a';
		switch (i) {
			case 'a':
				System.out.println("a");
			case 'b':
				System.out.println("b");
			case 'c':
				System.out.println("c");
			default:
				System.out.println("!");
		}
	}
	private void switch3() {
		String i = "我";
		switch (i) {
			case "我":
				System.out.println("a");
				break;
			case "你":
				System.out.println("b");
				break;
			case "他":
				System.out.println("c");
				break;
			default:
				System.out.println("!");
				break;
		}
	}

	//泛型实例化类型自动推断
	@Test
	public void test2() {
		List<String> strs = new ArrayList<>();
		//...
	}

	/**
	 * 新增一些取环境信息的工具方法
	 */
	@Test
	public void test3(){
		//数值可加下划线
		int i = 12_43_56;
		System.out.println(i);

		//支持二进制文字
		int binary = 0b1001_1001;
		System.out.println(binary);
	}

}
