package Boj;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_9205_맥주마시기 {

	static int testCase;
	static int martCount;
	static boolean isArrived;
	static List<P> markets;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
		
			// 입력
			martCount = Integer.parseInt(br.readLine());
			
			// 시작점
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			P start = new P(startX, startY);
			
			// 편의점이랑 페스티벌 좌표
			markets = new ArrayList<>();
			
			for(int i=0; i<(martCount + 1); i++) {
			
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				markets.add(new P(x, y));
			
			}
			
			// 도착점
			int finishX = markets.get(martCount).x;
			int finishY = markets.get(martCount).y;
			
			P finish = new P(finishX, finishY);
			
			isArrived = false;
			
			DFS(1, start.x, start.y, finish.x, finish.y);
			
			if(isArrived) {
				result.append("happy\n");
			}else{
				result.append("sad\n");
			}
			
		}// testcase
	
		System.out.println(result);
	}
	
	// DFS
	static void DFS(int depth, int sx, int sy, int fx, int fy) {
		
		if( sx == fx && sy == fy) {
			
			isArrived = true;
			
			return;
		}
		
		if(depth == (martCount + 2)) {
			
			return;
		}
		
		for(int i=0; i<markets.size(); i++) {
			
			P np = markets.get(i);
			
			if(np.visited) {
				continue;
			}
			
			int nx = np.x;
			int ny = np.y;
			
			if( Math.abs(sx - nx) + Math.abs(sy - ny) > 1000) {
				continue;
			}
			
			np.visited = true;
			DFS(depth + 1, nx, ny, fx, fy);
			
		}
		
	}
	
	
	
	// 좌표 with visited
	static class P{
		
		int x;
		int y;
		boolean visited;
		
		public P(int x, int y) {
			this.x = x;
			this.y = y;
			this.visited = false;
		}
	}
}
