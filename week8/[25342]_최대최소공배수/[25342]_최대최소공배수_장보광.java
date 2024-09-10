package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 메모리: 16136kb 시간: 132ms;
public class BOJ25342_최대최소공배수 {
	public static void main(String[] main) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int result = 1;
			// n <= 7 일 떼 경우는 하드 코딩으로 모두 구현 
			// 그 이상의 수 일 경우 짝수일 때와 홀수 일 때를 나눠서 구현
			if(n==3) result = 6;
			else if(n==4) result = 12;
			else if(n==5) result = 60;
			else if(n==6) result = 60;
			else if(n==7) result = 210;
			else if(n%2==0) {
				if(n%3!=0) {
					result = n * (n - 1) * (n - 3);
				}
				else {
					result = (n-1) * (n - 2) * (n - 3);  
				}
			}
			else {
				result = n*(n-1)*(n-2);
			}
			sb.append(result+"\n");
		}
		System.out.print(sb);
	}
}
