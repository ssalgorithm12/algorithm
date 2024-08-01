package test;

import java.util.Scanner;


class Solution_1954 {
	public static void main(String args[]) throws Exception{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int[] dr= {0,1,0,-1};
        int[] dc= {1,0,-1,0};
		
		for(int test_case = 1; test_case <= T; test_case++){
			int r = 0;
	        int c = 0;
			int N=sc.nextInt();
//			int n = N-1;
            int [][] snails = new int[N][N];
            int d = 0;
            int cnt = 1;
            for(int i = 0; i < N; i++) {
            	for(int j = 0; j < N; j++) {
            		snails[r][c] = cnt;
            		int nr = r + dr[d];
        			int nc = c + dc[d];
            		if(nc >= N || nc < 0 || nr >= N || nr < 0 || snails[nr][nc] != 0) {
            			d = (d+1)%4;
            			r = r + dr[d];
            			c = c + dc[d];
            		} else {
            			r = nr;
            			c = nc;
            		}
            		cnt++;
            	}
            }
            System.out.printf("#%d\n", test_case);
            for (int[] snail : snails) {
				for (int i = 0; i < N; i++) {
					System.out.printf("%d ", snail[i]);
				}
				System.out.println();
			}
		}
	}
}
