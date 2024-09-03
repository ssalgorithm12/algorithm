package algorithm;

import java.io.*;
import java.util.*;

public class 어린왕자 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int T, x1, y1, x2, y2, n, cnt;
	
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			cnt = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				 
				double distToS = Math.sqrt(Math.pow(cx - x1, 2) + Math.pow(cy - y1, 2));
				double distToE = Math.sqrt(Math.pow(cx - x2, 2) + Math.pow(cy - y2, 2));
				
				if(r > distToS && r > distToE) continue;
				
				if(r > distToS) cnt++;
				if(r > distToE) cnt++;
			}
			System.out.println(cnt);
		}
	}
}
