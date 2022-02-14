package etc_Algorithm;

import java.util.Arrays;

public class eratostenes_Algorithm {

	public static int n = 1000; // 2 ~ 1,000 사이의 모든 수 소수 판별 
	
    public static boolean[] arr = new boolean[n + 1]; 

    public static void main(String[] args) {
    	// 모든 수가 소수라고 가정한다. 
        Arrays.fill(arr, true); 
        
        // 0과 1은 소수가 아님 
        arr[0] = false;
        arr[1] = false;
        
        // 에라토스테네스의 체 알고리즘 수행
        // 2부터 n의 제곱근까지의 모든 수를 확인
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // i가 소수인 경우(남은 수인 경우)
            if (arr[i] == true) {
                // i를 제외한 i의 모든 배수는 소수가 아님!
                int j = 2;
                while (i * j <= n) {
                    arr[i * j] = false;
                    j += 1;
                }
            }
        }
        
        // 기록된 모든 소수 출력
        for (int i = 2; i <= n; i++) {
            if (arr[i] == true)
            	System.out.print(i + " ");
        }
    }

}
