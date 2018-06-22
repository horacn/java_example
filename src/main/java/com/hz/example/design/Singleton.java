package com.hz.example.design;

import java.util.HashMap;
import java.util.Map;

/** 单例类的几种实现方式 */

// 1、 懒汉式单例类,在第一次调用的时候实例化自己
public class Singleton {
    private Singleton(){}
    private static Singleton singleton = null;
    //静态工厂方法
    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    //以下三种方式，都是对getInstance这个方法改造，保证了懒汉式单例的线程安全

    //1、在getInstance方法上加同步
	/*public static synchronized  Singleton getInstance(){
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}*/

    //2、双重检查锁定
	/*public static Singleton getInstance(){
		synchronized (Singleton.class) {
            if (singleton == null) {
               singleton = new Singleton();
            }
         }
		return singleton;
	}*/
}



// 2、静态内部类
class Singleton2 {
    private static class LazyHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }
    private Singleton2 (){}
    public static final Singleton2 getInstance() {
        return LazyHolder.INSTANCE;
    }
}



// 3、饿汉式单例类.在类初始化时，已经自行实例化
class Singleton3 {
    private Singleton3() {}
    private static final Singleton3 single = new Singleton3();
    // 静态工厂方法
    public static Singleton3 getInstance() {
        return single;
    }
}



// 4、登记式单例。类似Spring里面的方法，将类名注册，下次从里面直接获取。
class Singleton4 {
    private static Map<String,Singleton4> map = new HashMap<String,Singleton4>();
    static{
        Singleton4 single = new Singleton4();
        map.put(single.getClass().getName(), single);
    }
    // 保护的默认构造子
    protected Singleton4(){}
    // 静态工厂方法,返还此类惟一的实例
    public static Singleton4 getInstance(String name) {
        if(name == null) {
            name = Singleton4.class.getName();
            System.out.println("name == null"+"--->name="+name);
        }
        if(map.get(name) == null) {
            try {
                map.put(name, (Singleton4) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
    // 一个示意性的商业方法
    public String about() {
        return "Hello, I am RegSingleton.";
    }

    public static void main(String[] args) {
        Singleton4 single4 = Singleton4.getInstance(null);
        System.out.println(single4.about());
    }
}