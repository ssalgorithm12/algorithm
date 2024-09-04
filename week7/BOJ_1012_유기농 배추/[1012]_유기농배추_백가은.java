
import java.io.*;
import java.util.*;

public class 유기농배추 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T, r, c, n, cnt;
	static int[][] map;
	static Queue<Integer[]> q;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			map = new int[r][c];
			cnt = 0;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
			}
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(map[i][j] == 1) {
						map[i][j] = 0;
						bfs(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		q = new LinkedList<>();
		q.offer(new Integer[] {x, y});
		
		while (!q.isEmpty()) {
			Integer[] corr = q.poll();
			int curX = corr[0];
			int curY = corr[1];
			
			for(int i = 0 ; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(check(nx, ny) && map[nx][ny] == 1) {
					map[nx][ny] = 0;
					q.offer(new Integer[] {nx, ny});
				}
			}
		}
	}
	
	static boolean check(int x, int y) {
		if(x < 0 || x >= r || y < 0 || y >= c) return false;
		return true;
	}
}
