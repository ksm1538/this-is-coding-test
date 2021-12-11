package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class adventurers_Guild {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] arr = new int[num];
        
        for (int i = 0; i < num; i++) {
        	arr[i]=(sc.nextInt());
        }

        Arrays.sort(arr);

        int result = 0; // 총 그룹의 수
        int count = 0; // 현재 그룹에 포함된 모험가의 수

        for (int i = 0; i < num; i++) { 
            count += 1; // 현재 그룹에 해당 모험가를 포함시키기
            if (count >= arr[i]) { // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
                result += 1; // 총 그룹의 수 증가시키기
                count = 0; // 현재 그룹에 포함된 모험가의 수 초기화
            }
        }

        System.out.println(result);
    }

}
