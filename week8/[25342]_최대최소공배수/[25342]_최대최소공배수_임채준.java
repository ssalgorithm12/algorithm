package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj_25342_임채준 {
	
	public static void main(String[] main) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			long mul = 1;

			if(n==3) mul = 6;
			else if(n==4) mul = 12;
			else if(n==6) mul = 60;
			else if(n%2==0) {
				if(n%3!=0) {
					mul = (long) n * (n - 1) * (n - 3);
				}
				else {
					mul = (long) (n-1) * (n - 2) * (n - 3);  
				}
			}
			else {
				mul = (long) n*(n-1)*(n-2);
			}
			sb.append(mul+"\n");
		}
		System.out.print(sb);
	}
}