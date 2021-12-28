package DFS_and_BFS;

import java.util.*;

public class dfs_Using_Adjacency_List {

	// 방문했던 노드를 체크하기 위한 변수
	public static boolean[] visited_Node = new boolean[7];
	
	// 그래프 변수
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	 
	// DFS 함수
	// 깊이우선탐색
	// 같은 Depth가 있을 경우, 작은 숫자를 먼저 방문(add를 작은 숫자 먼저 했기 때문)
    public static void dfs(int num) {
        // 현재 노드를 방문 처리
    	visited_Node[num] = true;
        System.out.print(num + " ");
        
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(num).size(); i++) {
            int temp = graph.get(num).get(i);
            if (!visited_Node[temp]) 
            	dfs(temp);
        }
    }
    
    public static void main(String[] args) {
        // 그래프에 7개의 노드 추가
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 0에 연결된 노드 정보 저장 
        graph.get(0).add(1);
        graph.get(0).add(2);
        
        // 노드 1에 연결된 노드 정보 저장 
        graph.get(1).add(0);
        graph.get(1).add(5);
        
        // 노드 2에 연결된 노드 정보 저장 
        graph.get(2).add(0);
        graph.get(2).add(3);
        
        // 노드 3에 연결된 노드 정보 저장 
        graph.get(3).add(2);
        graph.get(3).add(4);
        graph.get(3).add(6);
        
        // 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(3);
        
        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(1);
        
        // 노드 6에 연결된 노드 정보 저장 
        graph.get(6).add(3);
        

        dfs(0);
    }

}
