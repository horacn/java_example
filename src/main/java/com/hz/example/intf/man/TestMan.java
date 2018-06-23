package com.hz.example.intf.man;

public class TestMan {
	public static void main(String[] args) {
		
		Person p = new SmallMan();
		p.show();
		p.show2();
		
		Man m = (Man) p;
		
		m.show();
		m.show2();
		
		SmallMan sm = (SmallMan) m;
		
		sm.show();
		sm.show2();
		
	}
}
