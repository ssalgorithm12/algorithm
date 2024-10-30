package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_15558_점프게임 {

	static int N, k; 
	static boolean[][] visited;
	static Queue<P> container;
	
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		k = Integer.parseInt(st.nextToken());
		
		visited = new boolean[2][N];
		
		// 맵 입력
		for(int i=0; i<2; i++) {
			
			char[] input = br.readLine().toCharArray();
			
			for(int j=0; j<N; j++) {
				
				if(input[j] == '0') {
					visited[i][j] = true;
				}
				
			}
			
		}
		
		int result = BFS();
		System.out.println(result);
	}
	
	static int BFS() {
		
		container = new LinkedList<>();
		
		container.offer(new P(0, 0));
		visited[0][0] = true;
		
		int time = 0;
		
		while(!container.isEmpty()) {
			
			int size = container.size();
			
			for(int i=0; i<size; i++) {
				
				P cur = container.poll();
				
				int cy = cur.y;
				int cx = cur.x;
				
				int y1 = cy;
				int x1 = cx + 1;
				int y2 = cy;
				int x2 = cx - 1;
				int y3 = (cy + 1) % 2;
				int x3 = cx + k;
				
				if(x1 > N-1  || x3 > N-1) {
					return 1;
				}
				
				if(check(y1, x1)) {
					if(!visited[y1][x1]) {
						
						container.offer(new P(y1, x1));
						visited[y1][x1] = true;
					}
				}
				
				if(check(y2, x2)) {
					if(!visited[y2][x2]) {
						if(x2 != time) {
							container.offer(new P(y2, x2));
							visited[y2][x2] = true;
						}
					}
				}
				
				if(check(y3, x3)) {
					if(!visited[y3][x3]) {
						
						container.offer(new P(y3, x3));
						visited[y3][x3] = true;
					}
				}
				
			}
			
			visited[0][time] = true;
			visited[1][time] = true;
			
			if(time == N-1) {
				break;
			}
			
			time += 1;
		}
		
		return 0;
	}
	
	static boolean check(int y, int x) {
		
		return y >= 0 && x >= 0 && y < 2 && x < N;
	}
	
	
	static class P{
		int y;
		int x;
		public P(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
