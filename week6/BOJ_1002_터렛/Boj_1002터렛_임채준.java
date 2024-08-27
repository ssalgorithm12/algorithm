package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1002터렛_임채준 {
	
	static int T;
	static int x1;
	static int y1;
	static int x2;
	static int y2;
	static int r1;
	static int r2;
	static int loc[];
	static int count;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			loc = new int[6];
			for(int i = 0; i < 6; i++) {
				loc[i] = Integer.parseInt(st.nextToken());
			}
			
			x1 = loc[0];
			y1 = loc[1];
			r1 = loc[2];
			x2 = loc[3];
			y2 = loc[4];
			r2 = loc[5];
			
			int max = Math.abs(r1) + Math.abs(r2);
			
			count = 0;
			for(int i = -Math.abs(x1) - max; i < Math.abs(x2) + max; i++) {
				for(int j = -Math.abs(y1) - max; j < Math.abs(y2) + max; j++) {
					double dis1 = Math.sqrt(Math.pow(x1 - i, 2) + Math.pow(y1 - j, 2));
					double dis2 = Math.sqrt(Math.pow(x2 - i, 2) + Math.pow(y2 - j, 2));
					if(r1 == dis1 && r2 == dis2) {
						count++;
					}
				}
			}
			if(count >= 300000000) {
				System.out.println(-1);
			} else {
				System.out.println(count);
			}
						
		}

	}

}
