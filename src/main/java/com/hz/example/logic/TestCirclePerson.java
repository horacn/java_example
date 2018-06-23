package com.hz.example.logic;

/**
 * 17个人围成圈，编号为1—17，从第1号开始报数，报到3的倍数的人离开，一直数下去，直到最后只剩下1人。求此人的编号。
 */
public class TestCirclePerson {
	public static void main(String[] args) {
		int [] persons = new int[17];
		for (int i = 0; i < persons.length; i++) {
			persons[i] = i;
		}
		
		int num = 0;
		int flag = 0;
		
		for (int i = 0; i < persons.length; i++) {
			if(persons[i] != -1){
				num++;
				if(num%3 == 0){
					System.out.println(persons[i]+"离开圈子，报数:"+num);
					persons[i] = -1;
					flag++;
				}
			}
			
			if(i == persons.length-1){
				i = -1;
			}
			
			if(flag == persons.length-1){
				int count = 0;
				int last = 0;
				for (int j = 0; j < persons.length; j++) {
					if(persons[j] != -1){
						count++;
						last = persons[j];
					}
				}
				if(count == 1){
					System.out.println();
					System.out.println("最后一人为："+last);
					break;
				}
			}
		}
	}
}
