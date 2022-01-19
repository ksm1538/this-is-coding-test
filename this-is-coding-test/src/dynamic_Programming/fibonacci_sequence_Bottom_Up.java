package dynamic_Programming;

public class fibonacci_sequence_Bottom_Up {

	// 계산된 값들을 저장
	static long[] arr = new long[100];
	
	public static void main(String[] args) {

		int N = 50;
		
		arr[1]=1;
		arr[2]=1;
		
		// 50까지의 모든 계산 결과 저장
		for(int i=3;i<=N;i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		System.out.println(arr[N]);
	}
	
}
