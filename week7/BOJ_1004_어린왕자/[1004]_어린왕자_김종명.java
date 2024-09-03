package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1004_어린왕자 {

	// 입력
	static int testCase;
	static int startY, startX, finishY, finishX;
	static int planetCount;
	
	// 출력
	static int count;
	static StringBuilder result = new StringBuilder();
	
	// 행성계가 출발점이나 도착점을 감싸고 있을 경우에만 +1
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			startY = Integer.parseInt(st.nextToken());
			startX = Integer.parseInt(st.nextToken());
			finishY = Integer.parseInt(st.nextToken());
			finishX = Integer.parseInt(st.nextToken());
			planetCount = Integer.parseInt(br.readLine());
			// 횟수
			count = 0;
			
			// 행성 입력 받기
			for(int i=0; i<planetCount; i++) {
				st = new StringTokenizer(br.readLine());
				
				// 행성 중심과 반지름
				int planetY = Integer.parseInt(st.nextToken());
				int planetX = Integer.parseInt(st.nextToken());
				int planetR = Integer.parseInt(st.nextToken());
				
				// 시작점과 중심의 거리 
				double startDistance = getDistance(startY, startX, planetY, planetX);
				
				// 도착점과 중심의 거리
				double finishDistance = getDistance(finishY, finishX, planetY, planetX);
				
				if(startDistance < planetR && finishDistance < planetR) {
					// 행성이 연관없음
					continue;
				}else if(startDistance < planetR && finishDistance > planetR) {
					// 행성이 시작점을 감싸고 있음 
					count += 1;
				}else if(startDistance > planetR && finishDistance < planetR) {
					// 행성이 도착점을 감싸고 있음
					count += 1;
				}		
			}
			
			result.append(count + "\n");
		}
		System.out.println(result);
	}

	// 두 점 사이의 거리 구해줘
	static double getDistance(int y, int x, int a, int b) {
		double result = 0;
		
		int yGap = y - a;
		int xGap = x - b;
		
		result = Math.sqrt(Math.pow(yGap, 2) + Math.pow(xGap, 2));
		return result;
	}
	
}
