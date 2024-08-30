package algorithm;

import java.io.*;
import java.util.*;

public class 빙산 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int r, c, time;
	static int[][] map;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static boolean[][] visited, updated;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		visited = new boolean[r][c];
		updated = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		
		// 두 덩이 이상으로 분리될 때까지 반복
		while (!isDevided()) {
			visited = new boolean[r][c];  // 빙산 방문 여부
			updated = new boolean[r][c];  // 녹은 빙산 여부
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(map[i][j] != 0) {  // 빙산을 발견한 경우 녹이기
						melt(i, j);
					}
				}
			}
			
			time++;  // 걸린 시간 증가
			if(isAllMelted()) {  // 빙산이 모두 녹을 때까지 분리되지 않았을 경우
				System.out.println(0);
				return;
			}
		}
		
		System.out.println(time);
	}
	
	// 빙산 녹이기
	static void melt(int x, int y) {
		int adjOcean = countOcean(x, y);  // 인접한 바다 개수
		
		// 빙산의 높이보다 개수가 적은 경우
		// 바다 개수만큼 녹이기
		if(adjOcean <= map[x][y]) {
			map[x][y] -= adjOcean;
			
		// 빙산의 높이보다 개수가 더 많은 경우
		// 빙산의 높이를 0으로 바꾸기
		} else map[x][y] = 0;
		
		// 녹은 빙산 체크
		updated[x][y] = true;
	}
	
	// 인접 바다 개수 세기
	static int countOcean(int x, int y) {
		int cnt = 0;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 0이면서 빙산이 녹아서 0이 된 경우는 제외하고 개수 세기
			if(check(nx, ny) && map[nx][ny] == 0 && !updated[nx][ny]) {
				cnt++;
			}
		}
		return cnt;
	}
	
	// 덩어리가 두 개 이상인지 확인
	static boolean isDevided() {
		
		boolean isEnd =false;
		for(int i = 0; i < r; i++) {
			if(isEnd) {
				break;
			}
			
			// 빙산 발견하면 인접한 빙산 다 방문처리(chunk 메서드)
			for(int j = 0; j < c; j++) {
				if(map[i][j] != 0) {
					visited[i][j] = true;
					isEnd = true;
					chunk(i, j);
					break;
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					return true;
				}
			}
		}
		return false;	
	}
	
	// 인접한 빙산 방문처리 메서드
	static void chunk(int x, int y) {
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(check(nx, ny) && map[nx][ny] != 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					chunk(nx, ny);
				}
			}
		}
	}
	
	// 모든 빙산이 다 녹았는지 확인
	static boolean isAllMelted() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	// 델타탐색 범위 확인
	static boolean check(int x, int y) {
		if(x < 0 || x >= r || y < 0 || y >= c) {
			return false;
		}
		return true;
	}
}
