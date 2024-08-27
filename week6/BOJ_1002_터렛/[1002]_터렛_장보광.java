package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 메모리; 14652kb, 시간: 104ms
public class BOJ1002_터렛 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스  
		for(int t = 1; t <=T; t++) {
			// 입력 
			st = new StringTokenizer(br.readLine());
			int result = 0;
			int[] a = new int[6];
			for(int i = 0; i < 6; i++) a[i] = Integer.parseInt(st.nextToken());
			
			// 거리 계산 
			double distance = (a[0] - a[3])*(a[0] - a[3]) + (a[1] - a[4])*(a[1] - a[4]); // 두 아군 사이의 지점
			int r = (a[2] + a[5])*(a[2] + a[5]); // 적군 까지의 거리합 제곱 
			int r1 = (a[2] - a[5])*(a[2] - a[5]); // 거리차 제곱
			
			//두 거리의 합이 두 지점 사이의 거리차보다 클 때 
			if(r > distance) {
				// 두 거리차가 0이 아닐 때 
				if(a[5] - a[2] != 0) {
					if(r1 < distance) result =2;
					else if(r1 == distance) result = 1;
				}	
				else result = 2;
			}
			// r1, r2 거리의 합과 두 지점 사이의 거리가 같을 때
			if(r==distance) result = 1;
			//두 지점이 같을 때 
			if(a[0] == a[3]&&a[1] == a[4]) {
				// 거리가 같으면 무한대, 아니면 0
				if(a[2] == a[5]) result = -1;
				else result = 0;
			}
			sb.append(result+"\n");
		}
		System.out.print(sb);
	}
}
