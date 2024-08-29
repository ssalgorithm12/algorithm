package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2346_풍선터뜨리기 {

	static int N;
	static int[] arr; // 숫자 저장
	static boolean[] pop; // 풍선 터졌는가
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		pop = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int step = N-1;
		int index = 0;
		
    // N번 반복
		while(step > 0) {
			result.append((index + 1) + " ");
			pop[index] = true;
			
      // 풍선 안의 숫자에 따라 가중치 설정 
			int weight = arr[index] > 0 ? 1 : -1;
      // 풍선 안의 숫자로 거리 설정
			int distance = Math.abs(arr[index]);
      // 움직이는 인덱스
			int moveIndex = index;
			
      // 풍선 안의 숫자가 0이 될때까지 반복
			while(distance != 0) {
				 moveIndex += weight;
				
        // 배열 범위 넘어가면 조정
				if(moveIndex < 0 ) {
					moveIndex += N;
				}else if(moveIndex > N-1) {
					moveIndex -= N;
				}
			
        // 만약 안터진 풍선 지나가면 거리 -1
				if(!pop[moveIndex]) {
					distance -= 1;
				}
			}

      // 움직인 만큼 index 움직이기
			index = moveIndex;
			step -= 1;
		}
		
    // 마지막 값이 무한루프 빠져서 넣음
		for(int i=0; i<N; i++) {
			if(!pop[i]) {
				result.append((i+1) + " ");
			}
		}
		
		System.out.println(result);
	}
}
