package dynamic_Programming;

import java.util.Scanner;

public class make_1 {

	 // 30000까지 포함이므로 30000+1하여 선언
    public static int[] d = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        sc.close();
        
        // 다이나믹 프로그래밍 (Bottom-up 방식)
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
        	// 우선 1을 빼준 경우의 횟수를 넣어준다 (1을 빼기 때문에 이전 숫자의 +1을 넣어준다)
            d[i] = d[i - 1] + 1;
            
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
            	// 1을 빼준 경우의 횟수와 2로 나눈 경우의 횟수를 비교하여 작은 쪽을 선택한다. 
            	d[i] = Math.min(d[i], d[i / 2] + 1);
            }
               
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
            	d[i] = Math.min(d[i], d[i / 3] + 1);
            }
                
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0) {
            	d[i] = Math.min(d[i], d[i / 5] + 1);
            }
        }

        System.out.println(d[x]);
    }

}
