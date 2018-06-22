package com.hz.example.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestMaxNumber {
	/**
	 * 输出里面出现次数最多且数值最大的一个，出现几次
	 * @param args
	 */
	public static void main(String[] args) {
		int [] num = {1,3,4,7,2,1,1,5,2};
		
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < num.length; i++) {
			if(!map.containsKey(num[i])){
				map.put(num[i], 1);
			}else{
				Integer count = map.get(num[i]);
				map.put(num[i], count+1);
			}
		}
		
		Integer max= Integer.MIN_VALUE;
        Integer max2 = Integer.MIN_VALUE;
        for( Entry<Integer, Integer> entry : map.entrySet() ) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
             
            if(value>=max){
                 
                max=value;
                if(key>=max2){  
                    max2=key;
                }
            }
                 
        }
         
        for( Entry<Integer, Integer> entry : map.entrySet() ) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
             
            if(key==max2){
                System.out.println("频率最大数"+key+" 频率:"+max);
            }
                 
        }
	}
}
