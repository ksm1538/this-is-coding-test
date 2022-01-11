package sorting;

public class quick_sort {

	public static void main(String[] args) {
		// 배열 정의
		int[] arr = {8,4,5,3,9,6,7,2,1,0};
		
		// 퀵 정렬 함수 호출
		quick_sort(arr, 0, arr.length-1);
		
		// 정렬된 배열 출력
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	// 퀵 정렬 함수
	static void quick_sort(int arr[], int start, int end) {
		
		// 현재 리스트의 데이터 개수가 1일 경우 종료
		if(start>=end) {
			return;
		}
		
		// pivot은 시작점 
		int pivot = start;
		
		// pivot 앞에서 부터 체크
		int left = start+1;
		
		// 맨 뒤에서 체크
		int right = end;
		
		
		// 엇갈릴 때까지 반복
		// 엇갈리다? pivot보다 작은 데이터의 index가 pivot보다 큰 데이터의 index보다 큰 경우를 말한다.
		while(left <= right) {
			
			// pivot 보다 큰 수 찾기 (index 찾기)
			while(arr[left] <= arr[pivot] && left<=end) {
				left++;
			}
			
			// pivot 보다 작은 수 찾기(index 찾기)
			// start는 pivot이니 right>=start 할 필요가 없음
			while(arr[right] > arr[pivot] && right>start) {
				right--;
			}
				
			// 엇갈린 경우
			if(left > right) {
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = temp;
			}
			// 엇갈리지 않은 경우
			else {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp; 
			}
		}
		
		// pivot 기준 좌쪽도 quick sort 진행
		quick_sort(arr, start, right-1);
		
		// pivot 기준 우측도 quick sort 진행
		quick_sort(arr, right+1, end);
	}

}
