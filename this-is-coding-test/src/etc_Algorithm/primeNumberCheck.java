package etc_Algorithm;

public class primeNumberCheck {

	// 소수 판별 
	// 2 이상의 자연수만 판별 가능 
    public static boolean isPrimeNumber(int x) {
        // 2 ~ x의 제곱근까지만 확인
    	// Math.sqrt : 제곱근 
        for (int i = 2; i <= Math.sqrt(x); i++) {
            // x가 해당 수로 나누어떨어진다면
            if (x % i == 0) {
                return false; // 소수가 아님
            }
        }
        
        // 위의 반복 중에서 나누어 떨어지는 경우가 없으면 소수임
        return true; 
    }

    public static void main(String[] args) {
    	// 6은 소수가 아님 
        System.out.println(isPrimeNumber(6));
        
        // 11은 소수임 
        System.out.println(isPrimeNumber(11));
    }

}
