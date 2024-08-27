package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 메모리 14188KB, 시간 104ms

public class BOJ_터렛_김종명 {

	static int testCase;
	static int joX;
	static int joY;
	static int joR;
	static int backX;
	static int backY;
	static int backR;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 입력
			joX = Integer.parseInt(st.nextToken());
			joY = Integer.parseInt(st.nextToken());
			joR = Integer.parseInt(st.nextToken());
			backX = Integer.parseInt(st.nextToken());
			backY = Integer.parseInt(st.nextToken());
			backR = Integer.parseInt(st.nextToken());
			
			// 무한대
			if(joX == backX && joY == backY && joR == backR) {
					result.append("-1\n");
					continue;
			}
			
			// 큰 반지름
			int bigR = 0;
			int smallR = 0;
			if(joR >= backR) {
				bigR = joR;
				smallR = backR;
			}else {
				bigR = backR;
				smallR = joR;
			}
			
			double distance = getDistance();
			
			
			if(distance < bigR) {										// 거리가 큰 원 반지름보다 작을 때
				
				if(bigR - distance == smallR) {				// 한 점 만날때
					result.append("1\n");
					continue;
				}else if(bigR - distance < smallR) {		// 두 점 만날때
					result.append("2\n");
					continue;
				}else if(bigR - distance > smallR) {		// 안 만날때 
					result.append("0\n");
					continue;
				}
			}else if(distance == bigR) {							// 큰 원에 작은 원의 원점이 곂칠때
				result.append("2\n");
				continue;
			}else {																	// 거리가 큰 원 반지름보다 클 때				
				
				if(bigR + smallR == distance) {				// 한 점 만날때
					result.append("1\n");
					continue;
				}else if(bigR + smallR > distance) {		// 두 점 만날때
					result.append("2\n");
					continue;
				}else {																// 안 만날때
					result.append("0\n");
					continue;
				}
			}	
		}
		
		System.out.println(result);
	}
	
	static double getDistance() {
		double length = 0.0;
		
		int xDistance = Math.abs(joX - backX);
		int yDistance = Math.abs(joY - backY);
		
		length = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
		
		return length;
	}

}
