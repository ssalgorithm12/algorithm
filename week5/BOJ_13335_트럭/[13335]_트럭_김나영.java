package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335_트럭 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, W, L, cnt, sum;
	static Queue<Integer> que = new ArrayDeque<Integer>();
	static int [] truck;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		cnt = 0;
		sum = 0;
		for (int i = 0; i < W; i++) {
			que.offer(0);
		}
		
		// 트럭 무게를 que에 W만큼 받음
		while(st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			// que 내의 트럭 무게 합계에 새로운 트럭 무게 n을 더함
            sum += n;
			
            // sum <= L일 때까지 que에 값 0을 넣음
            // 반복 횟수 동안 cnt++
            // sum <= L이면 que에 n을 넣고 break
			while(true) {
				cnt++;
				sum -= que.poll();
				if(sum > L) {
					que.offer(0);
				} else {
					que.offer(n);
					break;
				}
			}
			
		}
		System.out.println(cnt+que.size());
	}
}
