package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리: 15308kb 시간: 124ms  

public class Boj_13335트럭_임채준 {
	
	static int N; // 트럭 개수 
	static int w; // 다리 길이 
	static int L; // 다리가 버티는 최대 하중 
	static Queue<Integer> trucks; // 트럭 저장 큐  
	static Queue<Integer> bridge; // 다리 상태 저장 큐  
	static int count; // 단위 시간  
	static int sum; // 다리 위 무게 상태 변수  

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 트럭 개수 저장 
		w = Integer.parseInt(st.nextToken()); // 다리 길이 저장  
		L = Integer.parseInt(st.nextToken()); // 다리가 버티는 최대 하중 저장 
		
		trucks = new LinkedList<>(); // 트럭 저장 큐 생성  
		bridge = new LinkedList<>(); // 다리 상태 저장 큐 생성  
		
		// 모든 트럭의 무게 큐에 넣기  
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trucks.offer(Integer.parseInt(st.nextToken()));
		}
		
		// 트럭이 들어가기 전 다리 길이 만큼 0으로 초기화  
		for(int i = 0; i < w; i++) {
			bridge.offer(0);
		}
		// 현재 다리 위 총 무게  
		sum = 0;
		// 진행된 단위 시간  
		count = 0;
		
		while(!trucks.isEmpty()) { // 트럭의 무게가 들어가있는 큐가 빌때까지  
			sum -= bridge.poll(); // 다리의 맨 뒤 요소 빼기  
			// 트럭의 맨 앞 요소와 다리 위 총 무게가 최대 하중보다 작거나 같으면 
			if(trucks.peek() + sum <= L) {	 
				int a = trucks.poll(); // 트럭 큐에서 트럭을 하나 빼고   
				bridge.offer(a); // 다리에 올린다  
				sum += a; // 다리 위 총 무게 업데이트  
			} else {  // 트럭 큐에서 맨 앞에 있는 트럭의 무게와 현재 다리 위 총 무게의 합이 최대 하중보다 크면  
				bridge.offer(0); // 0을 넣는다  		
			}
			// 하나의 행동이 진행될 때 마다 단위시간 경과  
			count++;
		}
		// 트럭 큐가 비었으면 다리의 맨 앞 부분이 무조건 차있다.
		// 따라서 while 문을 통해 진행된 단위시간과 다리 위 첫 자리에 있는 요소가 나오는 시간을 더해서 출력  
		System.out.println(count + w);

	}
	
}
