package algol0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 메모리 19040KB, 시간 168ms

public class Boj_2799 {

	static int M;			// 건물 층수
	static int N;			// 1층 창문 개수
	static int[] windowStart;		// 창문이 시작하는 위치 배열
	static int buildingHeight;	// 빌딩 높이
	static int[] result;					// 블라인드 상태 배열
	static int[] windows;			// 블라인드 길이 저장 배열
	static StringBuilder answer = new StringBuilder();	// 값 출력용 
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 부분
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		result = new int[5];
		windows = new int[N*M];
		
		// 창문 시작하는 위치 저장 
		windowStart = new int[N];
		for(int i=0; i<N; i++) {
			windowStart[i] = 5*i + 1;
		}
		
		// 빌딩 높이
		buildingHeight = M * 5 + 1;
		
		// 빌딩 높이만큼 입력 받기
		for(int i=0; i<buildingHeight; i++) {
			char[] input = br.readLine().toCharArray();
			
			// 경계선에서는 패스
			if(i % 5 == 0) {
				continue;
			}
			
			// 창문의 시작위치 확인 후 블라인드 길이 저장
			for(int j=0; j<N; j++) {
				if(input[windowStart[j]] == '*') {
					windows[(i/5) * N + j] += 1;

				}
			}
		}
		
		// 블라인드 길이 저장된 값 count
		for(int i=0; i<windows.length; i++) {
			result[windows[i]] += 1;
		}
		
		// 출력용 값에 저장
		for(int i=0; i<result.length; i++) {
			answer.append(result[i] + " ");
		}
		
		// 출력
		System.out.println(answer);
	}

}
