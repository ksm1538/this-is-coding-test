package greedy;

import java.util.Scanner;

public class multiply_or_Plus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String[] arr = str.split("");
		
		// 곱셈 or 덧셈
		// 0 or 1가 들어간 연산에서는 더하기가 곱셈보다 좋음
		// 그러므로 두 숫자중 1 이하가 있는 경우 더하기로 연산하고 
		// 두 숫자가 모두 2 이상인 경우 곱셈으로 연산한다.
		int result = Integer.parseInt(arr[0]);
		
		for(int i=1;i<arr.length;i++) {
			int num = Integer.parseInt(arr[i]);
			
			if(num >= 2 && result >= 2) {
				result *= num;
			}else {
				result += num;
			}
		}
		
		System.out.println(result);
	}

}
