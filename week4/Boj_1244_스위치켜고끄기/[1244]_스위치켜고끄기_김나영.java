package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1244_스위치켜고끄기_김나영 {

	static int T, N, g, n;
	static int[] switches;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		switches = new int[T];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < T; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생의 숫자
		N = Integer.parseInt(br.readLine());
		
		// 학생의 숫자만큼 받고 거기서 스위치의 상태를 바로 변경
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			g = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken()) - 1;
			
			// 남자일 경우
			if (g == 1) {
				for (int j = n; j < T; j+=n+1) {
					if (switches[j]==1) switches[j] = 0;
					else switches[j] = 1;
				}
			// 여자일 경우
			} else {
				for (int j = 0; j < T; j++) {
					if (in_range(n-j, n+j, T)) {
						if (switches[n-j] == switches[n+j]) {
							if (switches[n-j]==1) {
								switches[n-j] = 0;
								switches[n+j] = 0;
							}else {
								switches[n-j] = 1;
								switches[n+j] = 1;
							}
						}else break;
					} else break;
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			System.out.print(switches[i] + " ");
			if((i+1)%20 == 0) System.out.println();
		}
		
	}

	public static boolean in_range(int n, int n2, int N) {
		if (n >= 0 && n < N && n2 >= 0 && n2 < N) return true;
		return false;
	}
	
}