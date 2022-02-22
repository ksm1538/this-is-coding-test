package etc_Algorithm;

public class find_subsequence_sum_count {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		// 데이터의 갯수
		int N = 5;
		
		// 찾을 부분합
		int M = 7;
		
		// 데이터
		int[] data = {1,2,3,4,5};
		
		// 시작점과 끝점은 0으로 시작
		int start=0, end = 0;
		
		// 찾을 부분합과 일치하는 부분수열의 갯수
		int count = 0;
		
		// 시작점이 끝까지 갈 때까지 반복
		while(start<N) {
			
			// 시작점부터 끝점 사이의 부분 수열의 합 구하기
			int tempSum = 0;
			for(int i=start; i<end; i++) {
				tempSum += data[start];
			}
			
			// 부분 수열의 합이 찾을 부분합과 같다면 카운트
			if(tempSum == M) {
				count++;
			}
			
			// 부분 수열의 합이 M보다 작다면 end 증가
			if(tempSum < M) {
				end++;
			}
			
			// 부분 수열의 합이 M보다 크거나 같다면 start 증가
			else {
				start++;
			}
		}
		
		System.out.println("결과 : " + count);
	}

}
