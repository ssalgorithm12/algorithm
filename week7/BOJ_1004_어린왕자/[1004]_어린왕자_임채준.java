package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1004_어린왕자 {
	
	static int T, N;
	static int[] start;
	static int[] end;
	static int[][] sols;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new int[2];
			end = new int[2];
			for(int i = 0; i < 2; i++) {
				start[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < 2; i++) {
				end[i] = Integer.parseInt(st.nextToken());
			}
			N = Integer.parseInt(br.readLine());
			sols = new int[N][3];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 3; j++) {
					sols[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for(int i = 0; i < N; i++) {
				double dis = Math.sqrt(Math.pow(start[0] - sols[i][0], 2) + Math.pow(start[1] - sols[i][1], 2));
				if((double)sols[i][2] >= dis) count++;
			}
			for(int i = 0; i < N; i++) {
				double dis = Math.sqrt(Math.pow(end[0] - sols[i][0], 2) + Math.pow(end[1] - sols[i][1], 2));
				if((double)sols[i][2] >= dis) count++;
			}
			for(int i = 0; i < N; i++) {
				double dis1 = Math.sqrt(Math.pow(start[0] - sols[i][0], 2) + Math.pow(start[1] - sols[i][1], 2));
				double dis2 = Math.sqrt(Math.pow(end[0] - sols[i][0], 2) + Math.pow(end[1] - sols[i][1], 2));
				if((double)sols[i][2] > dis1 && (double)sols[i][2] > dis2) count -= 2;
			}
			System.out.println(count);
		}
		
	}
	
}
