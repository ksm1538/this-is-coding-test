package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class floyd_warshall {
	// 무한 변수 선언
	public static final int INF = (int)1e9;
	
	// 노드의 갯수 : N
	// 간선의 갯수 : M
	public static int N,M;
	
	// 2차원 배열로 그래프 표현
	// 노드의 최대 갯수를 500개로 가정
    public static int[][] graph;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 노드의 갯수 입력받기
		N = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		
		// 간선의 갯수 입력받기
		M = Integer.parseInt(br.readLine());
		
		// 최단 거리 테이블을 무한으로 초기화
		for(int i=0; i<N+1; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		// 자기 자신으로의 거리는 0으로 초기화
		for(int i=1; i<=N; i++) {
			graph[i][i] = 0;
		}
		
		// 그래프 데이터 설정
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			graph[from][to] = distance;
		}
		
		// 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= N; k++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    graph[from][to] = Math.min(graph[from][to], graph[from][k] + graph[k][to]);
                }
            }
        }
        
        // 수행된 결과를 출력
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                // 갈 수 없는 경우, X이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("X ");
                }
                // 갈 수 있는 경우 최단 경로 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
		
	}

}
