package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class kruskal_Algorithm {
	
	// Edge 클래스 선언
	public static class Edge implements Comparable<Edge>{
		private int nodeA;
		private int nodeB;
		private int distance;
		
		public Edge(int nodeA, int nodeB, int distance) {
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.distance = distance;
		}

		public int getNodeA() {
			return nodeA;
		}

		public int getNodeB() {
			return nodeB;
		}
		
		public int getDistance() {
			return distance;
		}

		// 우선순위 큐에서 사용
		// 거리가 낮을 수록 높은 우선순위를 가짐
		@Override
		public int compareTo(Edge other) {
			if(this.distance < other.distance)
				return -1;
			else
				return 1;
		}
	}
	
	// V : 노드의 갯수(최대 100000개로 가정)
	// M : 간선의 갯수
	public static int V, M;
	
	// 부모 테이블
	public static int[] parent = new int[100001]; 
	
	// 그래프를 저장할 변수
	public static ArrayList<Edge> graph = new ArrayList<>();
	
	// 결과를 저장할 변수
	public static int result = 0;
	
	// 특정 원소의 루트 노드 찾기
    public static int findParent(int x) {
        // x가 루트노드라면 반환
        if (x == parent[x])
        	return x;
        // 아니라면 parent[x]가 루트노드가 될 때까지 재귀호출
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 루트 노드를 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        // 큰 수가 작은 수를 바라보도록
        if (a < b) 
        	parent[b] = a;
        else parent[a] = b;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        M = sc.nextInt();

        // 부모 테이블에서, 부모를 자기 자신으로 초기화
        // 0번 노드는 없다고 가정
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph.add(new Edge(a, b, cost));
        }

        // 간선을 비용순으로 정렬
        Collections.sort(graph);

        // 간선을 하나씩 확인하며
        for (int i = 0; i < graph.size(); i++) {
            int cost = graph.get(i).getDistance();
            int a = graph.get(i).getNodeA();
            int b = graph.get(i).getNodeB();
            
            // 사이클이 발생하지 않는 경우에만 최소 신장 트리에 포함
            // 사이클이 발생하지 않는다 = a와 b의 루트 노드가 같지 않다
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        // 결과 출력
        System.out.println(result);
	}

}
