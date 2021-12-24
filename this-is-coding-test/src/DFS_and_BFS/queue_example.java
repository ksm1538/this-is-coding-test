package DFS_and_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class queue_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();

		/**** Queue 사용법 ****/
		// Queue : FIFO. First In First Out
		// JAVA에서 Queue 선언 시, LinkedList 필요
		// add(), offer() : 삽입. overflow 상황에서 add는 예외발생, offer는 false 반환
		// remove() : 첫번 째 데이터 삭제
		// poll() : 첫번 째 데이터 반환하고 삭제. 비어있으면 null 반환
		// peek() : 데이터 조회
		// isEmpty() : queue이 비어있는 지 확인. 비어있으면 true, 아니면 false 반환
		// clear() : 큐 비우기
		/********************/
		
        // 삽입(1) - 삽입(2) - 삽입(3) - 삽입(4) - 삭제() - 삽입(5) - 삽입(6) - 삭제()
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.poll();
		queue.offer(5);
		queue.offer(6);
        queue.poll();
        
        // 먼저 들어온 원소부터 추출
        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        } 
	}

}
