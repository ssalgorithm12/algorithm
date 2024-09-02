import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2573_빙산_김나영 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Deque<P> deque = new ArrayDeque<P>();
	static int N, M, cnt, ice, t;
	static int [][] map, isMelt;
	//					상 우 하 좌
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	static boolean [][] visited;
	static boolean isS;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c]!=0) {
					deque.offer(new P(r, c));
					ice++;
				}
			}
		}
		
		do {
			t++;
		} while(bfs());
		System.out.println(t);
	}
	
	static boolean bfs() {
		cnt = 0;
		isMelt = new int [N][M];
		for (int m = 0; m < ice; m++) {
			P p = deque.poll();
			// 녹을 얼음을 계산
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				
				if (map[nr][nc]==0) {
					map[p.r][p.c]--;
				}
			}
			if (map[p.r][p.c]<=0) {
				map[p.r][p.c] = 0;
			} else {
				deque.offer(p);
				cnt++;
			}
		}
		
		ice -= cnt;
		visited = new boolean [N][M];
		
		for (int m = 0; m < ice; m++) {
			P p = deque.poll();
			isS = false;
			
			visited[p.r][p.c] = true;
			
			// 4방으로 연결되어 있는지 계산
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (visited[nr][nc]) continue;
				
				if (map[nr][nc]!=0) {
					isS = true;
					deque.addFirst(new P(nr, nc));
				}
			}
			if (!isS) return isS;
		}
		return true;
	}

	static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
	
	public static class P {
		int r;
		int c;
		
		public P(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
}
