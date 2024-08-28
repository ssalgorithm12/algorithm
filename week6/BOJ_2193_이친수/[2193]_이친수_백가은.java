package algorithm;

import java.io.*;
import java.util.*;

public class 이친수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, cnt;
	static long[] dp;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		
		// n이 1이면 dp[2] 초기화하다 인덱스 초과 오류나므로 1일 때 예외처리
		if(n < 2) {
			System.out.println(1);
			return;
			
		} else {
			dp = new long[n + 1];
			dp[1] = 1;
			dp[2] = 1;
			
			for(int i = 3; i <= n; i++) {
				dp[i] = dp[i - 2] + dp[i - 1];
			}
			System.out.println(dp[n]);
		}
	}
}
