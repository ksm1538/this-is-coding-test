package sorting;

public class count_sort {

	// 아래 배열의 가장 큰 값은 9라고 가정
	public static final int MAX_VALUE = 9;
	
	public static void main(String[] args) {
		// 배열 정의
		int[] arr = {0, 5, 8, 5, 7, 6, 1, 2, 3, 4, 4, 2, 7, 9, 3, 1, 0};
		
		// 제일 작은 값과 제일 큰 값의 사이의 데이터들이 모두 리스트에 담길 수 있도록 리스트 생성
		int[] cntArr = new int[MAX_VALUE+1];
		
		// 배열의 데이터 값과 동일한 인덱스의 데이터를 하나씩 증가.
		for(int i=0;i<arr.length;i++) {
			cntArr[arr[i]]++;
		}
				
		// 기록된 리스트를 아래와 같이 출력
		for(int i=0;i<cntArr.length;i++) {
			for(int j=0; j<cntArr[i];j++) {
				System.out.print(i+" ");
			}
		}
	}

}
