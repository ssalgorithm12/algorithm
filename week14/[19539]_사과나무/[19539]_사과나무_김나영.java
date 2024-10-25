package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_19539_사과나무 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, n, sum1, sum2;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			sum1 += n;
			sum2 += n/2;
		}
		
		
		if (sum1%3>0 || sum2 < sum1/3) System.out.println("NO");
		else System.out.println("YES");
	}

}
