package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2799블라인드_임채준 {
	
	static char[][] window;
	static int[] ans;
	static int N, M;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		window = new char[5 * N +  1][5 * M + 1];
		ans = new int[5];
		
		for(int i = 0; i < 5 * N + 1; i++) {
			window[i] = br.readLine().toCharArray();
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {				
				if(window[5 * r + 1][5 * c + 1] == '.') {
					ans[0] += 1;
				} else if(window[5 * r + 1][5 * c + 1] == '*' && window[5 * r + 2][5 * c + 1] == '.') {
					ans[1] += 1;
				} else if(window[5 * r + 2][5 * c + 1] == '*' && window[5 * r + 3][5 * c + 1] == '.') {
					ans[2] += 1;
				} else if(window[5 * r + 3][5 * c + 1] == '*' && window[5 * r + 4][5 * c + 1] == '.') {
					ans[3] += 1;
				} else if(window[5 * r + 4][5 * c + 1] == '*') {
					ans[4] += 1;
				}    							
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 5; i++) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb.toString());
		
		
		

	}

}
