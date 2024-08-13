package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2564_경비원 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int x, y;
	static int r, c;
	static int N;
	static int min;
	static int [][] map;
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][2];
		
		// 1 북 2 남 3 서 4 동
		
		// 상점 위치 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 경비원 위치 받기
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// 경비원의 위치에 따라 더하는 방식이 달라짐
		// 경비원이 1에 있는 경우 2에 있는 상점은 각 위치의 값을 더한 후 가로 값*2에서 해당 값을 뺀 값과 비교해 더 작은 값을 선택한다
		// 이 때, 3/4에 있는 경우는 자기 위치 값 + 경비원 위치 값 or 가로 - 경비원 위치 값을 더하면 됨
		// 1 북 2 남 3 서 4 동
		min = 0;
		for (int i = 0; i < N; i++) {
			
			if (r == 1) {
				if(map[i][0]==2) {
					int a = map[i][1] + c;
					min += Math.min(a, 2*x - a) + y;
				} else if(map[i][0]==3) {
					min += map[i][1] + c;
				} else if(map[i][0]==4) {
					min += map[i][1] + (x-c);
				} else {
					min += Math.abs(c - map[i][1]);
				}
			} else if (r == 2) {
				if(map[i][0]==1) {
					int a = map[i][1] + c;
					min += Math.min(a, 2*x - a) + y;
				} else if(map[i][0]==3) {
					min += (y-map[i][1]) + c;
				} else if(map[i][0]==4) {
					min += (y-map[i][1]) + (x-c);
				} else {
					min += Math.abs(c - map[i][1]);
				}
			} else if (r == 3) {
				if(map[i][0]==4) {
					int a = map[i][1] + c;
					min += Math.min(a, 2*y - a) + x;
				} else if(map[i][0]==1) {
					min += map[i][1] + c;
				} else if(map[i][0]==2) {
					min += map[i][1] + (y-c);
				} else {
					min += Math.abs(c - map[i][1]);
				}
			} else {
				if(map[i][0]==3) {
					int a = map[i][1] + c;
					min += Math.min(a, 2*y - a) + x;
				} else if(map[i][0]==1) {
					min += (x-map[i][1]) + c;
				} else if(map[i][0]==2) {
					min += (x-map[i][1]) + (y-c);
				} else {
					min += Math.abs(c - map[i][1]);
				}
			}
			
		}
		System.out.println(min);
	}

}
