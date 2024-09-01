import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

// 메모리: 41488KB, 시간: 236ms
// 치즈 외부 공기를 -1로 바꿔주면서 치즈 녹이기 반복

public class Boj_2638_치즈 {

	// 가로 N, 세로 M
	static int N;
	static int M;
	// 치즈 개수
	static int cheeseCount;
	// 치즈 맵과 치즈 visited
	static int[][] cheeseMap;
	static boolean[][] visited;
	// 4방향 탐색
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	// 치즈
	static class Cheese{
		int x;
		int y;
		
		public Cheese(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	// BFS 용 Queue
	static Queue<Cheese> way;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cheeseCount = 0;
		cheeseMap = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 1) {
					cheeseCount += 1;
				}
				
				cheeseMap[i][j] = input;
			}	
		}
		
		int time = 0;
		
		// 치즈 개수 다 사라질때까지 반복
		while(cheeseCount > 0) {
			setAir();
			killCheese();
			time += 1;
		}
		
		System.out.println(time);
	}
	
	// 4방향에서 외부 공기 -1이 2개 이상있으면 치즈 녹이기
	static void killCheese() {
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(cheeseMap[i][j] == 1) {
					int count = 0;
					
					// 4방향 탐색
					for(int d=0; d<4; d++) {
						if(cheeseMap[i+dr[d]][j+dc[d]] == -1) {
							count += 1;
						}
					}
					
					// 외부 공기 2개 이상이면 치즈 녹이기
					if(count > 1) {
						cheeseMap[i][j] = 0;
						cheeseCount -= 1;
					}
				}
			}
		}
	}
	
	// 치즈 외부 공기 값을 BFS를 통해서 -1로 만들기
	static void setAir() {
		visited = new boolean[N][M];
		way = new LinkedList<>();
		
		way.offer(new Cheese(0,0));
		cheeseMap[0][0] = -1;
		visited[0][0] = true;
		
		while(!way.isEmpty()) {
			Cheese current = way.peek();
			
			for(int d=0; d<4; d++) {
				int newY = current.y + dr[d];
				int newX = current.x + dc[d];
				
				// BFS 배열 벗어나면 continue
				if(newY < 0 || newX < 0 || newY > N-1 || newX > M-1) {
					continue;
				}
				
				// 방문했으면 continue
				if(visited[newY][newX]) {
					continue;
				}
				
				// 치즈가 있는 공간 만나면 continue
				if(cheeseMap[newY][newX] > 0) {
					continue;
				}
				
				// 외부 공기를 -1로 만들기
				way.offer(new Cheese(newY, newX));
				cheeseMap[newY][newX] = -1;
				visited[newY][newX] = true;
			}
			
			way.poll();
		}
	}
}
