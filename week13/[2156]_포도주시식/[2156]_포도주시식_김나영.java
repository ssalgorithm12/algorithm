package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2156_포도주시식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans;
    static int[] arr, dp;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int [N+1];
		dp = new int [N+1];
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		
		if (N >= 2) dp[2] = arr[2] + arr[1];
		
		for (int i = 3; i < N+1; i++) {
			dp[i] = arr[i] + Math.max(dp[i-2], dp[i-3] + arr[i-1]);
			dp[i] = Math.max(dp[i], dp[i-1]);
		}
		
		ans = dp[N];
		
		System.out.println(ans);
		
	}

}

//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class boj_2156_포도주시식 {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//    static int N, ans;
//    static int[] arr, dp;
//    static boolean[] visited;
//	public static void main(String[] args) throws Exception {
//		N = Integer.parseInt(br.readLine());
//		arr = new int [N];
//		dp = new int [N];
//		visited = new boolean [N];
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//			dp[i] = arr[i];
//		}
//		ans = dp[0];
//		
//		for (int i = 1; i < N; i++) {
//			if (i == 1) {
//				dp[i] += dp[0];
//			} else if (i==2) {
//				dp[i] += Math.max(arr[i-2], arr[i-1]);
//			} else {
//				dp[i] += Math.max(dp[i-2], dp[i-3] + arr[i-1]);
//			}
//			ans = Math.max(dp[i], ans);
//		}
//		
//		System.out.println(ans);
//		
//	}
//
//}