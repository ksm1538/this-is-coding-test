package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class future_city {
	public static int[][] graph;
		
	public static final int INF = (int)1e9;
	
	public static int[] visited;
	
	// 최단 거리 테이블 만들기
    public static int[] d;
    
	public static int N,M,X,K;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		
		// 초기에 무한으로 설정
		for(int i=0; i<=N; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		M = Integer.parseInt(st.nextToken());
		
		// 간선 세팅
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			graph[node1][node2] = 1;
			graph[node2][node1] = 1;
		}
		
		// 자기 자신에게 가는 비용 0
		for(int i=0; i<=N; i++) {
			graph[i][i] = 0;
		}
		
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 점화식에 따라 플로이드 워셜 알고리즘을 수행
		// from노드에서 to 노드로 곧장 가는 것보다 temp노드를 거쳐 가는 것이 빠른 지 확인하는 알고리즘
        for(int temp = 1; temp<=N; temp++) {
        	for(int from = 1; from<=N; from++) {
        		for(int to = 1; to<=N; to++) {
        			graph[from][to] = Math.min(graph[from][to], graph[from][temp]+graph[temp][to]);
        		}
        	}
        }
        
        int result = graph[1][K] + graph[K][X];
        
        if(result > INF) {
        	System.out.println("도달 불가");
        }else {
        	System.out.println(result);
        }
        
	}

}
