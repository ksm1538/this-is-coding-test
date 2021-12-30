package DFS_and_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_Using_Adjacency_List {
	// 방문했던 노드를 체크하기 위한 변수
	public static boolean[] visited_Node = new boolean[7];
	
	// 그래프 변수
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
	// BFS 함수
	// 너비우선탐색
	// 가까이 있는 원소부터 탐색
    public static void bfs(int num) {
    	Queue<Integer> queue = new LinkedList<>();
    	
    	queue.offer(num);
        // 현재 노드를 방문 처리
    	visited_Node[num] = true;
        
    	// queue가 빌 때까지 반복
    	while(!queue.isEmpty()) {
            // queue에서 하나의 원소를 뽑음
    		// 선입선출이기에 먼저 들어온 것이 먼저 뽑힘
            int x = queue.poll();
            
            System.out.print(x + " ");
            
            // 해당 원소와 연결되어 있는 원소 확인
            for(int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                
                // 아직 방문처리가 안 된 원소는 queue에 넣고 방문 처리
                if(!visited_Node[y]) {
                	queue.offer(y);
                	visited_Node[y] = true;
                }
            }
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
        

        bfs(0);
		
	}

}
