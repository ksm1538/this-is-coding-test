package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class make_Tteokbokki_Ttoek {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N,M;
		int[] arr;
		
		String temp = br.readLine();
		StringTokenizer st = new StringTokenizer(temp);
		
		// 떡의 개수
		N = Integer.parseInt(st.nextToken());
		
		// 손님이 요청한 길이
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		temp = br.readLine();
		st = new StringTokenizer(temp);
		
		// 떡의 가장 큰 길이
		int max = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		// 절단기의 최대 높이 = 떡의 최대 길이
		// 이진탐색을 통해 적절한 절단기의 높이를 찾는다.
		int result = binary_search(arr, 0, max, M );
		
		System.out.print(result);
	}
	
	static int binary_search(int[] arr, int start, int end, int target) {
		if(start>end) {
			return -1;
		}
		
		int mid = (start+end) / 2;
		int sum = 0;
		
		for(int i=0; i<arr.length;i++) {
			if(arr[i]>mid) {
				sum+= (arr[i]-mid);
			}
		}
		
		if(sum==target) {
			return mid;
		}
		else if(sum>target) {
			return binary_search(arr, mid+1, end, target);
		}
		else {
			return binary_search(arr, start, mid-1, target);
			
		}
	}

}
