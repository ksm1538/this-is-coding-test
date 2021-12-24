package DFS_and_BFS;

public class recursive_Function_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 아래에서 선언한 재귀함수에 인자를 1로 하여 호출
		recursiveFunction(1);
	}

	public static void recursiveFunction(int num) {
        
		// 100번째 호출을 했을 때 종료되도록 종료 조건 명시
        if (num == 100) 
        	return;
        
        System.out.println(num + "번째 재귀 함수에서 " + (num + 1) + "번째 재귀함수를 호출합니다.");
        // 자기 자신을 num을 1 증가시켜서 호출
        recursiveFunction(num + 1);
        System.out.println(num + "번째 재귀 함수를 종료합니다.");
    }
}
