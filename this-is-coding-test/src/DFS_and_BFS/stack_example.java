package DFS_and_BFS;

import java.util.Stack;

public class stack_example {

	public static void main(String[] args) {
        
		
		Stack<Integer> stack = new Stack<>();

		/**** Stack 사용법 ****/
		// Stack : FIFO. First In Last Out
		// push() : 삽입
		// pop() : 삭제
		// peek() : 데이터 조회
		// empty() : stack이 비어있는 지 확인. 비어있으면 true, 아니면 false 반환
		// search(Object o) : 인자값으로 받은 데이터의 위치 반환. 맨 위가 1로 시작하여 안으로 들어갈 때마다 증가
		// stack에 1,2,3,5 가 있을 때 stack.search(2)는 5~3~2 해서 3 반환
		/********************/
		
		// 삽입(1) - 삽입(2) - 삽입(3) - 삽입(4) - 삭제() - 삽입(5) - 삽입(6) - 삭제()
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		stack.push(5);
		stack.push(6);
		stack.pop();
		
		System.out.println("2의 위치는 : " + stack.search(2));
        
        // 스택의 최상단 원소부터 출력
		// 스택이 빌 때까지 반복
        while (!stack.empty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }

}
