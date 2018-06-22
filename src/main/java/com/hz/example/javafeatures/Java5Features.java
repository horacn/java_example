package com.hz.example.javafeatures;

import static com.hz.example.pojo.StaticVo.prinf;

import org.junit.Test;

/**
 * JDK1.5新特性
 *
 * 1.自动装箱与拆箱
 * 2.枚举
 * 3.静态导入
 * 4.可变参数（Varargs）
 * 5.内省（Introspector）
 * 6.泛型(Generic)
 * 7.For-Each循环
 *
 * @author hezhao
 * @Time   2016年3月2日 下午2:23:28
 * @Description 无
 * @version V 1.0
 */
public class Java5Features {

    int j = 0;

	@Test
	public void test1() {
		Integer i = 1;
		// int j = i.intValue();
        System.out.println(j);
    }

    @Test
    public void test2() {
        prinf();
    }

    @Test
    public void test3() {
        show("abc");
        show("abc",1);
        show("abc",new int[]{1,2,3});
    }

    public void show(String str,int...nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]+" : "+str);
        }
        System.out.println("==========");
    }

}
