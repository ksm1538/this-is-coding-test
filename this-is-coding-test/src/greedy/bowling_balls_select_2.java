package greedy;

import java.util.Scanner;

public class bowling_balls_select_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int maxW = sc.nextInt();
		
		// 지문에 볼링공 무게는 1~10까지만 존재한다고함.
		// 필자는 볼링공의 최대 무게를 10 넘어서도 생각함.
		int[] weightArr = new int[maxW];
		int[] arr = new int[num];
		
		int result = 0;
		for(int i=0;i<num;i++) {
			arr[i]=sc.nextInt();
		}
		
		// 1짜리 공의 수를 첫번째배열에 넣고
		// 2짜리 공의 수를 두번째배열에 넣는 방식 이용
		// 반복이 끝나면 아래의 배열은 볼링공의 무게별 갯수
		for(int i=0;i<arr.length;i++) {
			weightArr[arr[i]-1]++;
		}
		
		// 볼링공 총 갯수에서 현재 무게 볼링공의 갯수를 빼는 이유
		// 같은 무게끼리는 조합하면 안되기 때문에 무게 볼링공의 갯수에서 같은 무게의 볼링공 수만큼 빼주고 곱한다.
		
		// num변수 즉, 총 볼링공 갯수에다가 계속 빼는 이유
		// num 변수를 다시 원래 갯수로 하고 특정 무게의 볼링공 갯수를 빼면 계산했던 경우가 포함됨.
		// 포함하지 않도록 원래 갯수로 초기화하지 않고 num 변수를 계속 빼는 것
		for(int i=0;i<maxW;i++) {
			num -= weightArr[i];
			result += (weightArr[i]*num);
		}
		
		System.out.print(result);
	}

}
