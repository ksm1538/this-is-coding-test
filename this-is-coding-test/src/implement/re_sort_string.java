package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class re_sort_string {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 문자열 입력받고
		String str = br.readLine();
		
		// split함수를 이용해서 배열에 넣기
		String[] arr = str.split("");
		
		// 숫자의 합을 저장할 변수
		int sum = 0;
		
		// 결과 출력에 이용할 리스트
		ArrayList<String> result = new ArrayList<>();

		// 문자열 배열의 길이만큼 반복
		for(int i=0; i<arr.length; i++) {
			// 숫자일 경우 sum에 더해줌 (아스키코드로 48 : 0, 57 : 9)
			if(arr[i].charAt(0)>=48 && arr[i].charAt(0)<=57) {
				sum += Integer.parseInt(arr[i]);
			}
			
			// 숫자가 아니면 리스트에 넣어줌
			else {
				result.add(arr[i]);
			}
		}
		
		// 알파벳 순서대로 정렬
		result.sort(null);
		
		// 숫자의 합을 문자열로 변환하고 결과 리스트에 넣기
		result.add(Integer.toString(sum));
		
		// 결과리스트 출력
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i));
		}
	}

}
