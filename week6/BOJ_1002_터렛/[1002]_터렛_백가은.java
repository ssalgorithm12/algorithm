package algorithm;

import java.io.*;
import java.util.*;

public class 터렛 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T, x1, y1, x2, y2, r1, r2, ans;

	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			double dist = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
			
			
			if(x1 == x2 && y1 == y2 && r1 == r2) {
				ans = -1;
				
			} else if(dist > r1 + r2 || dist + Math.min(r1,  r2) < Math.max(r1, r2)) {
				ans = 0;
				
			} else if(dist == r1 + r2 || dist + Math.min(r1,  r2) == Math.max(r1, r2)) {
				ans = 1;
				
			} else ans = 2;
			
			System.out.println(ans);
			
		}

	}

}
