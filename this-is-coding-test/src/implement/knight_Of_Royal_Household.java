package implement;

import java.util.Scanner;

public class knight_Of_Royal_Household {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		char tempx = str.charAt(0);
		char tempy = str.charAt(1);
		int count = 0;
		
		int x=tempx-96;
		int y=Integer.parseInt(String.valueOf(tempy));
		
		int[] actionX = {-2, -2, 2, 2, -1, 1, -1, 1};
		int[] actionY = {-1, 1, -1, 1, -2, -2, 2, 2};
		
		int tempXX = 0;
		int tempYY = 0;
		for(int i=0; i<actionX.length;i++) {
			tempXX = x + actionX[i];
			tempYY = y + actionY[i];
			
			if(tempXX<=8 && tempXX>=1 && tempYY<=8 && tempYY>=1) {
				count++;
			}
		}
		System.out.println(count);
	}
}
