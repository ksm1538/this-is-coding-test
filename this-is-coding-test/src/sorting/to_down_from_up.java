package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class to_down_from_up {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		
		for(int i=0;i<num;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//quick_sort(arr, 0, arr.length-1);
		
		//퀵 정렬 대신 java 정렬 라이브러리 이용
		Arrays.sort(arr);
		for(int i=0;i<num;i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	static void quick_sort(int[] arr, int start, int end) {
		if(start >= end) {
			return;
		}
		
		int pivot = start;
		int left = start +1;
		int right = end;
		
		while(left<=right) {
			while(arr[left]<=arr[pivot] && left<=end ) 
				left++;
			
			while(arr[right]>arr[pivot] && right>start) 
				right--;
			
			if(left>right) {
				int temp = arr[right];
				arr[right] = arr[pivot];
				arr[pivot] = temp;
			}
			else {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
			}
		}
		
		quick_sort(arr,start,right-1);
		quick_sort(arr,right+1,end);
	}

}
