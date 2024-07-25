package excercise;

import java.io.*;
import java.util.*;

public class Solution {
	
	static int t;
	static StringTokenizer st;
	static boolean flag;
	static StringBuilder sb = new StringBuilder();
	static String input;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			
			flag = true;
			
			st = new StringTokenizer(br.readLine());
			input = st.nextToken();
			
			int month = Integer.parseInt(input.substring(4, 6));
			int day = Integer.parseInt(input.substring(6));
			
			if(month < 1 || month > 12 || day < 1) {
				flag = false;
				
			} else {
				
				if(month == 2 && day > 28) {
					flag = false;
					
				} else if(month % 2 == 1) {
					
					if(month <= 7 && day > 31) {
						flag = false;
					}
					
					if(month > 7 && day > 30) {
						flag = false;
					}
				}
			}
			
			sb.append("#").append(i + 1).append(" ");
			
			
			if (!flag) {
				sb.append(-1);
				
			} else {
				
				for(int j = 0; j < 4; j++) {
					sb.append(input.charAt(j));
				}
				sb.append("/");
				
				for(int j = 4; j < 6; j++) {
					sb.append(input.charAt(j));
				}
				sb.append("/");
				
				for(int j = 6; j < 8; j++) {
					sb.append(input.charAt(j));
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}	
}
