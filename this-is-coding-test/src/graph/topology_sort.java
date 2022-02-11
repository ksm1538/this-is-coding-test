package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class topology_sort {
	
	// N : 노드의 갯수
	// M : 간선의 갯수
	public static int N, M;
	
	// 그래프
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	// 각 노드 별 진입차수 체크
	public static int[] inde;
	
	public static void topologySort() {
		
		Queue<Integer> q = new LinkedList<>();
		
		ArrayList<Integer> result = new ArrayList<>();
		
		// 진입차수가 0인 노드를 큐에 넣기
		for(int i=1; i<=N; i++) {
			if(inde[i]==0)
				q.offer(i);
		}

		// 큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			// 큐에서 꺼내고
			int now = q.poll();
			
			// 결과 리스트에 넣기
			result.add(now);
			
			// 현재 큐에서 이어지는 간선을 빼주기
			for(int i=0; i<graph.get(now).size(); i++) {
				inde[graph.get(now).get(i)] -= 1;
				
				// 그 때, 진입차수가 0이면 큐에 넣기
				if(inde[graph.get(now).get(i)] == 0)
					q.offer(graph.get(now).get(i));
			}
		}
		
		System.out.print("순서 : ");
		// 결과 출력
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i)+" ");
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 노드의 갯수와 간선의 갯수 입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 진입차수 배열 크기 할당
		inde = new int[N+1];
		
		// 그래프 설정
		for(int i=0;i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(to);
			
			// 진입차수 설정
			inde[to] += 1;
		}
		
		// 위상정렬 호출
		topologySort();
		
	}

}
