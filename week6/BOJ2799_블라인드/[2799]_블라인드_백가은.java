package algorithm;

import java.io.*;
import java.util.*;

public class 블라인드 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int window, stair;
	static int[] ans;
	static int[][] type;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		stair = Integer.parseInt(st.nextToken());
		window = Integer.parseInt(st.nextToken());
		type = new int[stair][window];
		ans = new int[5];
		
		for(int i = 0; i < stair * 5 + 1; i++) {
			String windowInfo = br.readLine();
			
			if(i % 5 != 0) {
				for(int j = 1; j < window * 5 + 1; j+=5) {
					if(windowInfo.charAt(j) == '*') {
						type[i / 5][j / 5]++;
						
					}
				}
			}
		}
		for(int i = 0; i < stair; i++) {
			for(int j = 0; j < window; j++) {
				ans[type[i][j]]++;
			}
			
		}
		for(int a : ans) {
			System.out.print(a + " ");
		}
		
	}

}
