package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class make_team {
	
	// N : 학생 수
	// M : 연산의 수
	public static int N, M;
	
	// 부모 변수
	public static int[] parent;
	
	// 결과 변수
	public static ArrayList<String> result = new ArrayList<>();
	
	// 특정 원소의 부모 찾기
	public static int findParent(int x) {
		
		// 현재 원소가 부모 그 자체일 경우 x 반환
		if(x == parent[x]) {
			return x;
		}
		
		// 아닐 경우, 그 부모의 부모를 찾고 parent[x]에 대입 및 반환
		return parent[x] = findParent(parent[x]);
	}
	// 팀 합치기 (부모 합치기)
	public static void unionParent(int a, int b) {
		// a의 루트 노드
		int pa = findParent(a);
		
		// b의 루트 노드
		int pb = findParent(b);
		
		// 일반적으로 큰 수가 작은 수를 바라봄
		if(pa<pb) {
			parent[pb] = pa;
		}
		else {
			parent[pa] = pb;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 부모 정보를 담을 배열 넣기
		parent = new int[N+1];
		
		// 부모는 자기 자신으로 초기화
		for(int i=0; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 팀 합치기 (부모 합치기)
			if(type==0) {
				unionParent(a,b);
			}
			
			// 같은 팀 여부 확인 (부모 확인)
			else {
				// 부모가 같으면 같은 팀.
				if(parent[a] == parent[b]) {
					result.add("YES");
					
				// 부모가 다르면 다른 팀
				}else {
					result.add("NO");
				}
			}
		}
		
		// 결과 출력
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	

}
