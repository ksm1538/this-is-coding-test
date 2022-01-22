package dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class effective_currency {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 가지고 있는 화폐 종류 입력
		int[] currencyArr = new int[N];
		for(int i=0;i<N;i++) {
			currencyArr[i] = Integer.parseInt(br.readLine());
		}

		// M까지의 화폐를 구성하는데 최소의 경우수를 모아둔 배열 
		int[] countArr = new int[M+1];
		// 모든 배열의 수를 99999로 설정
		Arrays.fill(countArr, 99999);
		
		countArr[0] = 0;	// 0원은 0개이므로 0으로 설정
		
		// 가지고 있는 화폐의 종류만큼 반복
		for(int i=1; i<N;i++) {
			// 지금 확인하는 화폐의 수부터 확인할 화폐의 크기까지 반복
			for(int j=currencyArr[i]; j<=M; j++) {
				// x + 현재 화폐종류 = j  가 가능하려면
				// x가 99999가 아니어야 한다. Why? 99999라면 애초에 x를 조합할 수 없기 떄문에.
				if(countArr[j-currencyArr[i]] != 99999) {
					countArr[j] = Math.min(countArr[j], countArr[j-currencyArr[i]]+1);
				}
			}
		}
		
		if(countArr[M]==99999) {
			System.out.println(-1);
		}else {
			System.out.println(countArr[M]);
		}
		
	}
}
