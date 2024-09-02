package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리: 36360kb 시간: 364ms

public class BOJ13305_주유소 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dist = new long[n]; //거리를 저장하는 배열
		long[] price = new long[n]; // 가격을 저장하는 배열 
		// 결과를 저장하는 변수 
		long result = 0;
		
		// 거리&주유비 입력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n; i++) dist[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) price[i] = Integer.parseInt(st.nextToken());
		long min = price[0];
		
		// 주유비 계산 
		for(int i = 1; i < n; i++) {
			result += (min * dist[i]);
			if(min > price[i]) min = price[i];
		}
		
		// 결과 출력 
		System.out.print(result);
		
	}
}
