package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2477참외밭_임채준 {
	
	static int nperm; // 단위 당 참외 개수 저장 변수 선언
	static int[][] map; // 참외 밭 모양 저장할 2차원 배열 선언
	static int[] count; // 움직이는 방향 개수를 저장할 1차원 배열 선언
	static int big, small; // 가장 큰 밭, 뺄 밭을 저장할 변수 선언

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력값 받는 BufferedReader 객체 생성
		nperm = Integer.parseInt(br.readLine()); // 단위 당 참외 수 변수에 저장
		map = new int[6][2]; // 참외 밭 모양 입력 받을 2차원 배열 생성
		
		for(int i = 0; i < 6; i++) { // 모든 참외 밭의 변의 개수에 대해
			StringTokenizer st = new StringTokenizer(br.readLine()); // 각 줄의 요소를 입력 받을 StringTokenizer 객체 선언 및 생성
			for(int j = 0; j < 2; j++) { // 각 줄의 요소의 개수에 대해
				map[i][j] = Integer.parseInt(st.nextToken()); // 참외 밭의 변의 방향과 길이 배열에 저장
			}
		}
		
		count = new int[5]; // 방향 개수보다 1보다 큰 1차원 배열 생성
		for(int i = 0; i < 6; i++) { // 참외 밭의 모든 변에 대해
			count[map[i][0]]++; // 변의 방향을 각 인덱스에 저장
		}		
		
		big = 1; // 큰 참외밭을 저장할 변수 생성
		small = 1; // 뺄 참외밭을 저장할 변수 생성
		for(int i = 0; i < 5; i++) { // 모든 변의 방향에 대하여
			if(count[map[i][0]] == 1 && count[map[i + 1][0]] == 1 && i <= 1) { 
				// 만약 map에서 특정 변의 방향이 하나고 그 다음 변의 방향도 하나인데 특정 변의 방향의 인덱스가 0이나 1이라면
				big = map[i][1] * map[i + 1][1]; // 큰 참외밭의 크기는 해당 변과 그 다음 변의 길이를 곱한 것
				small = map[i + 3][1] * map[i + 4][1]; // 뺄 참외밭의 크기는 그 다다음 변의 길이와 그 다음변의 길이를 곱한 것
				break; // 각 참외 밭의 크기를 정했다면 반복문 중지
			} else if(count[map[i][0]] == 1 && count[map[i + 1][0]] == 1 && i >= 3) {
				// 만약 map에서 특정 변의 방향이 하나고 그 다음 변의 방향도 하나인데 특정 변의 방향의 인덱스가 3보다 크다면
				big = map[i][1] * map[i + 1][1]; // 큰 참외밭의 크기는 해당 변과 그 다음 변의 길이를 곱한 것
				small = map[i - 3][1] * map[i - 2][1]; // 뺄 참외밭의 크기는 그 전전 변의 길이와 그 전 변의 길이를 곱한 것
				break; // 각 참외 밭의 크기를 정했다면 반복문 중지
			} else if(count[map[i][0]] == 1 && count[map[5][0]] == 1 && i == 0) {
				// 만약 map에서 특정 변의 방향이 하나인데 map에서 첫번째 인덱스고 map의 마지막 변의 방향도 하나면
				big = map[i][1] * map[i + 5][1]; // map에서 첫번째 변과 마지막 변 길이의 곱이 큰 참외밭의 크기
				small = map[i + 2][1] * map[i + 3][1]; // 가운데 2개의 변의 곱이 뺄 참외 밭의 크기
				break; // 각 참외 밭의 크기를 정했다면 반복문 중지
			} else if(count[map[i][0]] == 1 && count[map[i + 1][0]] == 1 && i == 2) {
				// 만약 map에서 특정 변의 방향이 하나고 그 다음 변의 방향도 하나인데 특정 변의 방향의 인덱스가 2라면
				big = map[i][1] * map[i + 1][1]; // 특정 변의 길이와 다음 변의 길이의 곱이 큰 참외밭의 크기
				small = map[i - 2][1] * map[i + 3][1]; // map에서 양 끝의 변의 길이들의 곱이 뺄 참외 밭의 크기
				break; // 각 참외 밭의 크기를 정했다면 반복문 중지
			}
		}
		
		int answer = nperm * (big - small); // answer 변수에 단위 당 참외 개수에 넓이를 곱한 값 저장
		System.out.println(answer); // 답 출력
	}
}