package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1027_고층건물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(st.nextToken());
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			int count = 0;
			double dd = Integer.MAX_VALUE;
			for(int j = i-1; j > -1; j--) {
				double d = (double)(a[i] - a[j])/(i-j);
				
				if(d < dd) {
					count++;
					dd = d; 
				}
			}
			
			dd = Integer.MAX_VALUE;
			for(int j = i+1; j < n; j++) {
				double d = (double)(a[i] - a[j])/(j - i);
				
				if(d < dd) {
					count++;
					dd = d; 
				}
			}
			
			if(count > result)
				result = count;
		}
		System.out.print(result);
	}
}
