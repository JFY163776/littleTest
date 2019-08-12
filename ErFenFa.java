package com.jfy.shuzu;
/**
 * 二分法进行快速查找 
 * @author HomieJ
 *
 */
public class ErFenFa {
public static void main(String[] args) {
	int a [] = {0,1,2,3,4,5,6,7,8,9};
	
	int value = 7;
	int myBinarySearch = myBinarySearch(a, value);
	System.out.println(myBinarySearch);

}
public static int myBinarySearch(int []arr , int value) {
	int low = 0;
	int high = arr.length-1;
	int mid = 0;
	while(low<=high) {
		mid = (low +high)/2;
		if (value == arr[mid]) {
			return mid;
		}
		if (value<arr[mid]) {
			high = mid-1;
		}
		if (value>arr[mid]) {
			low = mid+1;
		}
	}
	return -1;
}
}
