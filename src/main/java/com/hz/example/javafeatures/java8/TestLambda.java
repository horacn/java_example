package com.hz.example.javafeatures.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * Java8 lambda表达式
 *
 * @author hezhao
 * @Time 2016年3月3日 上午10:42:21
 * @Description 无
 * @version V 1.0
 */
public class TestLambda {

	//传统方式
	@Test
	public void test1() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		Collections.reverse(names);

		names.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
	}

	@Test
	public void test2() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		//使用lambda表达式
//		Collections.sort(names, (String a, String b) -> {
//		    return b.compareTo(a);
//		});

		//对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字
		//Collections.sort(names, (String a, String b) -> b.compareTo(a));

		//Java编译器可以自动推导出参数类型
		Collections.sort(names, (a, b) -> b.compareTo(a));

		Collections.reverse(names);

		//只有一个参数的，可以省略小括号
		names.forEach(a->System.out.println(a));
	}

	@Test
	public void test3() {
		//没有参数时需要用一对小括号
		Runnable r = () -> System.out.println("111");
		r.run();

		Object obj = (Runnable)() -> {System.out.println("111");};
		System.out.println(obj);

		Consumer<Integer> con = n -> System.out.println(Math.pow(n, 2));
		con.accept(3);
	}

	/**
	 * 函数式接口 - 指仅仅只包含一个抽象方法的 接口
	 * @author hezhao
	 * @Time   2016年3月3日 上午11:34:04
	 * @Description 无
	 * @version V 1.0
	 * @param <F>
	 * @param <T>
	 */
	@FunctionalInterface
	interface Converter<F,T>{
		T convert(F from);
	}

	@Test
	public void test4() {
		Converter<String, Integer> converter = form -> Integer.valueOf(form);
		Integer convered = converter.convert("123");
		System.out.println(convered);
	}

	//方法与构造函数引用
	@Test
	public void test5() {
		//Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用
		Converter<String, Integer> converter = Integer :: valueOf;
		Integer convered = converter.convert("123");
		System.out.println(convered);

		//也可以引用一个对象的方法
		MyString something = new MyString();
		Converter<String, String> converter2 = something :: startsWith;
		String converted2 = converter2.convert("Java");
		System.out.println(converted2);    // "J"

		//只需要使用 Person::new 来获取Person类构造函数的引用，Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数
		PersonFactory<Person> personFactory = Person :: new;
		Person person = personFactory.create("Peter", "Parker");
		System.out.println(person.firstName + " - "+person.lastName);
	}

	class MyString{
		String startsWith(String str){
			return str.substring(0,1);
		}
	}

	class Person {
		String firstName;
		String lastName;
		Person() {}

		Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
	}

	//用来创建Person对象的对象工厂接口
	interface PersonFactory<P extends Person> {
		P create(String firstName, String lastName);
	}

	static String msg = "Hello";
	int i = 1;
	final boolean flag = false;

	//Lambda作用域
	@Test
	public void test6() {
		int j = 2;
		final long l = 100l;

		//可以直接访问标记了final?的外层局部变量，或者实例的字段以及静态变量
		//即使外层局部变量没有显示使用final修饰，但是编译器隐式当成final来处理
		Runnable r = () -> {
			//成员变量、静态变量可修改
			msg = "world";
			i = 666;
			//在lambda表达式中试图修改局部变量同样是不允许的
			//（只是引用不可变，而不是真正的不可变）
			//j = 4;
			System.out.println(msg);
			System.out.println(i);
			System.out.println(flag);
			System.out.println(j);
			System.out.println(l);
		};
		//使用到的局部变量必须不可被后面的代码修改（即隐性的具有final的语义），例如下面的就无法编译
		//j = 3;
		//成员变量、静态变量可修改
		msg = "Me";
		i = 0;
		r.run();
	}

	@Test
	public void test7() {
		//Lambda表达式中是无法访问到默认方法的，以下代码将无法编译
//		Formula formula = num -> sqrt(100*num);
//		System.out.println(formula.calculate(100));

		//Predicate 接口只有一个参数，返回boolean类型。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）
		Predicate<String> predicate = str -> str.length()>0;
		System.out.println(predicate.test("abc"));
		//非
		System.out.println(predicate.negate().test("abc"));
		//与
		boolean result = predicate.and(str -> str.equals("abc")).test("abc");
		System.out.println(result);
		//或
		boolean result2 = predicate.or(str -> str.equals("123")).test("abc");
		System.out.println(result2);

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();


		//Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		String apply = backToString.apply("123");
		System.out.println(apply);


		//Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
		Supplier<Person> personSupplier = Person::new;
		Person person = personSupplier.get();   // new Person


		//Consumer 接口表示执行在单个参数上的操作
		Consumer<Person> greeter = p -> System.out.println("Hello, " + p.firstName);
		greeter.accept(new Person("Luke", "Skywalker"));


		//Comparator 是老Java中的经典接口,常用于数组、集合排序， Java 8在此之上添加了多种默认方法
		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		comparator.compare(p1, p2);             // > 0
		comparator.reversed().compare(p1, p2);  // < 0、

		List<Person> persons = new ArrayList<>();
		persons.add(p1);
		persons.add(p2);
		Collections.sort(persons, comparator);
		persons.forEach(p -> System.out.println(p.firstName));


		//Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型，这是下一届中将要用到的重要概念，现在先简单的看看这个接口能干什么：
		//Optional 被定义为一个简单的容器，其值可能是null或者不是null。
		//在Java 8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，而在Java 8中，不推荐你返回null而是返回Optional
		Optional<String> optional = Optional.of("bam");
		optional.isPresent();           // true
		optional.get();                 // "bam"
		optional.orElse("fallback");    // "bam"

		optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
	}
}
