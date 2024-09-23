package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj_1189_컴백홈 {

	static int R, C, K;
	static char[][] map;
	static boolean[][] visited;
	static int count;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		count = 0;
		
		int y = R-1;
		int x = 0;
		
		visited[y][x] = true;
		
		DFS(y, x, 1);
		
		System.out.println(count);
	}
	
	static void DFS(int y, int x, int depth) {
		// 도착하면 DFS 종료
		if(isArrive(y, x)) {
			
			// K 번인지 확인
			if(depth == K) {
				count += 1;
			}
			
			return;
		}
		
		// 4방
		for(int d=0; d<4; d++) {
			
			int ny = y + dr[d];
			int nx = x + dc[d];
			
			if(!check(ny, nx)) {
				continue;
			}
			
			if(map[ny][nx] == 'T') {
				continue;
			}
			
			if(visited[ny][nx]) {
				continue;
			}
			
			// 백트래킹
			visited[ny][nx] = true;
			DFS(ny, nx, depth + 1);
			visited[ny][nx] = false;

		}
		
	}// DFS
	
	// 도착 확인
	static boolean isArrive(int y, int x) {
		return y == 0 && x == (C - 1);
	}// isArrive

	// 배열 범위 체크
	static boolean check(int y, int x) {
		return y >=0 && x >= 0 && y < R && x < C;
	}// check
	
}
