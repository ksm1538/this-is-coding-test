package dynamic_Programming;

import java.util.*;

public class ant_warrior {

    // 최대 식량창고의 갯수는 100개
    public static int[] d = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 N을 입력받기
        int n = sc.nextInt();

        // 모든 식량 정보 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 다이나믹 프로그래밍 (Bottom-up 방식)
        // 2번째까지는 직접 비교
        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);
        
        // 3번째 창고부터는 (2개 전 창고 기준 최대 갯수 + 현재 창고 갯수) 와 (1개 전 창고 기준 최고 갯수) 중, 큰 것을 선택한다.
        // 게산 할 떄는 만약 내가 3번 째 창고가 기준이라면 4번 째 5번 째 등 현재 창고 뒤의 창고는 없다고 가정한다.
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }

        // 결과 출력
        System.out.println(d[n - 1]);
    }
}