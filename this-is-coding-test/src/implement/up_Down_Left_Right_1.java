package implement;

import java.util.Scanner;

public class up_Down_Left_Right_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		String command = sc.nextLine();
		
		String[] commandArr = command.split(" ");
		int length = commandArr.length;
		int x = 1;
		int y = 1;
		
		for(int i=0;i<length;i++) {
			String temp = commandArr[i];
			if((y == 1 && temp.equals("L")) || (y == num && temp.equals("R")) 
					|| (x == 1 && temp.equals("U")) || (x == num && temp.equals("D"))) {
				continue;
			}else {
				if(temp.equals("L")) {
					y--;
				}
				else if(temp.equals("R")) {
					y++;	
				}
				else if(temp.equals("U")) {
					x--;
				}
				else if(temp.equals("D")) {
					x++;			
				}
			}
		}
		
		System.out.println(x+" "+y);
		
	}

}
