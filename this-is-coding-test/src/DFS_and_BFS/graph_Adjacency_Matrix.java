package DFS_and_BFS;

public class graph_Adjacency_Matrix {

	public static final int INFINITE = 999999999;
    
    // 2차원 배열를 이용해 인접 행렬 표현
    public static int[][] graph = {
        {0, 3, 9},
        {3, 0, INFINITE},
        {9, INFINITE, 0}
    };

    public static void main(String[] args) {
        // 그래프 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}
