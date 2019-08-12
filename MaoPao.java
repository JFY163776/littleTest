package com.jfy.shuzu;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author HomieJ
 *
 */
public class MaoPao {
public static void main(String[] args) {
	int [] a = {888,377,8,45,100,53,26,2};
	int b;
	boolean c ;
	for (int i = 0; i < a.length-1; i++) {
		c=true;
	for (int j = 0; j < a.length-1-i; j++) {
		
		if (a[j]<a[j+1]) {
			b = a[j];
			a[j] = a[j+1];
			a[j+1] = b;
			c= false;   		//优化  判断该次循环是否进行交换如果没有交换则停止 跳出循环

		}
		System.out.println(Arrays.toString(a));
	}
	System.out.println("###########");
	if (c) {
		System.out.println("结束");
		break;

	}
	}
}
}
