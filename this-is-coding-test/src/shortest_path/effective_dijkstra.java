package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//거리와 노드를 저장할 수 있는 Node Class 선언
class Node implements Comparable<Node>{
	// 거리 
	private int distance;

	// 노드
	private int index;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	// 거리가 낮을수록 우선순위가 높게 설정
	@Override
	public int compareTo(Node other) {
		if(this.distance < other.distance) {
			return -1;
		}else {
			return 1;
		}
	}
}
	
public class effective_dijkstra {

	// 무한을 의미하는 10억, INF라는 파이널 상수 선언
	public static final int INF = (int)1e9;
	
	// 노드의 갯수 : N
	// 간선의 갯수 : M
	// 시작점 노드 : start
	public static int N,M,start;
	
	// 노드와 간선의 정보를 가지는 그래프 변수
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	// 최단 거리를 저장할 변수
	// 노드는 최대 100000개라고 가정
	public static int[] d;
	
	public static void dijkstra() {
		// 우선순위 큐 선언
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 시작노드. 즉, 자기 자신의 거리는 0으로 설정
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		// 우선순위 큐가 빌 때까지 반복
		while(!pq.isEmpty()) {
			
			// 최단 거리가 가장 짧은 노드 꺼내기
			// 우선순위 큐이기에 알아서 꺼내짐
			Node node = pq.poll();
			
			// 시작 노드에서 현재 노드까지의 거리 합
			int distance = node.getDistance();
			
			// 현재 노드
			int index = node.getIndex();
			
			// 현재 노드가 처리된 적이 있는 경우
			// 조건처럼 큐의 거리가 더 작은 경우는 이전에 큐에 들어가고, 그 이후에 더 짧은 경로를 찾아 갱신했다는 뜻
			// continue를 이용해 무시
			if(d[index] < distance) {
				continue;
			}
			
			// 현재 노드와 연결된 다른 노드와의 거리 확인
			for(int i=0; i < graph.get(index).size(); i++) {
				int cost = distance + graph.get(index).get(i).getDistance();
				
				// 현재의 노드를 경유하여 i번째 노드로 가는 것이 최단 경로에 기록된 거리보다 효율적일 때 갱신 및 우선순위 큐에 해당 노드의 정보를 삽입
				if(cost <  d[graph.get(index).get(i).getIndex()]) {
					d[graph.get(index).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
				}
			}
			
		}
	} 
	
	public static void main(String[] args) throws IOException{
		// 입력기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 공백을 기준으로 문자를 분리해주는 함수
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 노드의 갯수 입력
		N = Integer.parseInt(st.nextToken());
		
		// 간선의 갯수 입력
		M = Integer.parseInt(st.nextToken());
		
		// 시작점 노드 설정
		start = Integer.parseInt(br.readLine());
		
		// 최단 거리를 저장할 변수. 노드의 갯수+1만큼 공간 할당
		d = new int[N+1];
		
		// 노드의 갯수만큼 그래프에 노드 추가
		// 보기 쉽게 하기위해, 0번부터 N번을 포함하여 생성
		// 0은 사용 X
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		// 간선의 갯수만큼 반복 및 간선 데이터 저장
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			// 그래프 변수에 넣어주기
			// from노드에서 to노드까지의 distance거리 
			graph.get(from).add(new Node(to, distance));
		}
		
		// 최단 경로 변수에 모든 노드에 대한 거리를 INF로 초기화
		Arrays.fill(d, INF);
		
		// 최단 경로 확인
		dijkstra();
		
		// 시작 노드에서 각 노드별 최단 경로 출력
		for(int i=1; i<=N; i++) {
			System.out.print(i+"번 노드까지의 거리 : ");
			// 갈 수 없는 경우 무한으로 출력
			if(d[i] == INF) {
				System.out.println("갈 수 없음");
			}
			else {
				System.out.println(d[i]);
			}
		}
			
	}

}
