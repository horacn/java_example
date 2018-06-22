package com.hz.example.logic;

public class TestArraySort {
	public int[] getArraySort(int[] m,int[] n){
		int im = 0;  //数组m的起始位置,用于数组m下标计数
		int jn = 0;
		int[] mn = new int[m.length + n.length];   //排序后新数组大小

		while(im < m.length && jn <n.length){
			if(m[im]<=n[jn]){
				mn[im + jn] = m[im];
				im++;
			}else{
				mn[im + jn] = n[jn];
				jn++;
			}
		}
		//其中一个数组最后的元素值小于第二个数组的某个元素值，遍历第二个数组剩余元素值加入新数组
		while(im < m.length){
			mn[im + jn] = m[im];
			im++;
		}
		while(jn < n.length){
			mn[im + jn] = n[jn];
			jn++;
		}
		return mn;
	}

	public static void main(String[] args) {
		int[] m = {1,3,5,7,9,11,12,13};
		int[] n = {2,3,6,8,10};
		TestArraySort oas = new TestArraySort();
		int[] mn = oas.getArraySort(m, n);
		for(int i=0;i<mn.length;i++){
			System.out.print(mn[i]+" ");
		}
	}
}