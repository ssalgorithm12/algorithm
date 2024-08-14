package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2564경비원_임채준 {	
	
	static int hor; // 전체 가로 길이 변수 선언
	static int ver; // 전체 세로 길이 변수 선언
	static int num; // 가게 개수 변수 선언
	static int[][] store; // 가게 위치 2차원 배열 선언
	static int[] leng; // 2차원 위치 정보를 1차원으로 변환했을 때 가게 위치 저장 1차원 배열 선언
	static int locd; // 가게 방향 변수 선언
	static int loc; // 가게 위치 변수 선언
	static int sum; // 총 거리 저장 변수 선언
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		// 맵 전체 가로 세로 길이 받을 BufferedReader객체 생성 후 한 줄 받기
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		// 받은 한 줄을 요소로 쪼갤 StringTokenizer객체 생성 밑 한 줄 받기
		hor = Integer.parseInt(st.nextToken()); // 요소로 받은 가로 길이 정수로 변환 후 변수에 저장
		ver = Integer.parseInt(st.nextToken()); // 요소로 받은 세로 길이 정수로 변환 후 변수에 저장
		num = Integer.parseInt(br.readLine()); // 가게 수 변수에 저장
		
		store = new int[num][2]; // 가게 수 만큼 가게 위치를 저장할 2차원 배열 생성
		leng = new int[num]; // 가게 수 만큼 가게 위치를 저장할 1차원 배열 생성
		
		for(int i = 0; i < num; i++) { // 모든 가게에 대하여
			st = new StringTokenizer(br.readLine()); // 각 가게에 대한 정보를 담은 줄을 받고
			for(int j = 0; j < 2; j++) { // 줄당 요소 개수에 대하여
				store[i][j] = Integer.parseInt(st.nextToken()); // 2차원 배열에 가게 방향 및 위치 저장
			}
		}
		
		st = new StringTokenizer(br.readLine()); // 마지막 줄도 받고
		locd = Integer.parseInt(st.nextToken()); // 동근이 방향 받기
		loc = Integer.parseInt(st.nextToken()); // 동근이 위치 받기
		
		
		for(int i = 0; i < num; i++) { // 모든 가게에 대하여 
			if(locd == 1) { // 동근이의 방향이 1일때
				if(store[i][0] == 2 && store[i][1] <= hor - loc) {
					leng[i] =  hor - loc - store[i][1]; 
				} else if(store[i][0] == 3) {
					leng[i] =  hor - loc + ver - store[i][1];
				} else if(store[i][0] == 1) {
					leng[i] =  hor - loc + ver + store[i][1];
				} else if(store[i][0] == 4) {
					leng[i] =  2 * hor - loc + ver + store[i][1];
				} else if(store[i][0] == 2 && store[i][1] > hor - loc) {
					leng[i] =  3 * hor + 2 * ver - loc - store[i][1];
				}
			}
			if(locd == 2) { // 동근이의 방향이 2일때
				if(store[i][0] == 1 && store[i][1] <= hor - loc) {
					leng[i] =  hor - loc - store[i][1];
				} else if(store[i][0] == 3) {
					leng[i] =  hor - loc + store[i][1];
				} else if(store[i][0] == 2) {
					leng[i] =  hor - loc + ver + store[i][1];
				} else if(store[i][0] == 4) {
					leng[i] =  2 * hor + 2 * ver - loc - store[i][1];
				} else if(store[i][0] == 1 && store[i][1] > hor - loc) {
					leng[i] =  3 * hor + 2 * ver - loc - store[i][1];
				}
			}
			if(locd == 3) { // 동근이의 방향이 3일때
				if(store[i][0] == 4 && store[i][1] <= ver - loc) {
					leng[i] =  ver - loc - store[i][1];
				} else if(store[i][0] == 1) {
					leng[i] =  hor + ver - loc - store[i][1];
				} else if(store[i][0] == 3) {
					leng[i] =  hor + ver - loc + store[i][1];
				} else if(store[i][0] == 2) {
					leng[i] =  hor + 2 * ver - loc + store[i][1];
				} else if(store[i][0] == 3 && store[i][1] > ver - loc) {
					leng[i] =  2 * hor + 3 * ver - loc - store[i][1];
				}
			}
			if(locd == 4) { // 동근이의 방향이 4일때
				if(store[i][0] == 3 && store[i][1] <= ver - loc) {
					leng[i] =  ver - loc - store[i][1];
				} else if(store[i][0] == 1) {
					leng[i] =  ver - loc + store[i][1];
				} else if(store[i][0] == 4) {
					leng[i] =  ver - loc + hor + store[i][1];
				} else if(store[i][0] == 2) {
					leng[i] =  2 * ver - loc + 2 * hor - store[i][1];
				} else if(store[i][0] == 3 && store[i][1] > ver - loc) {
					leng[i] =  2 * hor + 3 * ver - loc - store[i][1];
				}
			}
		}
		loc = hor + ver; // 동근이의 1차원에서 위치 다시 저장
			
		sum = 0; // 총 가게와 동근이 거리
		for(int i = 0; i < num; i++) { // 모든 가게에 대하여
			sum += Math.abs(loc - leng[i]); // 1차원 배열안에서의 가게와 동근이 거리 합
		}
		System.out.println(sum); // 답 반환
	}
}