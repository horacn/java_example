package com.hz.example.javafeatures.java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 前面提到过，Map类型不支持stream，不过Map提供了一些新的有用的方法来处理一些日常任务
 *
 * @author hezhao
 * @Time   2016年3月3日 下午5:02:47
 * @Description 无
 * @version V 1.0
 */
public class TestMap {
	Map<Integer, String> map = new HashMap<>();

	@Test
	@Before
	public void test1(){
		//putIfAbsent 不需要我们做额外的存在性检查,直接插入
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}
	}
	@Test
	public void test2(){
		//forEach 接收一个Consumer接口来对map里的每一个键值对进行操作
		map.forEach((id, val) -> System.out.println(val));

	}
	//下面的例子展示了map上的其他有用的函数：

	@Test
	public void test3(){
		//Present - 存在  ，存在则重新赋值
		map.computeIfPresent(3, (num,val) -> val+num);
		System.out.println(map.get(3));

		map.computeIfPresent(9, (num, val) -> null);
		System.out.println(map.containsKey(9));

		//absent - 不存在 ,不存在则重新赋值
		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23));

		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3));

		//接下来展示如何在Map里删除一个键值全都匹配的项
		map.remove(3, "val3");
		System.out.println(map.get(3));             // val33
		map.remove(3, "val33");
		System.out.println(map.get(3));             // null

		//存在就返回值，不存在就返回给出的默认值
		System.out.println(map.getOrDefault(24, "该项不存在"));

		//对Map的元素做合并也变得很容易了
		//Merge做的事情是如果键名不存在则插入，否则则对原键对应的值做合并操作并重新插入到map中
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));             // val9
		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		System.out.println(map.get(9));             // val9concat
	}

	//测试 关于Map key是否允许为null
	@Test
	public void test4(){
		System.out.println("start...");
		Map<String,String> map = Maps.newHashMap();
		long begin = System.currentTimeMillis();
		//map.put(null, "2");
		for (int i = 0; i < 100000; i++) {
			map.put("name"+i,"zhangsan"+i);
		}

		List<String> keys = Lists.newArrayList();
		for (String key : map.keySet()) {
			keys.add(key);
		}
		Collections.sort(keys);

		Map<String, String> map2 = new TreeMap<>();
		for (int i = 0; i < keys.size(); i++) {
			map2.put(keys.get(i), map.get(keys.get(i)));
		}
		map2.forEach((key,val) -> System.out.println(val));
//		for (String string : map2.keySet()) {
//			System.out.println(map2.get(string));
//		}

		long end = System.currentTimeMillis();
		System.out.println(end-begin+" 毫秒");
	}
}
