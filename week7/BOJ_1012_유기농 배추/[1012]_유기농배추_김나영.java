import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;


// 메모리 : 16608	KB	시간 : 148 MS
public class boj_1012_유기농배추 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M, K, cabbage;
    static int [][] map;
    static boolean [][] visited;
    //					상 우 하 좌
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    static class P{
    	int r;
    	int c;
    	public P(int r, int c) {
    		this.r = r;
    		this.c = c;
    	}
    }
    static Queue<P> que;
    static P [] cabbages;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int [N][M];
			visited = new boolean [N][M];
			cabbages = new P [K];
			cabbage = 0;
			
			// map에 배추의 위치를 추가
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
				cabbages[i] = new P(r, c);
			}
			
			bfs();

			System.out.println(cabbage);
		}
	}
	
	static void bfs() {
		que = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			if (visited[cabbages[i].r][cabbages[i].c]) continue;
			que.offer(cabbages[i]);
			while (!que.isEmpty()) {
				P p = que.poll();
				if (visited[p.r][p.c]) continue;
				visited[p.r][p.c] = true;
				for (int d = 0; d < 4; d++) {
					// 배추 위치의 상우하좌 탐색
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					
					// 해당 위치에서 상우하좌에 배추가 있으면 que에 삽입
					if (in_range(nr, nc) && map[nr][nc]==1) {
						que.offer(new P(nr, nc));
					}
				}
			}
			cabbage++;
		}
	}

	static boolean in_range(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
	
}
