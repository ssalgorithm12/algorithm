package boj;

// 17140KB, 140ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012_유기농배추 {
	
	static int T, N, M, K;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int g;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			g = 1;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						bfs(i, j, ++g);
					}
				}			
			}
			System.out.println(g - 1);
		}
	}

	static void bfs(int sr, int sc, int group) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {sr, sc});
		map[sr][sc] = group;
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == 1) {
					que.offer(new int[] {nr, nc});
					map[nr][nc] = group;
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < M && c >= 0 && c < N;
	}

}
