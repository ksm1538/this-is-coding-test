package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class find_part {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 가게의 부품 갯수 입력받기
		int N = Integer.parseInt(br.readLine());
		
		// 가게의부품 갯수만큼 배열 크기 할당
		int[] myPartArr = new int[N];
		
		// 가게의 부품 배열에 부품 번호들 기록
		String temp = br.readLine();
		StringTokenizer st = new StringTokenizer(temp);
		
		for(int i=0;i<N;i++) {
			myPartArr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 손님이 요청한 부품 입력 받기
		int M = Integer.parseInt(br.readLine());
		
		// 손님이 요청한 부품 갯수만큼 크기 할당
		int[] needPartArr = new int[M];
		
		// 손님이 요청한 부품 배열에 부품 번호들 기록
		temp = br.readLine();
		st = new StringTokenizer(temp);
		
		for(int i=0;i<M;i++) {
			needPartArr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		// 결과를 저장할 변수
		String[] result = new String[M];
		
		// 이진탐색을 이용하여 해결
		for(int i=0;i<M;i++) {
			int num = binary_search(myPartArr, 0, myPartArr.length-1, needPartArr[i]);
			
			if(num == -1) {
				result[i] = "no";
			}else {
				result[i] = "yes";
			}
		}
		
		for(int i=0;i<M;i++) {
			System.out.print(result[i]+" ");
		}
		
	}
	
	// 이진 탐색
	static int binary_search(int[] arr, int start, int end, int target) {
		if(start > end) {
			return -1;
		}
		
		int mid = (start+end) / 2;
		
		if(arr[mid] == target) {
			return mid;
		}
		else if(arr[mid] > target) {
			return binary_search(arr, start, mid-1, target);
		}
		else {
			return binary_search(arr, mid+1, end, target);
		}
	}

}
