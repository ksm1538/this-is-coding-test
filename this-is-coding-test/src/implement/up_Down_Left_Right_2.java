package implement;

import java.util.Scanner;

public class up_Down_Left_Right_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		String command = sc.nextLine();
		
		String[] commandArr = command.split(" ");
		int length = commandArr.length;
		int x = 1;
		int y = 1;
		
		int[] xmove = {0, 0, -1, 1};
		int[] ymove = {-1, 1, 0, 0};
		String[] check = {"L", "R", "U", "D"};
		
		for(int i=0;i<length;i++) {
			String temp = commandArr[i];
			
			int tempX=0;
			int tempY=0;
			
			for(int j=0; j<check.length;j++) {
				if(check[j].equals(temp)) {
					tempX = x + xmove[j];
					tempY = y + ymove[j];
					
					break;
				}
			}
			
			if(tempX<1 || tempX > num || tempY<1 || tempY>num) {
				continue;
			}
			
			x= tempX;
			y= tempY;
		}
		
		System.out.println(x+" "+y);
		
	}

}
