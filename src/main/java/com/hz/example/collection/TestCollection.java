package com.hz.example.collection;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * Created by hezhao on 2018-06-22 17:49
 */
public class TestCollection {
    public static void main(String[] args) throws InterruptedException {

		Vector vector = new Vector();
		vector.add(1);
		vector.add(1);
		vector.add(1);
		vector.add(1);

        System.out.println("====================Vector========================");
		for (Object object : vector) {
			System.out.println(object);
		}

		Hashtable h = new Hashtable();
		h.put(1, 2);
		h.put(11, 2);
		h.put(12, 2);
		h.put(13, 2);
		h.put(14, 2);

        System.out.println("====================Hashtable========================");
		for (Object string : h.keySet()) {
			System.out.println(h.get(string));
		}

		LinkedList l = new LinkedList<>();
		l.offer(1);
		l.offer(1);
		l.offer(1);
		l.offer(1);
		l.offer(1);
		l.offer(1);

        System.out.println("======================LinkedList======================");
		for (Object object : l) {
			System.out.println(object);
		}

		BlockingQueue q = new ArrayBlockingQueue(10);
		q.put(1);
		q.add(2);
		q.offer(3);

        System.out.println("====================BlockingQueue========================");
		for (Object object : q) {
			System.out.println(object);
		}

        System.out.println("=======================BlockingQueue take=====================");
		Object take = q.take();
		q.take();
		Object poll = q.poll();
		System.out.println(take);
		System.out.println(poll);

        Stack stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        System.out.println("======================Stack======================");
        System.out.println(stack.pop());
    }
}
