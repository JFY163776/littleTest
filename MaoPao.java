package com.jfy.shuzu;

import java.util.Arrays;

/**
 * ð������
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
			c= false;   		//�Ż�  �жϸô�ѭ���Ƿ���н������û�н�����ֹͣ ����ѭ��

		}
		System.out.println(Arrays.toString(a));
	}
	System.out.println("###########");
	if (c) {
		System.out.println("����");
		break;

	}
	}
}
}
