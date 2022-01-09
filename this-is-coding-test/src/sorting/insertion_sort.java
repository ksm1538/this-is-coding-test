package sorting;

public class insertion_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {8,4,5,3,9,6,7,2,1,0};
		int length = arr.length;
		
		for(int i=0;i<length;i++) {
			for(int j=i; j>0; j--) {
				if(arr[j]<arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				else {
					break;
				}
			}
		}
		
		System.out.print("정렬 결과 : ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
