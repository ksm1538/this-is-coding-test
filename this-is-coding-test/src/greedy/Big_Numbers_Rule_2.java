package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Big_Numbers_Rule_2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a= br.readLine();
		String b= br.readLine();
		
		StringTokenizer st = new StringTokenizer(a);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(b);
		int[] arr = new int[N];
		
		for(int i =0; i<N ; i++) {
			int num = Integer.parseInt(st2.nextToken());
			
			arr[i]=num;
		}
		// 반복되는 묶음 : (M / (K+1))
		// 가장 큰 수가 나오는 횟수 : 반복되는 묶음 * K + 나머지
		// 마지막에 묶음이 아닌 나머지들 : (M % K+1)
		// 두번 째로 큰 수가 나오는 횟수 : M - 가장 큰 수가 나오는 횟수
		
		Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int big1 = arr[N - 1]; // 가장 큰 수
        int big2 = arr[N - 2]; // 두 번째로 큰 수
        
		int count = (M / (K+1)) * K;
		count += (M % (K+1));
		
		int result = 0;
		result = big1 * count;
		result += big2 * (M-count);
		
		System.out.println(result);
		
	}

}
