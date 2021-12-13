package greedy;

import java.util.Scanner;

public class bowling_balls_select_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int maxW = sc.nextInt();
		int[] arr = new int[num];
		int count = 0;
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<num;i++) {
			for(int j=i+1;j<num;j++) {
				int a = arr[i];
				int b = arr[j];
				
				if(a != b) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
