package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_2193 {

	static int N;
	static long[] memo;
	
	// 피보나치
	// 숫자 범위 int 벗어남
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		if(N < 3) {
			System.out.println(1);
			return;
		}
		
		memo = new long[N+1];
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 1;
		
		for(int i=3; i<=N; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		
		System.out.println(memo[N]);
		
	}
}
