package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.math.BigDecimal;

// 메모리 15028KB, 시간 156ms
// DFS 돌면서 확률 더해주기

public class Boj_1405_미친로봇 {

	static int N;
	static double[] percent;
	static boolean[][] visited;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	static double answer;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		percent = new double[4];
		visited = new boolean[40][40];
		
		// 각 확률 저장, 동 서 남 북 
		for(int i=0; i<4; i++) {
			percent[i] = Double.parseDouble(st.nextToken()) / 100;
		}

		// DFS 시작
		visited[20][20] = true;
		DFS(20, 20, 0, 1);
		
		BigDecimal result = BigDecimal.valueOf(answer);
		System.out.println(result);
	}

	static void DFS(int i, int j, int count, double sum) {
		if(count == N) {
			answer += sum;
			return;
		}
		
		// 4방 탐색 [동, 서, 남, 북]
		for(int d=0; d<4; d++) {
			int newY = i + dr[d];
			int newX = j + dc[d];
			
			if(visited[newY][newX]) {
				continue;
			}
			
			visited[newY][newX] = true;
			DFS(newY, newX, count + 1, sum * percent[d]);
			visited[newY][newX] = false;
		}
	}
	
}
