package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 메모리 14180 KB, 시간 128ms

public class Boj_2564 {

	// 변수
	static int width; 					// 가로
	static int height;					// 세로
	static int marketCount;				// 상점의 개수
	static int[][] marketPosition;		// 시장 위치 저장 배열
	static int donggeun_X;				// 동근이 X 
	static int donggeun_Y;				// 동근이 Y
	static int[] dr = {0, -1, 0, 1};	// 시계방향 탐색 row
	static int[] dc = {-1, 0, 1, 0};	// 시계방향 탐색 col
	static int[] dcr = {0, 1, 0, -1};	// 반시계방향 탐색 row
	static int[] dcc = {-1, 0, 1, 0};	// 반시계방향 탐색 col
	
	/*
	 	2차원 배열을 사용해서 시장을 만날 때까지 동근이를 시계 방향과 반시계 방향으로 돌려서
	 	길이를 측정해보자
	*/

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());

		marketCount = Integer.parseInt(br.readLine());
		marketPosition = new int[marketCount][2];
		
		// 시장 위치 저장
		for(int i=0; i<marketCount; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());
			
			switch(direction) {
				case 1:
					marketPosition[i][0] = position;
					marketPosition[i][1] = 0;
					break;
				case 2:
					marketPosition[i][0] = position;
					marketPosition[i][1] = height;
					break;
				case 3:
					marketPosition[i][0] = 0;
					marketPosition[i][1] = position;
					break;
				case 4:
					marketPosition[i][0] = width;
					marketPosition[i][1] = position;
					break;
			}
		}
		
		// 동근이 위치 설정
		st = new StringTokenizer(br.readLine());
		int direction = Integer.parseInt(st.nextToken());
		int position = Integer.parseInt(st.nextToken());
		
		switch(direction) {
		case 1:
			donggeun_Y = 0;
			donggeun_X = position;
			break;
		case 2:
			donggeun_Y = height;
			donggeun_X = position;
			break;
		case 3:
			donggeun_Y = position;
			donggeun_X = 0;
			break;
		case 4:
			donggeun_Y = position;
			donggeun_X = width;
			break;
		}
		
		int totalLength = 0;
		// 시장거리 탐색
		for(int i=0; i<marketCount; i++) {
			// 시계 방향 탐색
			int current_X = donggeun_X;
			int current_Y = donggeun_Y;
			int market_X = marketPosition[i][0];
			int market_Y = marketPosition[i][1];
			
			int lengthClock = 0;
			
			// 탐색 시작 방향 설정
			int d = 0;
			switch(direction) {
			case 1:
				d = 2;
				break;
			case 2:
				d = 0;
				break;
			case 3:
				d = 1;
				break;
			case 4:
				d = 3;
				break;
			}
			
			// 시장을 만날 때까지 탐색 
			while(current_X != market_X || current_Y != market_Y) {
				if(current_X+dc[d] < 0 || current_X+dc[d] > width 
						|| current_Y+dr[d] < 0 || current_Y+dr[d] > height) {
					d = (d+1) % 4;
				}
				current_X += dc[d];
				current_Y += dr[d];
				lengthClock += 1;
			}
			
			// 반 시계 방향 탐색
			current_X = donggeun_X;
			current_Y = donggeun_Y;
			int lengthCounterClock = 0;
			switch(direction) {
				case 1:
					d = 0;
					break;
				case 2:
					d = 2;
					break;
				case 3:
					d = 1;
					break;
				case 4:
					d = 3;
					break;
			}
			
			// 시장을 만날 때까지 탐색
			while(current_X != market_X || current_Y != market_Y) {
				if(current_X+dcc[d] < 0 || current_X+dcc[d] > width 
						|| current_Y+dcr[d] < 0 || current_Y+dcr[d] > height) {
					d = (d+1) % 4;
				}
				current_X += dcc[d];
				current_Y += dcr[d];
				lengthCounterClock += 1;
			}
			
			// 최솟값 더해주기
			totalLength += Math.min(lengthClock, lengthCounterClock);
		}
		
		System.out.println(totalLength);
	}

}
