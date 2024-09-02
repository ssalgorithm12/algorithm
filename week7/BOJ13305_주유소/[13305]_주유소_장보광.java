package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea13305_주유소 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dist = new long[n];
		long[] price = new long[n];
		long result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n; i++) dist[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) price[i] = Integer.parseInt(st.nextToken());
		long min = price[0];
		
		for(int i = 1; i < n; i++) {
			result += (min * dist[i]);
			if(min > price[i]) min = price[i];
		}
		
		System.out.print(result);
		
	}
}
