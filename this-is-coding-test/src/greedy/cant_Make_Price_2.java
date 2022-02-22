package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class cant_Make_Price_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int i=0;i<num;i++) {
			arr[i] = sc.nextInt();
		}
		
		// 배열 정렬
		Arrays.sort(arr);
		
		int target = 1;
		for(int i=0; i<arr.length;i++) {
			if(arr[i]>target) {
				break;
			}
			target += arr[i];
		}
		
		System.out.println(target);
	}

}
