package algol0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Boj_13335{

	static int N;										// 트럭의 수				
	static int W;										// 다리 길이
	static int L;										// 최대 하중
	static Queue<Integer> trucks;		// 트럭 Queue
	static Queue<Integer> bridge;	// 다리 Queue
	
	public static void main(String[] args)throws IOException {
		
		// 입력 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		trucks = new LinkedList<>();
		bridge = new LinkedList<>();
		
		// 다리를 0으로 채움
		for(int i=0; i<W; i++) {
			bridge.offer(0);
		}
		
		// 트럭 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			trucks.offer(Integer.parseInt(st.nextToken())); 
		}
		
		int currentWeight = 0;
		int time =0;
		
		// 트럭의 큐가 비워질때까지 다리 큐에다가 밀어넣기
		// 트럭이 들어가지 못하면 0을 대신해서 넣기
		// 마지막 트럭이 들어가고 난 뒤 다리 길이 + 하기
		while(!trucks.isEmpty()) {
			currentWeight -= bridge.poll();
			if(currentWeight + trucks.peek() <= L) {
				int nextTruck = trucks.poll();
				bridge.offer(nextTruck);
				currentWeight += nextTruck;
			}else {
				bridge.offer(0);
			}
			time++;
		}
		
		time += W;
		
		System.out.println(time);
	}

}
