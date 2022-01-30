package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// Node클래스는 effective_dijkstra.java 에서 선언함


public class simple_dijkstra {
	// 무한을 의미하는 값으로 10억 설정
    public static final int INF = (int) 1e9; 
    
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    public static int n, m, start;
    
    // 그래프 변수
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    
    // 방문 체크용 변수 생성
    public static boolean[] visited;
    
    // 최단 거리 테이블 만들기
    public static int[] d;

    // 방문하지 않은 노드 중에서 가장 최단 거리가 짧은 노드 반환
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        // 시작 노드에 대해서 초기화
        d[start] = 0;
        
        // 시작 노드도 방문 체크
        visited[start] = true;
        
        // 시작노드와 연결된 간선 갱신
        // if로 비교하지 않는 이유? 초기에 기록용 변수에 다 무한으로 저장해놨기 때문에 거리가 있다면 무한보다 작을 수 밖에 없다.
        for (int i = 0; i < graph.get(start).size(); i++) {
            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }
        
        // 시작 노드를 제외한 노드 반복
        for (int i = 0; i < n - 1; i++) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            int now = getSmallestNode();
            
            visited[now] = true;
            // 현재 노드와 연결된 다른 노드를 확인
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우에만 갱신
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
    	// 입력이 빠른 BufferedReader 이용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 공백을 구분하여 반환해주는 StringTokenizer 이용
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 노드의 갯수(n), 간선의 갯수(m), 시작 노드(start) 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        
        // 방문 체크용 변수와 최단 경로 기록용 변수에 크기 할당
        visited = new boolean[n+1];
        d = new int[n+1];

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            // from 노드에서 to노드로 가는 비용이 cost
            graph.get(from).add(new Node(to, cost));
        }

        
        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);
        
        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, '갈 수 없음' 출력
            if (d[i] == INF) {
                System.out.println(i+"번 노드 까지의 최단 거리 : INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(i+"번 노드 까지의 최단 거리 : " + d[i]);
            }
        }
    }
}