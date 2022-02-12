package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class curriculum {

	// 과목 갯수
	public static int N;
	
	// 위상정렬
	public static int[] inde;
	
	// 시간
	public static int[] time;
	
	// 최소 시간(결과)
	public static int[] result;
		
	// 맵
	public static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
	

	public static void topology() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(inde[i] == 0){
				q.offer(i);
			}
			result[i] = time[i];
		}
		
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			
			for(int i=0; i<map.get(now).size(); i++) {
				int d = map.get(now).get(i);
				
				result[d] = Math.max(result[d], result[now] + time[d]);
				//result[d] = result[now] + time[d]; 은 안될까? 결과는 같은데.. 
				inde[d] -= 1;
				if(inde[d] == 0) {
					q.offer(d);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());

		inde = new int[N+1];
		time = new int[N+1];
		result = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			map.add(new ArrayList<Integer>());
		}
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			time[i]=Integer.parseInt(st.nextToken());
			
			while(true) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(temp == -1)
					break;
				
				map.get(temp).add(i);
				
				inde[i] += 1;
			}
		}
		
		topology();
		
		for(int i=1; i<=N; i++) {
			System.out.println(result[i]);
		}
		
		
	}

}
