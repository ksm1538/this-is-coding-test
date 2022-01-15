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
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=0; j--) {
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
