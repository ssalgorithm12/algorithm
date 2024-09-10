package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boj_25342_최대최소공배수 {

	static int testCase;
	static int N;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			N = Integer.parseInt(br.readLine());
			
			long ans = 0;
			
			if(N % 2 == 1) {
				long A = N;
				long B = N - 1;
				long C = N - 2;
				
				ans = A * B * C;
			}else {
				if(N % 3 == 0) {
					long A = N - 1;
					long B = N - 2;
					long C = N - 3;
					ans = A * B * C;
				}else {
					long A = N;
					long B = N - 1;
					long C = N - 3;
					ans = A * B * C;
				}
			}
			
			result.append(ans + "\n");
		}
		System.out.println(result);
	}	
	
}
