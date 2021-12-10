package greedy;

import java.util.Scanner;

public class make_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int count = 0;
		
		while(true) {
			count++;
			if(N % K == 0) {
				N /= K;
			}else {
				N--;
			}
			
			if(N == 1) {
				break;
			}
		}
		
		System.out.println(count);
	}

}
