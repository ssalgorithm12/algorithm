package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1405_미친로봇 {
	
	static int n;
	static double E, W, S, N, ans;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		E = Double.parseDouble(st.nextToken())/100;
		W = Double.parseDouble(st.nextToken())/100;
		S = Double.parseDouble(st.nextToken())/100;
		N = Double.parseDouble(st.nextToken())/100;
		map = new int[2 * n + 1][2 * n + 1];
		dfs(n, n, 0, 1.0);
		System.out.println(ans);
	}

	static void dfs(int r, int c, int cnt, double poss) {
		if(cnt == n) {
			ans += poss;
			return;
		}
		map[r][c] = 1;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c  +dc[d];
			if(check(nr, nc) && map[nr][nc] == 0) {
				if(d == 0) dfs(nr, nc, cnt + 1, poss * N);
				if(d == 1) dfs(nr, nc, cnt + 1, poss * E);
				if(d == 2) dfs(nr, nc, cnt + 1, poss * S);
				if(d == 3) dfs(nr, nc, cnt + 1, poss * W);
			}			

		}
		map[r][c] = 0;
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < 2 * n + 1 && c >= 0 && c < 2 * n + 1;
	}

}
