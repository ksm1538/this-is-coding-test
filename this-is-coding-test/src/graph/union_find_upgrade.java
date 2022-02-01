package graph;

import java.util.Scanner;

public class union_find_upgrade {

	// V : 노드의 갯수
	// M : 간선의 갯수 
    public static int V, M;
    
    // 노드의 개수는 최대 100,000개라고 가정
    // 부모 노드 테이블
    public static int[] parent = new int[100001];

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // x의 부모노드가 루트노드일 경우 x 반환
        if (x == parent[x]){
        	return x;
        }
        
        // 아니면 루트노드 찾은 후에 parent 배열에 넣고 반환
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

        // 부모 테이블에서, 부모 노드를 자신으로 초기화
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        // Union 연산 수행
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        // 각 원소가 속한 집합 출력하기
        System.out.print("각 원소가 속한 집합 : ");
        for (int i = 1; i <= V; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= V; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

}
