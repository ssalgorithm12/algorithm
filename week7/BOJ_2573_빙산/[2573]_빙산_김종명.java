import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

// 메모리: 108312KB, 시간 496ms
// 얼음을 녹이고 첫 얼음에서 BFS를 돌며 얼음 개수를 카운트
// 전체 얼음 개수보다 카운트가 적다면 섬으로 나눠진 것이므로 완료

public class BOJ_2573_빙산 {

	static int N;
	static int M;
	static int[][] iceField;
	static int iceCount;
	static int time;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Ice{
		int x;
		int y;
		
		public Ice(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static Queue<Ice> findIce;
	static boolean[][] visited;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		iceField = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				iceField[i][j] = Integer.parseInt(st.nextToken());
				if(iceField[i][j] > 0) {
					iceCount += 1;
				}
			}
		}
		
		time = 0;
		while(true) {
			
			time += 1;
			// 얼음 녹이기
			meltIce();
			// 얼음이 하나도 없을 시 0 출력 
			if(iceCount == 0) {
				System.out.println(0);
				return;
			}
			
			// 얼음 개수가 전체보다 적으면 쪼개진 것이므로 break
			if(countIce()) {
				break;
			}
		}
		
		System.out.println(time);
	}
	
	// 얼음 개수 BFS로 세기
	static boolean countIce() {
		int startY = 0;
		int startX = 0;
		int count = iceCount;
		
		// 시작점으로 삼을 얼음 찾기
		findIce:
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(iceField[i][j] > 0) {
					startY = i;
					startX = j;
					break findIce;
				}
			}
		}
		
		findIce = new LinkedList<>();
		visited = new boolean[N][M];
		
		// 첫 얼음 BFS 시작점에 대입
		findIce.offer(new Ice(startY, startX));
		visited[startY][startX] = true;
		
		// 얼음들의 BFS
		while(!findIce.isEmpty()) {
			Ice current = findIce.peek();
			
			for(int d=0; d<4; d++) {
				if(iceField[current.y + dr[d]][current.x + dc[d]] == 0) {
					continue;
				}
				
				if(visited[current.y + dr[d]][current.x + dc[d]]) {
					continue;
				}
				
				
				findIce.offer(new Ice(current.y + dr[d], current.x + dc[d]));
				visited[current.y + dr[d]][current.x + dc[d]] = true;
			}
			
			findIce.poll();
			count -= 1;
		}
		
		if(count == 0) {
			return false;
		}
		
		return true;
	}
	
	// 얼음 녹이기
	static void meltIce() {
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				// 바닷물이면 continue
				if(iceField[i][j] == 0) {
					continue;
				}
				
				// 바닷물을 만난 만큼 녹이기
				for(int d=0; d<4; d++) {
					if(iceField[i+dr[d]][j+dc[d]] == 0) {
						iceField[i][j] -= 1;
					}
				}
				
				// 녹은 얼음을 -1로 표현
				if(iceField[i][j] <= 0) {
					iceField[i][j] = -1;
				}
			}
		}
		
		// 녹은 얼음들 0으로 바꿔주기
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(iceField[i][j] == -1) {
					iceField[i][j] = 0;
					iceCount -= 1;
				}
			}
		}
		
	}

}
