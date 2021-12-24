package implement;

import java.util.Scanner;

public class game_Development {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      
      // 맵 크기 입력
      int N = sc.nextInt();
      int M = sc.nextInt();
      
      // 캐릭터 현재 위치 입력
      int curPosN = sc.nextInt();
      int curPosM = sc.nextInt();
      
      // 캐릭터 현재 방향 입력
      int curDirect = sc.nextInt();
      
      // 캐릭터가 방문한 칸의 수
      int count = 1;
      
      // 맵 변수 (육지 : 0, 바다 : 1, 이미 가봤던 칸 : 2)
      int[][] map = new int[N][M];
      
      // 맵 지형 입력
      for(int i=0;i<N;i++) {
         for(int j=0;j<M;j++) {
            map[i][j] = sc.nextInt();
         }
      }
            
            
      // 방향에 따른 칸 확인 
      // ex) 북쪽 방향에서 왼쪽 칸은 현재 위치에서 -1이 되야함
      // checkPosN[0] = 0, checkPosM[0] = -1. 즉, 칸만 현재 위치에서 -1이 됨
      int[] checkPosN = {0,1,0,-1};
      int[] checkPosM = {-1,0,1,0};
      
      // 임시 위치 변수
      int tempN = 0;
      int tempM = 0;
      
      // 무한 반복
      while(true) {
         // 캐릭터 기준 네 방향 모두 가본 곳이면 false. 아니면 true
         boolean flag = false;
         
         // 네 방향을 확인하기 위해 4번 반복
         for(int i=0;i<4;i++) {
            // 현재 바라보고 있는 방향 기준으로 반시계 방향으로 체크(배열에 이미 반시계방향으로 정렬되어있음)
            // 북쪽 : 0, 동쪽 : 1, 서쪽 : 2, 남쪽 : 3
            tempN = curPosN + checkPosN[curDirect];
            tempM = curPosM + checkPosM[curDirect];
            
            // 임시 위치가 바다가 아니거나 가보지 않은 경우 flag를 true로 설정 후 반복문 탈출
            if(map[tempN][tempM] == 0) {
               flag = true;
               break;
            }
            
            //아니라면 캐릭터 현재 방향을 반시계방향으로
            curDirect++;
            // 방향은 0(북),1(동),2(서),3(남) 만 존재하므로 4로 올라간 경우에 0으로 변수 설정
            if(curDirect == 4) {
               curDirect = 0;
            }
         }
         
         // 위 반복문에서 갈 수 있는 곳이 있다는 flag가 true라면
         if(flag) {
            // 캐릭터 현재 위치를 임시 위치로 설정
            curPosN = tempN;
            curPosM = tempM;
            
            // 해당 칸은 방문했다를 표시 (0:육지, 1:바다, 2:방문) 
            // 2 변수는 해당 문제에 없고, 필자가 추가함
            map[tempN][tempM] = 2;
            
            // 방문한 칸 증가
            count ++;
         }
         // 갈 수 있는 곳이 없는 경우 
         else {
            // 현재 방향 기준 뒤에 있는 칸으로 가려면 방향을 90도 왼쪽으로 틀고
            curDirect++;
            if(curDirect == 4) {
               curDirect = 0;
            }
            
            // 위에서 하던 것처럼 임시 칸 확인
            tempN = curPosN + checkPosN[curDirect];
            tempM = curPosM + checkPosM[curDirect];
            
            // 임시 칸이 바다(1)이라면 무한 반복문 탈출 및 count 변수 출력
            if(map[tempN][tempM]==1) {
               break;
            }
            // 바다가 아니면 
            else {
               // 캐릭터 현재 위치를 임시 위치로 설정
               curPosN = tempN;
               curPosM = tempM;
            }
         }
      }
      
      System.out.println(count);
   
   }

}