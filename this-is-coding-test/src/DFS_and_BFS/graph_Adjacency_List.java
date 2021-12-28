package DFS_and_BFS;

import java.util.*;

public class graph_Adjacency_List {

	// 인접 리스트 선언
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    
	public static void main(String[] args) {

		// 그래프에 3개의 노드 추가
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 노드 0에서 다른 노드와 연결된 노드 정보 저장 (노드, 거리)
        graph.get(0).add(new Node(1, 3));
        graph.get(0).add(new Node(2, 9));

        // 노드 1에서 다른 노드와 연결된 노드 정보 저장 (노드, 거리)
        graph.get(1).add(new Node(0, 3));

        // 노드 2에서 다른 노드와 연결된 노드 정보 저장 (노드, 거리)
        graph.get(2).add(new Node(0, 9));

        // 그래프 출력
        for (int i = 0; i < graph.size(); i++) {
        	System.out.print(" (FROM : " + i + ") -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).print();
            }
            System.out.println();
        }
	}
	
	// 노드 클래스 선언
	static class Node {

	    private int index;
	    private int distance;

	    // 생성자로 클래스의 변수 초기화
	    public Node(int index, int distance) {
	        this.index = index;
	        this.distance = distance;
	    }

	    // 출력
	    public void print() {
	        System.out.print("[To : " + this.index + ", Distance : " + this.distance + "] ");
	    }
	}
	
	
}
