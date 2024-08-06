package study;

import java.io.*;
import java.util.*;

public class String_1213 {
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int t;
	static String input, target;
	static int len;

	public static void main(String[] args) throws IOException {
		
		for(int tc = 0; tc < 10; tc++) {
			t = Integer.parseInt(br.readLine());
			sb.append("#").append(t).append(" ");
			
			target = br.readLine();
			input = br.readLine();
			
			len = target.length();
			int cnt = 0;
			
			for(int i = 0; i <= input.length() - len; i++) {
				if(input.substring(i, i + len).equals(target)) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}
