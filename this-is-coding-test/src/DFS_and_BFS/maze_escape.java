package DFS_and_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	private int num1;
	private int num2;
	
	public Node(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public int getNum1() {
		return this.num1;
	}
	
	public int getNum2() {
		return this.num2;
	}
}

public class maze_escape {

	public static int num1,num2;
	public static int[][] graph = new int[200][200];

	// 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
    public static int dnum1[] = {-1, 1, 0, 0};
    public static int dnum2[] = {0, 0, -1, 1};
		
	public static int bfs(int temp_num1, int temp_num2) {
		
		// queue.offer() : 삽입
		// queue.poll() : 빼고 확인
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(temp_num1, temp_num2));
		
		// 큐가 빌 때 까지
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			temp_num1 = node.getNum1();
			temp_num2 = node.getNum2();
			
			// 상하좌우 체크
			for(int i=0;i<dnum1.length;i++) {
				int nNum1 = temp_num1 + dnum1[i];
				int nNum2 = temp_num2 + dnum2[i];
				
				if(nNum1 >= num1 || nNum1 < 0 || nNum2 >= num2 || nNum2 < 0) {
					continue;
				}
				else {
					int temp = graph[nNum1][nNum2];
					
					if(temp == 0) {
						continue;
					}
					// 방문 안한 노드의 경우 이전 노드의 +1 처리 후 큐에 삽입
					else if(temp == 1) {
						graph[nNum1][nNum2] = graph[temp_num1][temp_num2]+1;
						queue.offer(new Node(nNum1,nNum2));
					}
				}
			}
		}
		
		
		return graph[num1-1][num2-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		sc.nextLine(); 	// remove buffer 
		
		// String.charAt(i) : 문자열에서 해당 위치의 문자를 가져오는 함수
        // 주의점 : char 타입으로 리턴된다. -> 즉, 아래의 int 타입으로 데이터를 넣으려고 할 땐 - '0'이 필요하다.
		for(int i=0;i<num1;i++) {
			String temp = sc.nextLine();
			for(int j=0;j<num2;j++) {
				graph[i][j] = temp.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(0,0));
	}

}
