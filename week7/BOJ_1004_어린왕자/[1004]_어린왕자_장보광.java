package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리: 16080kb 시간: 152ms;

public class BOJ1004_어린왕자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] x = new int[2];
		int[] y = new int[2];
		int[][] planet;
		int count;
		int[] check;
		
		for(int t = 1; t <= T; t++) {
			count = 0;
			st = new StringTokenizer(br.readLine());
			// 출발 지점과 도착 지점 입력
			for(int i = 0; i < 2; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			int n = Integer.parseInt(br.readLine());
			planet = new int[n][3]; // 행성계 저장
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 3; j++) planet[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < n; i++) {
				check = new int[2];
				for(int j = 0; j < 2; j++) {
					int length = (planet[i][0] - x[j])*(planet[i][0] - x[j]) + (planet[i][1] - y[j])*(planet[i][1] - y[j]);
					if(length < planet[i][2]*planet[i][2]) check[j] = 1;
				}	
				count+= (check[0] ^ check[1]);
			}
			sb.append(count+"\n");
		}
		System.out.print(sb);
	}
}
