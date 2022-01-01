package DFS_and_BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class eat_Frozen_Drink {

	public static int x,y;
	// 방문했던 노드를 체크하기 위한 변수
	public static boolean[] visited_Node = new boolean[1000000];
	
	// 그래프 변수
	public static int[][] graph = new int[1000][1000];
		
	public static boolean dfs(int temp_y, int temp_x) {
		// 범위가 벗어나는 경우 종료
		if(temp_y < 0 || temp_y >= y || temp_x < 0 || temp_x >= x) {
			return false;
		}
		
		
        if(graph[temp_y][temp_x] == 0) {
        	// 방문 안 한 경우 
        	
        	
        	graph[temp_y][temp_x] = 1; // 방문 처리
        	
        	// dfs 재귀함수를 이용하는 이유?  상하좌우가 붙어있는 경우 하나로 간주하기 때문에 dfs 재귀함수를 이용해서 방문했었다. 를 기록하기 위함임.
        	// 위의 '방문했었다.' 란 뜻은 이 노드는 이제 신경쓰지마라 라는 걸로 이해할 수 있음 
        	// 아래는 상하좌우를 체크하는 것
        	dfs(temp_y+1,temp_x);
        	dfs(temp_y-1,temp_x);
        	dfs(temp_y,temp_x+1);
        	dfs(temp_y,temp_x-1);
        	
        	return true;
        }
        else {
        	// 이미 방문 한 경우 반환
        	return false;
        }
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        y = sc.nextInt();
        x = sc.nextInt();
        
        // 버퍼 지우기
        sc.nextLine();		
        
        // 음료수의 갯수
        int result = 0;
        
        // String.charAt(i) : 문자열에서 해당 위치의 문자를 가져오는 함수
        // 주의점 : char 타입으로 리턴된다. -> 즉, 아래의 int 타입으로 데이터를 넣으려고 할 땐 - '0'이 필요하다.
        for(int i=0;i<y;i++) {
        	String temp = sc.nextLine();
        	for(int j=0;j<x;j++) {
        		graph[i][j] = temp.charAt(j)-'0';
        	}
        }
        
        // DFS 알고리즘을 이용하여 음료수의 갯수를 확인한다.
        for(int i=0;i<y;i++) {
        	for(int j=0;j<x;j++) {
        		if(dfs(i,j)) {
        			result++;
        		};
        	}
        }
        
        // 결과 출력
        System.out.println(result);

	}

}
