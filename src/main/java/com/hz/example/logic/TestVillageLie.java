package com.hz.example.logic;

import com.hz.example.interf.man.Man;
import com.hz.example.interf.man.Person;
import com.hz.example.interf.man.SmallMan;

/**
 * 某地有两个奇怪的村庄，张庄的人在星期一、三、五说谎，李村的人在星期二、四、六说谎。
 * 在其他日子他们说实话,一天,外地的王从明来到这里,见到两个人,分别向他们提出关于日期的题,两个人都说”前天是我说谎的日子”
 * 如果被问的两个人分别来自张庄和李村,那么这一天是星期几？
 * 
 * @author Zhao.He
 */
public class TestVillageLie {
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
