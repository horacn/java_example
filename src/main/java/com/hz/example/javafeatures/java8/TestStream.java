package com.hz.example.javafeatures.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Java 8 新特性
 *
 * java.util.Stream 表示能应用在一组元素上一次执行的操作序列。
 * Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。
 * Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，List或者Set， Map不支持。Stream的操作可以串行执行或者并行执行。
 *
 * @author hezhao
 * @Time   2016年3月3日 下午3:04:06
 * @Description 无
 * @version V 1.0
 */
public class TestStream {
	String[] strs = {"张三","李四","王五","赵六","王二小","张四","王子","刘三","马王爷","萌萌","好好先生","Jack"};
	List<String> persons = Arrays.asList(strs);

	//Filter 过滤
	@Test
	public void test1(){

		//Java 8扩展了集合类，可以通过 Collection.stream() 或者 Collection.parallelStream() 来创建一个Stream

		//Filter 过滤
		//过滤通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作，所以我们可以在过滤后的结果来应用其他Stream操作
		//（比如forEach）。forEach需要一个函数来对过滤后的元素依次执行。forEach是一个最终操作，所以我们不能在forEach之后来执行 其他Stream操作
		persons
				.stream()
				.filter(p -> p.startsWith("王"))
				.forEach(System.out::println);
		//转换Stream，每次转换原有Stream对象不改变，返回一个新的Stream对象
	}

	//Sort 排序
	@Test
	public void test2(){
		//排序是一个中间操作，返回的是排序好后的Stream。如果你不指定一个自定义的Comparator则会使用默认排序。
		persons
				.stream()
				.sorted()
				.filter((p) -> p.startsWith("王"))
				.forEach(System.out::println);

		System.out.println("==========");

		persons
				.stream()
				.sorted((a,b) -> {
					if(a.length()>b.length()){
						return 1;
					}else{
						return -1;
					}
				})
				.filter((p) -> p.startsWith("王"))
				.forEach(System.out::println);

		//需要注意的是，排序只创建了一个排列好后的Stream，而不会影响原有的数据源，排序之后原数据persons是不会被修改的
		System.out.println(persons);
	}

	//Map 映射
	@Test
	public void test3(){
		//中间操作map会将元素根据指定的Function接口来依次将元素转成另外的对象，下面的示例展示了将字符串转换为大写字符串。
		//你也可以通过map来讲对象转换成其他类型，map返回的Stream类型是根据你map传递进去的函数的返回值决定的

		persons
				.stream()
				.map(p -> p.substring(0,1)+"_"+p.substring(1))
				.sorted((a,b) -> b.compareTo(a))
				.forEach(System.out::println);
	}

	//Map 匹配
	@Test
	public void test4(){
		//Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。所有的匹配操作都是最终操作，并返回一个boolean类型的值。

		//只要匹配一个就为true
		boolean anyMatch = persons
				.stream()
				.anyMatch(p -> p.startsWith("王"));

		//全部匹配
		boolean allMatch = persons
				.stream()
				.allMatch(p -> p.startsWith("王"));

		//都不匹配
		boolean noneMatch = persons
				.stream()
				.noneMatch(p -> p.startsWith("王"));

		System.out.println(anyMatch);
		System.out.println(allMatch);
		System.out.println(noneMatch);
	}

	//Count 计数
	@Test
	public void test5(){
		//计数是一个最终操作，返回Stream中元素的个数，返回值类型是long。
		long count = persons
				.stream()
				.filter(s -> s.length()>2)
				.count();
		System.out.println("长度大于2的姓名有: "+count);
	}

	//Reduce 规约
	@Test
	public void test6(){
		//这是一个最终操作，允许通过指定的函数来将stream中的多个元素规约为一个元素，规约后的结果是通过Optional接口表示的
		Optional<String> reduced =
				persons
						.stream()
						.sorted()
						.reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);
	}

	//并行Streams
	@Test
	public void test7(){
		/*前面提到过Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。
		下面的例子展示了是如何通过并行Stream来提升性能：
		首先我们创建一个没有重复元素的大表*/

		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}

		//然后我们计算一下排序这个Stream要耗时多久，
		//串行排序：
		/*long t0 = System.nanoTime();
		long count = values.stream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));*/
		// 串行耗时: 1250 ms

		//并行排序：
		long t0 = System.nanoTime();
		long count = values.parallelStream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms", millis));
		// 并行排序耗时: 800 ms
		//上面两个代码几乎是一样的，但是并行版的快了40%之多，唯一需要做的改动就是将stream()改为parallelStream()。
	}

	//其他
	@Test
	public void test8(){
		//使用Stream静态方法来创建Stream

		//1、of方法：有两个overload方法，一个接受变长参数，一个接口单一值
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
		Stream<String> stringStream = Stream.of("taobao");

		//2、generator方法：生成一个无限长度的Stream，其元素的生成是通过给定的Supplier（这个接口可以看成一个对象的工厂，每次调用返回一个给定类型的对象）
		//三条语句的作用都是一样的，只是使用了lambda表达式和方法引用的语法来简化代码。每条语句其实都是生成一个无限长度的Stream，其中值是随机的。
		//这个无限长度Stream是懒加载，一般这种无限长度的Stream都会配合Stream的limit()方法来用
		Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});
		Stream.generate(() -> Math.random());
		Stream.generate(Math::random);

		//3、iterate方法：也是生成无限长度的Stream，和generator不同的是，其元素的生成是重复对给定的种子值(seed)调用用户指定函数来生成的。
		//其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环
		//这段代码就是先获取一个无限长度的正整数集合的Stream，然后取出前10个打印。千万记住使用limit方法，不然会无限打印下去。
		Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);


		//去重复
		integerStream.distinct();

		//对一个Stream进行截断操作，获取其前N个元素，如果原Stream中包含的元素个数小于N，那就获取其所有的元素
		integerStream.limit(3);
		//返回一个丢弃原Stream的前N个元素后剩下元素组成的新Stream，如果原Stream中包含的元素个数小于N，那么返回空Stream
		integerStream.skip(1);

		//生成一个包含原Stream的所有元素的新Stream，同时会提供一个消费函数（Consumer实例），新Stream每个元素被消费的时候都会执行给定的消费函数
		integerStream.peek(System.out::println);

		//map()方法的变种
		integerStream.mapToDouble(s -> s*1.0);

		integerStream.mapToInt(s -> s.intValue());

		integerStream.mapToLong(s -> s*1l);

	}

	@Test
	public void test_flatMap(){
		List<String> wordList = Arrays.asList("abc","mdw","ket");
		Stream<String> words = wordList.stream();
		//再次注意下面两句
		Stream<Character> lowercaseWords = words.flatMap(TestStream::characterStream);
		lowercaseWords.forEach(System.out::println);
	}

	public static Stream<Character> characterStream(String s) {
		List<Character> result = new ArrayList<>();
		for(char c:s.toCharArray()) result.add(Character.valueOf(c));
		return result.stream();
	}

}
