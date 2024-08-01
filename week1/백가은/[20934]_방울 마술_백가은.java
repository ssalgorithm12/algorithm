package excercise;

import java.io.*;
import java.util.*;

public class Solution {
	
	static int t;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int at;
	
	static String input;
	static int k;
	
	static int ans;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			
			sb.append("#").append(i+ 1).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			input = st.nextToken();
			for(int j = 0; j < 3; j++) {
				if(input.charAt(j) == 'o') {
					at = j;
				}
			}
			k = Integer.parseInt(st.nextToken());
			
			if(k == 0) {
				ans = at;
				
			} else {
				
				if(at == 1) {
					if(k % 2 == 1) {
						ans = 0;
					} else ans = 1;
					
				} else {
					if(k % 2 == 0) {
						ans = 0;
					} else ans = 1;
				}
				
			}
			
			sb.append(ans);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}	
}
