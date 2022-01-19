package dynamic_Programming;

public class fibonacci_sequence_recursive_function {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = fibonacci(4);
		
		System.out.println(result);
	}
	
	static int fibonacci(int num){
		if(num == 1 || num == 2) {
			return 1;
		}
		return fibonacci(num-1) + fibonacci(num-2);
	}

}
