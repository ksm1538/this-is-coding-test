package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class two_Arrays_Change {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = br.readLine();
		StringTokenizer st = new StringTokenizer(temp);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arrA = new int[N];
		int[] arrB = new int[N];
		
		temp = br.readLine();
		st = new StringTokenizer(temp);
		
		for(int i=0; i<N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		temp = br.readLine();
		st = new StringTokenizer(temp);
		
		for(int i=0; i<N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		// arrA를 오름차순 정렬 
		Arrays.sort(arrA);
		
		// arrB를 오름차순 정렬 
		Arrays.sort(arrB);
		
		// swap count
		int count = 0;
		
		// arrA의 가장 작은 원소가 arrB의 가장 큰 원소보다 작다면 Swap
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=0; j--) {
				// swap count가 k일 떄 탈
				if(count == K) {
					break;
				}
				if(arrA[i] < arrB[j]) {
					int temporary = arrA[i];
					arrA[i] = arrB[j];
					arrB[j] = temporary;
					count++;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += arrA[i];
		}
		
		System.out.println(sum);
	}

}
