package study;

import java.io.*;
import java.util.*;

//메모리 : 14108kb, 시간 : 96ms
public class boj2564_경비원_백가은 {
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int width, height, cnt, dir, dist, police, min;
	static int[] shops;
	
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		width = Integer.parseInt(st.nextToken());  // 가로 길이
		height = Integer.parseInt(st.nextToken()); // 세로 길이
		
		cnt = Integer.parseInt(br.readLine()); // 상점 개수
		shops = new int[cnt];
		for(int i = 0; i < cnt + 1; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			dir = Integer.parseInt(st.nextToken()); // 각 위치의 방향
			dist = Integer.parseInt(st.nextToken()); // 각 위치의 거리
			
			//입력의 마지막이면 겅비원 위치로 받기
			if(i == cnt) {
				police = findLoc(dir, dist); //경비원 위치
			
			//상점의 위치는 배열에 저장
			} else {
				shops[i] = findLoc(dir, dist); //상점 위치
			}
		}
		
		//상점의 위치 ~ 경비원의 위치 계산 방향 : 시계방향과 반시계방향 중 최소값을 고르기
		for(int l : shops) {
			min += Math.min(Math.abs(police - l), width * 2 + height * 2 - Math.abs(police - l));
		}
		
		System.out.println(min);
	}
	
	//좌측 상단을 점을 시작점으로 하여 사각형 블록을 일직선으로 펴서 절대적인 위치 구하기
	static int findLoc(int dir, int dist) {
		
		int loc = 0;
		
		if(dir == 1) {
			loc = dist;
		} else if(dir == 2) {
			loc = width * 2 + height - dist;
		} else if(dir == 3) {
			loc = width * 2 + height * 2 - dist;
		} else {
			loc = width + dist;
		}
		
		return loc;
	}

}
