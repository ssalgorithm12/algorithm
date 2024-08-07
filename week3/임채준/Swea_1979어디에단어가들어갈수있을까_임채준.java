package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1979어디에단어가들어갈수있을까_임채준 {
	
	static int T;
	static int N;
	static int M;
	static int[][] map;
	static int count;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N + 2][N + 2];
			for(int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j < N + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			count = 0;
			for(int i = 1; i < N - M + 2; i++) {
				for(int j = 1; j < N + 1; j++) {
					if(map[i - 1][j] == 0 && map[i + M][j] == 0) {
						int sum = 0;
						for(int k = 0; k < M; k++) {
							sum += map[i + k][j];
						}
						if(sum == M) {
							count++;
						}
					}										
				}
			}
			for(int j = 1; j < N - M + 2; j++) {
				for(int i = 1; i < N + 1; i++) {
					if(map[i][j - 1] == 0 && map[i][j + M] == 0) {
						int sum = 0;
						for(int k = 0; k < M + 1; k++) {
							sum += map[i][j + k];
						}
						if(sum == M) {
							count++;
						}
					}										
				}
			}			
			System.out.println("#" + t + " " + count);
		}
	}
}