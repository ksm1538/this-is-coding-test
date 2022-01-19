package dynamic_Programming;

public class fibonacci_sequence_memoization_Top_Down {

	// 계산된 값들을 저장
	static long[] arr = new long[100];
	
	public static void main(String[] args) {

		System.out.println(fibonacci(50));
	}
	
	static long fibonacci(int num){
		if(num == 1 || num == 2) {
			return 1;
		}
		
		// 해당 피보나치 수열에 대한 계산 값이 없으면 계산
		if(arr[num] == 0) {
			long result =  fibonacci(num-1) + fibonacci(num-2);
			arr[num] = result;
			
			return result;
		}
		// 계산 값이 있으면 그 값을 가져와서 반환
		else {
			return arr[num];
		}
	}

}
