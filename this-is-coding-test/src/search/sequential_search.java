package search;

import java.util.Scanner;

public class sequential_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("문자열 갯수와 찾을 문자열을 입력 : ");
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		
		// 문자열 갯수 
		int N = Integer.parseInt(temp.split(" ")[0]);
		
		// 찾을 문자열 
		String target = temp.split(" ")[1];
		
		String[] strArr = new String[N];
		
		temp=sc.nextLine();
		for(int i=0;i<strArr.length;i++) {
			strArr[i] = temp.split(" ")[i];
		}
		
		sequential_search(strArr, N, target);
		
	}
	
	static void sequential_search(String[] strArr, int N, String target) {
		int index = -1;
		
		// 반복문을 돌며 탐색 
		for(int i=0; i<N; i++) {
			// 타겟과 같은 걸 찾으면 탈출 
			if(strArr[i].equals(target)) {
				index = i;
				break;
			}
		}
		
		if(index == -1) {
			System.out.println("찾지 못함!");
		}else {
			System.out.println(target + " 의 index : " + index);
		}
	}

}
