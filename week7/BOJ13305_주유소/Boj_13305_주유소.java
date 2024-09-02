package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13305_주유소 {
	
	static int N;
	static int[] dis;
	static int[] price;
	static int sum;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dis = new int[N - 1];	
		for(int i = 0; i < N - 1; i++) {
			dis[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		price = new int[N - 1];
		for(int i = 0; i < N - 1; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		int start = N - 2;
		sum = 0;
		while(start >= 0) {
			int tidx = findmin(start);
			for(int j = start; j >= tidx; j--) {
				sum += price[tidx] * dis[j];
			}
			start = tidx - 1;
		}
		System.out.println(sum);
		

	}
	
	static int findmin(int idx) {
		int minidx = N;
		int pmin = Integer.MAX_VALUE;	 
		for(int i = idx; i >= 0; i--) {
			if(price[i] <= pmin) {
				pmin = price[i];
				minidx = i;
			}
		}
		return minidx;
	}

}
