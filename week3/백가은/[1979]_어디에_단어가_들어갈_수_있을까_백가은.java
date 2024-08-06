package study;

import java.io.*;
import java.util.*;

public class 어디에_단어가_들어갈_수_있을까 {
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int[][] map;
	static int T;
	static int size, len;
	static int ans;
	static int cntR, cntC;
	
	public static void main(String[] args) throws IOException   {
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			size = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());
			
			map = new int[size][size];
			ans = 0;
			
			for(int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < size; i++) {
				int cntR = 0;
				int cntC = 0;
				for(int j = 0; j < size; j++) {
					
					if(map[i][j] == 0) {
						if(cntR == len) {
							ans++;
						}
						cntR = 0;
					} else {
						cntR++;
					}
					
					if(map[j][i] == 0) {
						if(cntC == len) {
							ans++;
						}
						cntC = 0;
					} else {
						cntC++;
					}
				}
				
				if(cntR == len) {
					ans++;
				}
				
				if(cntC == len) {
					ans++;
				}
				
				
			}
		
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

}
