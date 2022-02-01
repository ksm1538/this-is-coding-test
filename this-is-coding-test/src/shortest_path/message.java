package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class message {

	// 무한을 의미
	public static final int INF = (int)1e9;
	
	// graph 변수
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	// N : 도시(노드)의 갯수
	// M : 통로(간선)의 갯수
	// START : 메시지를 보내는 도시(시작점)
	public static int N, M, START;
	
	public static int[] d;
	
	public static void dijkstra() {
		// 우선순위 큐
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 무한으로 초기화
		Arrays.fill(d, INF);
				
		// 자기 자신에게 가는 비용은 0으로 초기화
		d[START] = 0;
		
		// 우선순위 큐에 START 노드 넣기
		pq.offer(new Node(START, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			// 현재 노드
			int now = node.getIndex();
			
			// 시작 노드에서 현재 노드까지의 거리 합
			int distance = node.getDistance();
			
			// 현재 노드와 연결된 노드의 갯수만큼 반복
			for(int i=0; i<graph.get(now).size(); i++) {
				
				// 시작지점 ~ 현재 노드의 거리 + 현재 노드 ~ 다음 노드까지의 거리
				int cost = distance + graph.get(now).get(i).getDistance();
				
				// cost가 이전 보다 최단 경로라면  최단 경로 배열 갱신 및 우선순위 큐에 삽입
				if(cost < d[i]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		START = Integer.parseInt(st.nextToken());
		
		// 도시 추가
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			// from 도시에서 to 도시로 distance의 통로가 있다
			graph.get(from).add(new Node(to, distance));
		}
		
		// 최단 경로 데이터 저장 변수 크기 선언
		d = new int[N+1];
		
		// 우선순위 큐를 이용한 다익스트라 알고리즘 실행
		dijkstra();
		 
		int result = 0;
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(d[i] == INF) {
				continue;
			}
			result += d[i];
			cnt++;
		}
		
		System.out.println(cnt + " " + result);
		
	}

}
