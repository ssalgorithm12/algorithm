package algo;

import java.io.*;
import java.util.*;

public class 참외밭 {
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int size, unitCnt, width, height;
	static List<int[]> list;
	
	public static void main(String[] args) throws IOException {
		
		unitCnt = Integer.parseInt(br.readLine());  //단위 면적당 참외의 개수
		list = new ArrayList<>(); //참외밭 모양의 방향과 길이 저장할 list
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int dir = Integer.parseInt(st.nextToken()); //방향
			int len = Integer.parseInt(st.nextToken());  //길이
			
			list.add(new int[]{dir, len});
			
			//세로일 때 최대값 구하기
			if(dir == 3 || dir == 4) {
				height = Math.max(height, len);
				
			//가로일 때 최대값 구하기
			} else {
				width = Math.max(width, len);
			}
		}
		
		//같은 방향이 번갈아 나올 때가 직사각형에서 파이는 부분
		for(int i = 0; i < 6; i++) {
			
			//해당 부분 나오면 전체 직사각형에서 해당 면적 빼기
			if(list.get(i % 6)[0] == list.get((i + 2) % 6)[0] && list.get((i + 1) % 6)[0] == list.get((i + 3) % 6 )[0]) {
				
				size = width * height - list.get((i + 1) % 6)[1] * list.get((i + 2) % 6)[1];
				break;
			}
		}
		
		//면적 * 면적당 참외수
		System.out.println(size * unitCnt);
	}

}
