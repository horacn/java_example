package com.hz.example.lib;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

/**
 * Guava - Google的一个开源类库。包含很多工具类
 * @author hezhao
 * @Time   2016年3月4日 上午10:10:42
 * @Description 无
 * @version V 1.0
 */
public class TestGuava {
	@Test
	public void test1(){
		List<String> names = Lists.newArrayList("TaoBao","ZhiFuBao");
		List<String> lowercaseNames = FluentIterable.from(names).transform(new Function<String, String>() {
			@Override
			public String apply(String name) {
				return name.toUpperCase();
			}
		}).toList();

		lowercaseNames.forEach(System.out::println);
	}

	@Test
	public void test2(){
		// 拆分
		Splitter
				.on(",")
				.trimResults()
				.omitEmptyStrings()
				.split("foo,bar,,   qux")
				.forEach(System.out::println);

		// 连接
		Joiner joiner = Joiner.on("; ").skipNulls();
		System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
	}

	@Test
	public void test3(){
		// Lists是Guava中的一个工具类
		List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
		long count = nums.stream().filter(num -> num != null).count();
		System.out.println(count);
	}
}