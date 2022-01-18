package search;

import java.util.Arrays;
import java.util.Scanner;

public class binary_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		
		// 문자열 갯수 
		int N = Integer.parseInt(temp.split(" ")[0]);
		
		// 찾을 숫자
		int target = Integer.parseInt(temp.split(" ")[1]);
		
		int[] intArr = new int[N];
		
		temp=sc.nextLine();
		for(int i=0;i<intArr.length;i++) {
			intArr[i] = Integer.parseInt(temp.split(" ")[i]);
		}
		
		// 정렬 
		Arrays.sort(intArr);
		
		int result = binary_search(intArr, 0, N-1, target);
		
		if(result == -1) {
			System.out.println("찾지 못함!");
		}else {
			System.out.println(target +" 의 index : " + result);
		}
	}

	static int binary_search(int[] arr, int start, int end, int target) {
		// 범위를 벗어난 경우 찾지못한걸로 간주하고 종
		if(start>end) {
			return -1;
		}
		
		// 몫만 추출 
		int mid = (start+end) / 2;
		
		// 중간점 위치의 데이터와 타겟이 같으면 중간점 반환 
		if(arr[mid] == target) {
			return mid;
		}
		// 중간점 위치의 데이터보다 타겟이 작으면 중간점 기준 왼쪽 탐색 
		else if(arr[mid] > target) {
			return binary_search(arr, start, mid-1, target);
		}
		// 중간점 위치의 데이터보다 타겟이 크면 중간점 기준 오른쪽 탐색 
		else {
			return binary_search(arr, mid+1, end, target);
		}
	}
}
