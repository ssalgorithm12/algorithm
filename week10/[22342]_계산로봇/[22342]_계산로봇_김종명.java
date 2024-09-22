package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 메모리 49948KB, 시간 480ms

public class Boj_22342_계산로봇 {

	static int M, N;
	static int[][] map;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {-1, -1, -1};
	
	public static void main(String[] args)throws IOException {
		
		// 입력  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		
		for(int i=0; i<M; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j=0; j<N; j++) {
				map[i][j] = input[j] - '0';
			}
		}
		
		// N == 1 이면 0 출력
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		// 열 단위로 저장값 찾기
		for(int i=1; i<N-1; i++) {
			findSave(i);
		}
		
		int max = -1;
		
		// 마지막 열의 앞 열에서 최대값 찾기
		for(int i=0; i<M; i++) {
			if(map[i][N-2] > max) {
				max = map[i][N-2];
			}
		}
		
		System.out.println(max);
		
		
	}// main
	
	static void findSave(int x) {
		
		// 최대 저장값 찾기
		for(int j=0; j<M; j++) {
			
			int max = -1;
			
			for(int d=0; d<3; d++) {
				int ny = j + dr[d];
				int nx = x + dc[d];
				
				if(!check(ny, nx)) {
					continue;
				}
				
				if(map[ny][nx] > max) {
					max = map[ny][nx];
				}
			}
			
			// 저장값 더해서 출력값으로 변경
			map[j][x] = max + map[j][x];
		}
		
	}// findSave

	// 배열 범위 체크 
	static boolean check(int y, int x) {
		return y >= 0 && x >= 0 && y < M && x < N;
	}// check
	
}
