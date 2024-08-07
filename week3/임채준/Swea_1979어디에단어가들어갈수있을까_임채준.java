package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1979어디에단어가들어갈수있을까_임채준 {
	
	static int T; // 테스트케이스 수 저장 변수 선언 
	static int N; // 행,열 길이 입력받을 변수 선언 
	static int M; // 단어길이 입력받을 변수 선언  
	static int[][] map; // 퍼즐 모양 입력받을 2차원 배열 선언 
	static int count; // 길이가 M인 단어 개수를 저장할 변수 선언 

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // bufferedreader 객체 생성 
		StringTokenizer st = new StringTokenizer(br.readLine()); // stringtokenizer 객체 생성 
		T = Integer.parseInt(st.nextToken()); // 테스트케이스 수 변수에 저장 
		for(int t = 1; t <= T; t++) { // 모든 테스트케이스에 대하여 
			st = new StringTokenizer(br.readLine()); // map 정보 입력 받을 stringtokenizer 객체 생성 
			N = Integer.parseInt(st.nextToken()); // 행 및 열 길이 변수에 저장 
			M = Integer.parseInt(st.nextToken()); // 찾을 단어 길이 변수에 저장 
			map = new int[N + 2][N + 2]; // 입력받은 행 열 길이보다 위 아래 양옆에 행 및 열 하나씩 더해서 생성 후 0으로 초기화 
			for(int i = 1; i < N + 1; i++) { // 1번째부터 N번째 행에 대하여 
				st = new StringTokenizer(br.readLine()); // map정보 저장 
				for(int j = 1; j < N + 1; j++) { // 각 행에 대한 열에 들어갈 요소는 
					map[i][j] = Integer.parseInt(st.nextToken()); // 행 별로 입력받은 줄 내에 token들 순서대로 저장 
				}
			}
			count = 0; // 길이가 합당한 개수를 저장하는 변수 초기화 
			for(int i = 1; i < N - M + 2; i++) { // 길이가 M인 1로 이루어진 패턴을 찾기 위해 가능한 범위 내에서 x좌표?를 먼저 움직이는데 
				for(int j = 1; j < N + 1; j++) { // x좌표?를 움직이는 동안 열 고정(가능 범위 내에 모든 열에 대하여)
					if(map[i - 1][j] == 0 && map[i + M][j] == 0) { // 시작점의 전 요소가 0이고 M개의 요소 다음 요소가 0이면 
						int sum = 0; // M만큼의 합을 구할 변수 생성 및 초기화 
						for(int k = 0; k < M; k++) { // M만큼의 범위 내에 모든 요소들을 
							sum += map[i + k][j]; // 다 더했을때 
						}
						if(sum == M) { // 그 값이 M과 같다면 
							count++; // 총 개수를 저장하는 변수 1 증가 
						}
					}										
				}
			}
			for(int j = 1; j < N - M + 2; j++) { // 이번에는 행을 고정하고 y좌표?를 움직일건데 가능한 범위안에서 
				for(int i = 1; i < N + 1; i++) { // y좌표?가 움직이는 동안 행을 고정하고(모든 행에 대하여)
					if(map[i][j - 1] == 0 && map[i][j + M] == 0) { // 시작점의 전 요소가 0이고 M만큼 이동한 요소의 다음 요소가 0일때 
						int sum = 0;// M동안의 값을 저장할 변수 생성 및 초기화 
						for(int k = 0; k < M + 1; k++) { // M의 길이에 대하여 
							sum += map[i][j + k]; // 그 안의 모든 요소를 더했을 때 
						}
						if(sum == M) { // 그 값이 M과 같다면 
							count++; // 총 개수를 저장하는 변수 1 증가 
						}
					}										
				}
			}			
			System.out.println("#" + t + " " + count); // 개수를 저장하는 변수 출력 
		}
	}
}
