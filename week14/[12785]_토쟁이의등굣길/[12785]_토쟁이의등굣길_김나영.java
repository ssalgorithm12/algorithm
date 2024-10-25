//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class boj_12785 {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//    static int w, h, x, y, f, sum1, sum2, ans;
//    static boolean [][] visited;
//    static int [] dr = {-1, 0, 1, 0};
//    static int [] dc = {0, -1, 0, 1};
//	public static void main(String[] args) throws Exception {
//		
//		st = new StringTokenizer(br.readLine());
//		w = Integer.parseInt(st.nextToken());
//		h = Integer.parseInt(st.nextToken());
//		
//		st = new StringTokenizer(br.readLine());
//		x = Integer.parseInt(st.nextToken());
//		y = Integer.parseInt(st.nextToken());
//		
//		visited = new boolean [w][h];
//		visited[0][0] = true;
//		
//		f = h - x + w - y;
//		
//		
//		dfs1(0, 0, 0);
//		dfs2(x-1, y-1, 0);
//		
//		ans = sum1 * sum2;
//		System.out.println(ans);
//		
//	}
//	
//	static void dfs1(int r, int c, int cnt) {
//		if (cnt==(x-1)+(y-1)) {
//			if (r == x-1 && c == y-1) sum1++;
//			return;
//		}
//		
//		for (int i = 0; i < 4; i++) {
//			int nr = r + dr[i];
//			int nc = c + dc[i];
//			if (check(nr, nc) && !visited[nr][nc]) {
//				visited[nr][nc] = true;
//				dfs1(nr, nc, cnt+1);
//				visited[nr][nc] = false;
//			}
//		}
//	}
//	
//	static void dfs2(int r, int c, int cnt) {
//		if (cnt==f) {
//			if (r == w-1 && c == h-1) sum2++;
//			return;
//		}
//		
//		for (int i = 0; i < 4; i++) {
//			int nr = r + dr[i];
//			int nc = c + dc[i];
//
//			if (check(nr, nc) && !visited[nr][nc]) {
//				visited[nr][nc] = true;
//				dfs2(nr, nc, cnt+1);
//				visited[nr][nc] = false;
//			}
//		}
//	}
//
//	static boolean check(int r, int c) {
//		return r >= 0 && r < w && c >= 0 && c < h;
//	}
//}

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12785_토쟁이의등굣길_김나영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int w, h, x, y, f;
    static long sum1, sum2, ans;
    static long [][] dp;
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		dp = new long [w][h];
		
		f = h - x + w - y;

		sum1 = find(x-1, y-1);
		sum2 = find(w - x, h - y);
		
		System.out.println((sum1 * sum2) % 1000007);
		
	}
	
	static long find(int r, int c) {
		// dp 배열 초기화
		dp = new long [w][h];
		
		for (int nr = 0; nr <= r; nr++) {
			for (int nc = 0; nc <= c; nc++) {
				if (nr == 0 && nc == 0) dp[nr][nc] = 1;
				else {
					long n1 = (nr>0) ? dp[nr-1][nc] : 0;
					long n2 = (nc>0) ? dp[nr][nc-1] : 0;
					dp[nr][nc] = (n1 + n2) % 1000007;
				}
			}
		}
		return dp[r][c];
	}


	static boolean check(int r, int c) {
		return r >= 0 && r < w && c >= 0 && c < h;
	}
}