import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class boj_2368_치즈_김나영 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, cheese, t;
	static int [][] map, air;
	//				   상 좌 하 우
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
	    st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		
		for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c]==1) {
					cheese++;
				}
			}
		}
		
		while (cheese > 0) {
			bfs();
			t++;
		}
		System.out.println(t);
	}

	static void bfs() {
		Queue<P> que = new LinkedList<>();
		air = new int [N][M];
		// (0, 0)을 처음 que에 삽입
		que.offer(new P(0, 0));
		air[0][0] = -1;
		
		// while문이 한 번 돌면 t++;
		while(!que.isEmpty()) {
			P p = que.poll();
			
			// que에 들어간 좌표에서 poll 해 사방탐색
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				// 범위가 벗어났거나 이미 방문한 좌표면 continue
				if (!check(nr, nc) || air[nr][nc]==-1) continue;
				
				// 해당 부분이 치즈가 아니면 que에 넣음
				// 해당 부분이 치즈이고, 4방 중 2방이 공기와 접촉해 있으면 해당 좌표의 air에 ++;
				if (map[nr][nc]==1) air[nr][nc]++;
				else {
					que.offer(new P(nr, nc));
					air[nr][nc] = -1;
				}
				
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (air[r][c]>=2) {
					cheese--;
					map[r][c] = 0;
				}
			}
		}
		
	}	
	
	static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}


	public static class P {
		int r;
		int c;
		
		public P (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
}