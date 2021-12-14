package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class cant_Make_Price_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int i=0;i<num;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int cnt = 1;
		
		for(; true; cnt++) {
			boolean flag = true;
			
			for(int i=0; i<arr.length; i++) {
				if(cnt == arr[i]) {
					flag = false;
					break;
				}
			}
			
			if(flag == true) {
				for(int i=0;i<arr.length;i++) {
					int temp =0;
					for(int j=i;j<arr.length;j++) {
						temp += arr[j];
						if(temp>cnt) {
							break;
						}
						if(temp == cnt) {
							flag = false;
							break;
						}
					}
					if(flag==false) {
						break;
					}
				}
			}
			if(flag==true) {
				break;
			}
		}
		
		System.out.println(cnt);
	}

}
