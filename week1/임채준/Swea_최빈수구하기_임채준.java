package Study;

import java.util.Scanner;

public class Swea_최빈수구하기_임채준 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] ans = new int[t];
		
		for(int i = 0; i < t; i++) {
			
			int[] map = new int[101];
			int tt = sc.nextInt();
		
			for(int j = 0; j < 1000; j++) {
				int score = sc.nextInt();
				map[score]++;
			}
			
			int maxFreq = 0;
			int mode = 0;
			for(int k = 0; k < 101; k++) {
				if(map[k] >= maxFreq) {
					maxFreq = map[k];
					mode = k;
				}
			}
			ans[i] = mode;
		}
			
		for(int i = 0; i < t; i++) {
			System.out.println("#"+(i+1)+" "+ans[i]);
		}
		sc.close();
	}
}
