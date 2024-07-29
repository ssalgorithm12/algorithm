package Study;

import java.util.Scanner;

public class Swea_파리퇴치_임채준 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] ans = new int[t];
		
		for (int test = 0; test < t; test++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] map = new int[n][n];
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					int sum = 0;

					for (int a = 0; a < m; a++) {
						for (int b = 0; b < m; b++) {
							sum += map[i + a][j + b];
						}
					}

					if (sum > max) {
						max = sum;
					}
					ans[test] = max;
				}
			}	
		}
		for(int i = 0; i < t; i++) {
			System.out.println("#" + (i + 1) + " " + ans[i]);
		}
		sc.close();
	}
}