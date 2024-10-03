package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16928_뱀과사다리 {

	static int N, M;
	// 뱀과 사다리 정보가 들어있는 맵 생성 
	static int[][] map;
	
	static int count;
	static boolean[] visited;
	
	// 주사위 6방 탐색 
	static int[] dice = {1, 2, 3, 4, 5, 6};
	
	public static void main(String[] args)throws IOException{

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[101][2];
		visited = new boolean[101];
		
		for(int i=0; i<101; i++) {
			map[i][0] = i;
			map[i][1] = i;
		}
		
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 입구
			int entrance = Integer.parseInt(st.nextToken());
			// 출구
			int exit = Integer.parseInt(st.nextToken());
			
			map[entrance][1] = exit;	
		}
		
		// map을 기준으로 BFS
		count = 0;
		BFS();
		
		System.out.println(count);
		
	}
	
	static void BFS() {
		
		Queue<Integer> container = new LinkedList<>();
		
		container.offer(1);
		visited[1] = true;
		
		while(!container.isEmpty()) {
			
			int size = container.size();
			
			for(int i=0; i<size; i++) {
				
				int current = container.poll();
				
				// 도착하면 return
				if(current == 100) {
					return;
				}
				
				for(int d=0; d<6; d++) {
					
					int nIndex = current + dice[d];
					
					// 배열 범위 벗어나는지 체크 
					if(!check(nIndex)) {
						continue;
					}
					
					// 실제로 도착할 장소 
					int np = map[nIndex][1];
					
					if(visited[np]) {
						continue;
					}
					
					visited[np] = true;
					container.offer(np);
				}
				
			}
			
			count += 1;
		}
	}
	
	// 배열 범위 벗어나는지 체크
	static boolean check(int index) {
		return index < 101;
	}

}
