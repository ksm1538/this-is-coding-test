package graph;

import java.util.*;

public class cycle_check_union_find {

	// V : 노드의 갯수
	// M : 간선의 갯수 
    public static int V, M;
	    
    public static int[] parent = new int[100001]; // 부모 테이블 초기화하기

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // x가 루트노드 일 경우 x 반환
        if (x == parent[x]) {
        	return x;
        }
        
        // 아닐 경우, 루트노드를 찾기위해 재귀 호출 후 이 값을 반환 및 parent 배열에 저장
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        M = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        boolean cycle = false; // 사이클 발생 여부

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 사이클이 발생한 경우 종료
            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            }
            // 사이클이 발생하지 않았다면 합집합(Union) 연산 수행
            else {
                unionParent(a, b);
            }
        }

        if (cycle) {
            System.out.println("사이클 있음");
        }
        else {
            System.out.println("사이클 없음");
        }
    }
}
