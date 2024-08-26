package algorithm;

import java.io.*;
import java.util.*;

public class 호석이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static List<Integer>[] list;
	static Queue<Integer[]> q;
	static boolean[] visited;
	
	static int building, road, b1, b2, time, min, ansB1, ansB2;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		
		building = Integer.parseInt(st.nextToken());  // 빌딩 개수
		road = Integer.parseInt(st.nextToken());  // 도로 개수
		
		list = new ArrayList[building + 1]; // 치킨집 간의 연결 정보 저장할 배열
		visited = new boolean[building + 1];  // 빌딩 방문 여부 저장 배열
		q = new LinkedList<>();  // 치킨집과 연결된 빌딩 넣을 큐
		min = Integer.MAX_VALUE;  // 최소 거리 저장 변수
		
		// 배열 초기화
		for(int i = 1; i < building + 1; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 빌딩 번호에 해당하는 인덱스의 list에 건물 연결 정보 삽입
		for(int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		// 각 건물이 치킨집이 될 경우마다 왕복 시간 계산
		// 치킨집이 될 수 있는 경우 중 작은 번호를 출력해야 하므로
		// 작은 번호부터 반복
		for(int i = 1; i < building + 1; i++) {
			b1 = i;
			for(int j = i + 1; j < building + 1; j++) {
				b2 = j;
				Arrays.fill(visited, false);  // 방문 처리 초기화
				visited[b1] = true;  // 치킨집이 될 건물은 방문 처리
				visited[b2] = true;
				time = 0;  // 총 소요시간
				bfs(b1, b2);  // 왕복 시간 계산
			}
		}
		System.out.println(ansB1 + " " + ansB2 + " " + min);
	}
	
	static void bfs(int b1, int b2) {
		
		// 치킨집 건물과 해당 건물까지의 편도 시간을 배열에 담에 큐에 넣기
		q.add(new Integer[]{b1, 0});  // 첫 번째 치킨집 건물 추가
		q.add(new Integer[]{b2, 0});  // 두 번째 치킨집 건물 추가
		
		while (!q.isEmpty()) {
			
			Integer[] popped = q.poll();
			int buildingNum = popped[0];
			int spend = popped[1];
			time += spend;  // 해당 건물까지의 편도시간을 총 소요시간 변수에 더하기
			
			// 현재 건물과 연결되어 있으면서 방문하지 않은 건물을 큐에 추가
			for(int b : list[buildingNum]) {
				if(!visited[b]) {
					visited[b] = true;
					q.add(new Integer[] {b, spend + 1});
				}
			}
		}
		
		// 시간이 최소가 되는 경우 각 건물 번호와 시간 갱신
		if(time * 2 < min) {
			ansB1 = b1;
			ansB2 = b2;
			min = time * 2;
		}
	}
}
