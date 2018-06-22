package com.hz.example.thread.xc;

public class TestStore {
	public static void main(String[] args) {
		Store store = new Store();
		for (int i = 0; i < 15; i++) {
			Thread t1 = new Thread(() -> store.produce());
			t1.start();
		}

		for (int i = 0; i < 15; i++) {
			Thread t2 = new Thread(() -> store.consume());
			t2.start();
		}
	}
}
