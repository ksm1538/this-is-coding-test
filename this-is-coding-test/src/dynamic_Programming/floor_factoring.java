package dynamic_Programming;

import java.util.Scanner;

public class floor_factoring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// 입력받기 
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		arr[1] = 1;
		arr[2] = 3;
		
		// arr[i-1] 시, 2*1 공간이 남아있으므로 2*1 타일만 넣을 수 있음 
		// arr[i-2] 시, 2*2 공간이 남아있는데 2*2 타일 하나 or 1*2 타일 2개를 채워 넣는 방법이 존재한다. 
		// arr[i-2]에서 2*1 타일은 왜 포함시키지 않는가? 2*1타일을 넣는건 결국엔 arr[i-1]과 모양이 같아지기 때문에 배제한다.
		for(int i=3;i<=N;i++) {
			arr[i] = (arr[i-1] + (arr[i-2]*2))%796796;
			
		}
		
		System.out.println(arr[N]);
	}

}
