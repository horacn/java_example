package com.hz.example.thread.xc;

public class TestWorking {
	public static void main(String[] args) {
		Working t1 = new Working();
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(t1);
			t.start();
		}
	}
}
