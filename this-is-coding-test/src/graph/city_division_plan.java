package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class city_division_plan {

	// N : 집의 수
	// M : 길의 수
	public static int N, M;
	
	// 우선순위 큐
	public static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	
	// 부모 배열
	public static int[] parent;
	
	// 간선을 구현하기 위한 class 선언
	public static class Edge implements Comparable<Edge>{
		private int from;
		private int to;
		private int cost;
		
		public Edge(int a, int b, int c) {
			from = a;
			to = b;
			cost = c;
		}

		public int getFrom() {
			return from;
		}

		public void setFrom(int from) {
			this.from = from;
		}

		public int getTo() {
			return to;
		}

		public void setTo(int to) {
			this.to = to;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge other) {
			if(this.cost < other.cost)
				return -1;
			else
				return 1;
		}
	}
	
	// 부모 찾기 (집합 찾기)
	public static int findParent(int x) {
		if(x == parent[x]) {
			return x;
		}
		
		return parent[x] = findParent(parent[x]);
	}
	
	// 부모 합치기 (집합 합치기)
	public static void unionParent(int a, int b) {
		int pa = findParent(a);
		int pb = findParent(b);
		
		if(pa<pb)
			parent[pb] = pa;
		else
			parent[pa] = pb;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			parent[i]=i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			pq.offer(new Edge(from, to, cost));
		}
		
		// 결과 변수
		int result = 0;
		
		// 최소 신장 트리 중 가장 큰 간선
		int last = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			int from = edge.from;
			int to = edge.to;
			int cost = edge.cost;
			
			if(findParent(from) != findParent(to)) {
				unionParent(from, to);
				result += cost;
				last = cost;
			}
		}
		
		System.out.println(result-last);
	}

}
