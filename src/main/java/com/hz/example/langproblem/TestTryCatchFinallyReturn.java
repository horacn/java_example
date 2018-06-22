package com.hz.example.langproblem;

import java.util.HashMap;
import java.util.Map;

/**
 * finally是在return后面的表达式运算后执行的（此时并没有返回运算后的值，而是先把要返回的值保存起来，管finally中的代码怎么样，返回的值都不会改变，任然是之前保存的值），
 * 所以函数返回值是在finally执行前确定的
 *
 * @author hezhao
 * @Time   2016年3月1日 下午1:45:16
 * @Description 无
 * @version V 1.0
 */
public class TestTryCatchFinallyReturn {
	public static void main(String[] args) {
//		System.out.println("main: "+getNums(1));
//		System.out.println("main: "+getNums(2));
//		System.out.println("main: "+getStrs("111"));
//		System.out.println("main: "+getStrs("1111"));

//		Map map = new HashMap();
//		map.put("str", "1111");
//		System.out.println(getMaps(map).get("str"));
//		System.out.println("main: "+map.get("str"));
//		System.out.println(getMaps(map) == map);

		int[] arrs = {1,2};

		System.out.println(getArrays(arrs)[0]);
		System.out.println(arrs[0]);
		System.out.println(getArrays(arrs) == arrs);

	}

	private static int getNums(int n) {
		try{
			if(n % 2 == 0){
				n += 1;
				throw new Exception();
			}
			n += 2;
			return n;
		}catch(Exception ex){
			System.out.println("catch: "+n);
//			return n;
		}finally{
			n += 4;
			System.out.println("finally: "+n);
//			return n;
		}
		n+=5;
		return n;
	}

	private static String getStrs(String str) {
		try{
			if(str.length() % 2 == 0){
				str+="a";
				throw new Exception();
			}
			str += "b";
			return str;
		}catch(Exception ex){
			System.out.println("catch: "+str);
//			return n;
		}finally{
			str += "c";
			System.out.println("finally: "+str);
//			return n;
		}
		str+="d";
		return str;
	}

	private static Map getMaps(Map map) {
		try{
			if(map.get("str").toString().length()%2==0){
				map.put("str",map.get("str")+"a");
				throw new Exception();
			}
			map.put("str",map.get("str")+"b");
			return map;
		}catch(Exception ex){
			System.out.println("catch: "+map.get("str"));
//			return n;
		}finally{
			map.put("str",map.get("str")+"c");
			System.out.println("finally: "+map.get("str"));
//			return n;
		}
		map.put("str",map.get("str")+"d");
		return map;
	}

	private static int[] getArrays(int[] arrs) {
		arrs[0] = 999;
		return arrs;
	}

}
