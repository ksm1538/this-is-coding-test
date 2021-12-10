package greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class number_card_game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		StringTokenizer st1 = new StringTokenizer(str1);
		
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		
		int[] arr = new int[m];
		
		int big = 0;
		
		for (int i = 0; i<n; i++) {
			String str2 = sc.nextLine();
			
			StringTokenizer st2 = new StringTokenizer(str2);
			for(int j=0;j<m;j++){
				arr[j] = Integer.parseInt(st2.nextToken());
			}
			
			Arrays.sort(arr);
			
			if(arr[0]>=big) {
				big=arr[0];
			}
		}
		
		System.out.println(big);
		
	}

}
