package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 학생 클래스 선
class Student {
	String name;
	int score;
	
	public Student(String name, String score) {
		this.name = name;
		this.score = Integer.parseInt(score);
	}
}

public class print_student_order_by_score_asc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// 학생 클래스로 된 리스트 선
		ArrayList<Student> list = new ArrayList<>();
		
		int num = sc.nextInt();
		sc.nextLine();
		
		for(int i =0; i<num; i++) {
			String temp = sc.nextLine();
			String[] tempArr = temp.split(" ");
			
			Student sd = new Student(tempArr[0], tempArr[1]);
			list.add(sd);
		}

		sc.close();
		
		// 삽입 정렬 방식을 이용하여 점수순으로 정렬 
		for(int i=0;i<list.size();i++) {
			for(int j=i; j>0; j--) {
				if(list.get(j).score < list.get(j-1).score) {
					Collections.swap(list,j, j-1);
				}
				else {
					break;
				}
			}
		}
		
		// 출력 
		for(int i =0; i<num; i++) {
			System.out.print(list.get(i).name + " ");
		}
		
	}
	
}
