package algorithm;

import java.io.*;
import java.util.*;

// 36024kb, 356ms
public class 주유소 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static long n, min, ans;
	static long[] dist, cost;
	
	public static void main(String[] args) throws IOException {
		
		n = Long.parseLong(br.readLine());
		
		dist = new long[(int) (n - 1)];
		cost = new long[(int) n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		// 현재까지 위치에서 살 수 있는 가장 싼 가격이 현재 내가 구매할 수 있는 최저가
		// 현재까지의 최소값으로 구매
		min = Long.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n - 1; i++) {
			min =  Math.min(min, Long.parseLong(st.nextToken()));
			ans += dist[i] * min;
		}
		
		st.nextToken();
		
		System.out.println(ans);
	}
}

