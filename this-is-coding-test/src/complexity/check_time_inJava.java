package complexity;

public class check_time_inJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
	    
	    int a = 1;
	    int b = 2;
	    
	    System.out.println("연산 결과 : " + (a+b));
	    
	    long end = System.currentTimeMillis();
	    
	    System.out.println("실행시간 : " + (end - start));
	    System.out.println("초 단위 실행시간 : " + (end - start)/1000.0);
	    System.out.println("분 단위 실행시간 : " + (end - start)/1000.0/60.0);
	}

}
