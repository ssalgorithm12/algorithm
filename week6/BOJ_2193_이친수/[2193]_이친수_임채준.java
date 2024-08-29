package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boj_2193이친수_임채준 {

	static int N;
	static long[] fibo;

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		if(N < 3) {
			System.out.println(1);
			return;
		}
		
		fibo = new long[N+1];
		fibo[0] = 0;
		fibo[1] = 1;
		fibo[2] = 1;
		
		for(int i=3; i<=N; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		System.out.println(fibo[N]);
		
	}
}