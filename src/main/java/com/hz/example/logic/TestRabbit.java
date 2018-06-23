package com.hz.example.logic;

import java.util.ArrayList;
import java.util.List;

import com.hz.example.pojo.Rabbit;
import org.junit.Test;

/**
 * 经典兔子问题
 */
public class TestRabbit {

	@Test
	public void test1() {
		int month = 36;

		List<Rabbit> rabbits = new ArrayList<Rabbit>();
		Rabbit r1 = new Rabbit();
		r1.setAge(1);
		rabbits.add(r1);

		for (int i = 1; i <= month; i++) {
			for (int j = 0; j < rabbits.size(); j++) {
				Rabbit r = rabbits.get(j);
				if(r.getAge()>=3){
					Rabbit new_r1 = new Rabbit();
					new_r1.setAge(1);
					rabbits.add(new_r1);
				}else{
					r.setAge(r.getAge()+1);
				}
			}
			System.out.println("第" + i + "个月 : " + rabbits.size() + " 只兔子");
		}
	}

	@Test
	public void test2() {
		int month = 36;
		int[] fab = new int[month];
		fab[0] = 1;
		fab[1] = 1;
		for (int i = 2; i < month; i++) {
			fab[i] = fab[i-1] + fab[i-2];
		}
		for (int i = 0; i < month; i++) {
			System.out.println("第" + (i+1) + "个月兔子为:" + fab[i]);
		}
	}

	/**
	 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，每对小兔子长到第三个月后每个月再生一对兔子，假如兔子都不死，请写出一段程序计算并输出一年内每个月的兔子数量。
	 */
	@Test
	public void test3() {
		long s1 = 1;
		long s2 = 1;
		int count = 12; // 12个月
		long temp;
		for (int i = 1; i <= count; i++) {
			if (i == 1) {
				System.out.println("第" + i + "个月的兔子对数：" + s1);
				continue;
			} else if (i == 2) {
				System.out.println("第" + i + "个月的兔子对数：" + s2);
				continue;
			} else {
				temp = s2;
				s2 = s1 + s2;
				s1 = temp;
				System.out.println("第" + i + "个月的兔子对数：" + s2);
			}
		}
	}

}
