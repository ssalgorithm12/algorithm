package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

// 메모리 : 16684KB , 시간 : 152ms
// 배추 BFS 돌리기

public class BOJ_1012_유기농배추 {

	// 입력
	static int testCase;
	static int N, M, K;
	
	// 배추
	static int[][] field;
	static List<Cabbage> container; 
	static class Cabbage{
		int x;
		int y;
		
		public Cabbage(int y, int  x) {
			this.y = y;
			this.x = x;
		}
	}
	
	// BFS
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<Cabbage> bfs;
	
	// 출력
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 입력
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			field = new int[N][M];
			container = new ArrayList<>();
			
			// 배추 밭 생성
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				field[y][x] = 1;
				container.add(new Cabbage(y, x));
			}
			
			// 배추 탐색
			int result = findCabbageLand();
			
			answer.append(result + "\n");
		}
		
		System.out.println(answer);
	}
	
	static int findCabbageLand() {
		int size = container.size();
		int cabbageLand = 0;
		
		// 컨테이너에서 배추 꺼내기
		for(int i=0; i<size; i++) {
			Cabbage current = container.get(i);
			
			if(field[current.y][current.x] > 1) {
				continue;
			}
			
			bfs = new LinkedList<>();
			
			// visited 대신 배추 위치 값 2로 변경 
			field[current.y][current.x] = 2;
			
			// BFS로 개수 찾기
			int count = BFS(current);
			
			// 전체 개수에서 배추 개수 빼기
			K -= count;
			
			// 배추 섬 증가
			cabbageLand += 1;
			
			if(K <= 0) {
				break;
			}
		}
		
		return cabbageLand;
	}
	
	// 배추 섬 찾기 BFS
	static int BFS(Cabbage input) {
		int count = 0;
		
		bfs.offer(input);
		
		while(!bfs.isEmpty()) {
			Cabbage current = bfs.peek();
			
			int currentX = current.x;
			int currentY = current.y;
			
			for(int d=0; d<4; d++) {
				int newX = currentX + dc[d];
				int newY = currentY + dr[d];
				
				if(!check(newY, newX)){
					continue;
				}
				
				if(field[newY][newX] != 1) {
					continue;
				}
				
				field[newY][newX] = 2;
				Cabbage newCurrent = new Cabbage(newY, newX);
				bfs.offer(newCurrent);
			}
			
			bfs.poll();
			count += 1;
		}
		
		return count;
	}
	
	// 배열 확인 췍
	static boolean check(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}

}
