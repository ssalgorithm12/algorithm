package algorithm;

import java.io.*;
import java.util.*;

// 메모리 : 15264, 시간 : 116
public class boj_트럭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static Queue<Integer> onRoad;
	static Queue<Integer> wait;
	static int n, len, max, time;
	
	public static void main(String[] args) throws IOException {
		
		onRoad = new LinkedList<>();  // 다리 위에 있는 차를 담을 큐
		wait = new LinkedList<>();  // 다리 건너기 전인 차를 담을 큐
		
		st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		len = Integer.parseInt(st.nextToken());  // 다리 길이
		max = Integer.parseInt(st.nextToken());  // 다리에 올라갈 수 있는 최대 무게
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < len; i++) {
			wait.add(Integer.parseInt(st.nextToken()));  // 입력값을 다리 건너기 전 큐에 넣기
		}
		
		
		for(int i = 0; i < n; i++) {
			onRoad.add(0);  // 다리 길이만큼 무게가 0인 차 넣어두기
		}
		
		int sum = 0;
		time = 0;
		while (!wait.isEmpty()) {
			
			time++;
			// 다리의 마지막에 있는 차 빼기
			// 다리에 있는 모든 차의 무게에서 방금 나간 차의 무게 빼기
			sum -= onRoad.poll(); 
			
			// 대기 큐에 있는 무게를 더해도 최대 무게보다 커지지않으면 다리에 추가하기
			// 최대무게를 초과하면 무게가 0인 차 넣기
			if(sum + wait.peek() <= max) {
				sum += wait.peek();
				onRoad.add(wait.poll());
			} else onRoad.add(0);
		}
		
		System.out.println(time + len);
	}
}
