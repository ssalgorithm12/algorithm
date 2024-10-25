package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_14226_이모티콘 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int S, ans;
	static class P {
		// 현재 위치, 복붙 내용, 걸린 시간
		int n, c, cnt;
		
		public P (int n, int c, int cnt) {
			this.n = n;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		S = Integer.parseInt(br.readLine());
		
		bfs();
		
		System.out.println(ans);
	}
	
	static void bfs() {
		Queue<P> que = new LinkedList<>();
		visited = new boolean[1025][S+1];
		visited[0][0] = true;
		visited[1][1] = true;
		// 2에서 시작
		que.offer(new P (2, 1, 2));
		
		while (! que.isEmpty()) {
			P p = que.poll();
			
			if (p.n==S) {
				ans = p.cnt;
				return;
			}
			
			// 복붙값이 S를 넘거나 이미 방문한 지점이면 pass
			if (p.c > S || p.c < 0 || p.n > 1024 || p.n < 0 ||  visited[p.n][p.c]) continue;
			
			visited[p.n][p.c] = true;
			
			// 1. 화면 이모티콘 복사
			que.offer(new P (p.n, p.n, p.cnt+1));
			// 2. 복사한 이모티콘 추가
			que.offer(new P (p.n+p.c, p.c, p.cnt+1));
			// 3. 이모티콘 하나 삭제
			que.offer(new P (p.n-1, p.c, p.cnt+1));
			
		}
	}

}
