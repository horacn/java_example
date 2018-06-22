package com.hz.example.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import com.google.gson.Gson;

import com.hz.example.interf.man.Wife;
import com.hz.example.util.HttpClientUtils;

public class Test5 {

	ArrayBlockingQueue<String> sendQueue = new ArrayBlockingQueue<String>(5,true);
	
	{
		sendQueue.offer("a");
		sendQueue.offer("b");
		sendQueue.offer("c");
		sendQueue.offer("d");
		sendQueue.offer("e");
		sendQueue.offer("f");
		sendQueue.offer("g");
		sendQueue.offer("h");
		sendQueue.offer("i");
		sendQueue.offer("j");
		sendQueue.offer("k");
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ArrayBlockingQueue<String> sendQueue2 = new Test5().sendQueue;
		System.out.println(new Gson().toJson(sendQueue2));
		while(true){
			System.out.println(sendQueue2.take());
			
		}
	}
	
}


class Main {
    public void test(Object o) {
        System.out.println("Object");
    }
    public void test(String s) {
        System.out.println("String");
    }
    public static void main(String[] args) {
        Main that = new Main();
        that.test(null);//String
        
        String a = "abc";
        String b = "ab" + "c";
        System.out.println(a == b);//true
    }
}

/*作者：Aldhen
链接：https://www.zhihu.com/question/50111592/answer/120033117
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

class Main2 {
	    public void test(Object o) {
	        System.out.println("Object");
	    }   
	    public void test(Integer s) {
	        System.out.println("Integer");
	    }
	    public void test(float f) {
	        System.out.println("float");
	    }
	    public void test(double d) {
	        System.out.println("double");
	    }
	    public void test(long l) {
	        System.out.println("long");
	    }
	    public void test(char c) {
	        System.out.println("char");
	    }
        public static void main(String[] args) {
	        Main2 that = new Main2();
	        that.test(0);
	        that.test(0.0);
	        that.test(null);         
	   }
}


class testHttp{
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("key", "beb2a6cee1c049e5981a2bb3bfba1e98");
		map.put("info", "灵域");
		
		System.out.println(HttpClientUtils.request(map,"http://www.tuling123.com/openapi/api"));
		
	}
}


class MyGenericClass<T,V>{

    T obj1=null;

    V obj2=null;
    
    //java“擦除”原理
    //Java的泛型是伪泛型。为什么说Java的泛型是伪泛型呢？因为，在编译期间，所有的泛型信息都会被擦除掉。
//    void setValue(T obj){
//    	
//    }

    void setValue(V obj){
    	this.obj2 = obj;
    }
    
    
}

class tsf{
	public static void main(String[] args) {
		Wife s  = new Wife();
		s.setName("小鱼");
		
		System.out.println(s.toString());
		
	}
	
}