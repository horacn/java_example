package com.hz.example.langproblem;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Test;

import com.google.common.collect.Lists;

public class Test1 {
	@Test
	public void test1() {
		boolean odd = isOdd(-1);
		System.out.println(odd);
	}

	public static boolean isOdd(int i) {
		// return i % 2 == 1;
		// return i % 2 != 0;
		return (i & 1) != 0;
	}

	@Test
	public void test2() {
		System.out.println(2.00 - 1.10);

		BigDecimal decimal = new BigDecimal(".1");
		System.out.println(decimal);
	}

	@Test
	public void test3() {
		final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
		System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
	}

	@Test
	public void test4() {
		System.out.println(12345 + 5432l);
	}

	@Test
	public void test5() {
		System.out.println(Long.toHexString(0x100000000L + 0xcafebabeL));
	}

	@Test
	public void test6() {
		// System.out.println((int)(char)(byte) -1);
		String str = "△▽○◇□☆▷◁♤♡♢♧♣♦♥♠◀▶★■◆●▼▲☼☽☺♀◐☑√✔☜☝☞㏂㏘☛☟☚✘×☒◑☹♂☾☀▪∷※•‥░▒…▁▓▏▎▍▃▂▁▍▌▅▆▇█▉▊▋㏇©®™℡℗۞〓▬¤◎卐卍〼§¶‖♬♫♮♯♪♩♭㈱♈♉♐♓㉿§¤☯✈☎☏♘♙囧卐卍甴曱弐钅⺝￥¥";
		char[] charArray = str.toCharArray();
		for (char c : charArray) {
			System.out.println((int) c);
		}
		System.out.println((char) 21325);
	}

	@Test
	public void test7() {
		List<String> list = Lists.newArrayList("a1n", "b1x", "c1", "a2", "1ax", "a11n", "b9n", "c1", "a2", "1axn");

		Pattern pattern = Pattern.compile("^a");
		list.stream().filter(s -> !pattern.matcher(s).find() && s.length() >= 3).skip(2).limit(2)
				.forEach(System.out::println);
	}

	@Test
	public void test8() {
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("优", "良");
		System.out.println(person.firstName + " - " + person.lastName);
	}

	// 用来创建Person对象的对象工厂接口
	@FunctionalInterface // 函数式接口
	interface PersonFactory<P extends Person> {
		P create(String firstName, String lastName);
	}

	class Person {
		String firstName;
		String lastName;

		Person() {
		}

		Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
	}

	@Test
	public void test9() {
		// int x = 1984; // (0x7c0)
		// int y = 2001; // (0x7d1)
		// x^= y^= x^= y;
		// System.out.println("x= " + x + "; y= " + y);

		int i = 1;
		int j = 2;
		j = i++;
		System.out.println("i:" + i + "  j:" + j);
	}

	@Test
	public void test10() {
		char x = 'X';
		int i = 65;

		char si = (char) (false ? x : i);
		char sj = (char) (false ? i : x);

		System.out.println(si);
		System.out.println(sj);
	}

	@Test
	public void test11() {
		int i = 10;
		/*
		 * i = i>>1; System.out.println(i);
		 * 
		 * i=2; System.out.println((++i)+(++i)+(++i));
		 * 
		 * i = i&2;
		 */

		i = ~i;
		System.out.println(i);

		Long s = 1000000000000000000L;
		int j = 21518512;
		s += j;
		System.out.println(s);
	}

	@Test
	public void test12() {
		System.out.print("H" + "a");
		System.out.println('H' + 'a');

		String str = 1 + 2 + "" + false + 2 + 2;

		str += 'H';
		str += 'a';

		System.out.println(str);

		String str2 = "2 + 2 = " + 2 + 2;
		System.out.println(str2);

		System.out.printf("%c%c", 'H', 'a');
	}

	@Test
	public void test13() {
		String letters = "ABC";
		char[] numbers = { '1', '2', '3' };
		System.out.println(letters + " easy as " + numbers);
	}

	@Test
	public void test14() {
		final String pig = "length: 10";
		final String dog = "length: " + pig.length();
		System.out.println("Animals are equal: " + pig == dog);
	}

	@Test
	public void test15() {
		// \u0022 是双引号的 Unicode 转义字符
		System.out.println("a\u0022.length() + \u0022b".length());
	}

	@Test
	public void test16() {
		System.out.print("iexplore:");
		http: // www.google.com;
		System.out.println(":maximize");
	}

	@Test
	public void test17() {
		final int START = 2000000000;
		int count = 0;
		for (float f = START; f < START + 50; f++)
			count++;
		System.out.println(count);
	}

	@Test
	public void test18() {
		int minutes = 0;
		for (int ms = 0; ms < 60 * 60 * 1000; ms++)
			if (ms % 60 * 1000 == 0)
				minutes++;
		System.out.println(minutes);
	}

	@Test
	public void test19() {
		System.out.println(test_return());
	}

	public boolean test_return() {
		System.out.println("方法开始");
		try {
			System.out.println("try");
			// return true;
		} catch (Exception ex) {
			return false;
		} finally {
			System.out.println("finally");
			// return false;
		}
		// System.out.println("方法结束");
		return false;
	}
	
	@Test
	public void test20() {
		try {
			System.out.println("Hello world");
			System.exit(0);
		} finally {
			System.out.println("Goodbye world");
		}
	}
}
