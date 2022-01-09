package sorting;

public class selection_sort {

	public static void main(String[] args) {
		// 선택 정렬 이용.  
		int[] arr = {8,4,5,3,9,6,7,2,1,0};
		
		int length = arr.length;
		
		for(int i=0; i<length;i++){
			int min = arr[i];
			int index = i;
			
			for(int j=i; j<length;j++) {
				if(min>arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			 
			// Swap
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		System.out.print("정렬 결과 : ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
