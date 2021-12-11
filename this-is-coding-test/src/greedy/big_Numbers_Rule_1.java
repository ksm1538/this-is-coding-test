package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class big_Numbers_Rule_1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a= br.readLine();
		String b= br.readLine();
		
		StringTokenizer st = new StringTokenizer(a);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int big1 = 0;
		int big2 = 0;
		StringTokenizer st2 = new StringTokenizer(b);
		
		for(int i =0; i<N ; i++) {
			int num = Integer.parseInt(st2.nextToken());
			
			if(num >= big1 && num >= big2) {
				big2 = big1;
				big1 = num;
			}else if(num < big1 && num >= big2) {
				big2 = num;
			}
		}
		
		int result = 0;
		
		for(int i=1; i<=M; i++) {
			if(i%K == 0) {
				result += big2;
			}else{
				result += big1;
			}
		}
		
		System.out.println(result);
		
	}

}
