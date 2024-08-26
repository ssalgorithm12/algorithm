package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 메모리 18344KB 시간 156ms
public class boj_2799_블라인드_김나영 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, n=4;
	static int [] result = new int [5];
	static char [][] window;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 초기화
		window = new char [5*M+1][5*N+1];
		
		for (int i = 0; i < 5*M+1; i++) {
			window[i] = br.readLine().toCharArray();
		}
		
		
		for (int i = 1; i < 5*M+1; i++) {
			for (int j = 1; j < 5*N+1; j+=5) {
				
				// 열려있는 블라인드의 행의 위치를 찾음
				// 해당 행의 인덱스와 같은 위치의 result에 +1;
				if(window[i-1][j]!='.' && window[i][j]=='.') {
					result[i%5-1]++;
				}
				
				// 만약 마지막 블라인드까지 열려있지 않으면 5번째 경우에 +1;
				if(i%5==4 && window[i][j]!='.') result[4]++;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb);
		
	}

}
