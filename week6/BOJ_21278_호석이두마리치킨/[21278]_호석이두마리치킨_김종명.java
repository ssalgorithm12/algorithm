package algol0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 메모리: 31656KB, 시간: 292ms
// 맞은 개수 (7 / 19)

public class Boj_21278{

	static int N;													// 노드 개수
	static int M;													// 간선 개수
	static int totalDistance;								// 총 거리
	static int[] distance;										// 단일 거리
	static int indexA;											// 치킨집 index A
	static int indexB; 											// 차킨집 index B
	static Building[] buildings;
	static Queue<Building> container;			// BFS Container
	
	// Building 객체
	static class Building{
		int data;
		List<Building> neighbors;
		boolean visited;
		
		public Building(int data) {
			this.data = data;
			neighbors = new ArrayList<>();
			visited = false;
		}
	}
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		buildings = new Building[N];
		
		for(int i=0; i<N; i++) {
			buildings[i] = new Building(i+1);
		}
		
		// Input
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			
			buildings[A].neighbors.add(buildings[B]);
			buildings[B].neighbors.add(buildings[A]);
		}
		
		int minTotalDistance = Integer.MAX_VALUE;
		
		// nC2, BFS
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				distance = new int[N];
				totalDistance = BFS(i, j, distance);
				
				// 최소값 찾기
				if(totalDistance < minTotalDistance) {
					indexA = i ;
					indexB = j ;
					minTotalDistance = totalDistance ;
				}
			}
		}
		
		// 출력값
		indexA += 1;
		indexB += 1;
		minTotalDistance *= 2;
		
		// Output
		System.out.println(indexA + " " + indexB + " " + minTotalDistance);
	}
	
	static int BFS(int i, int j, int[] distance) {
		int sum = 0;
		resetVisited(buildings);
		
		// 치킨집 출발
		container = new LinkedList<>();
		container.offer(buildings[i]);
		container.offer(buildings[j]);
		buildings[i].visited = true;
		buildings[j].visited = true;
		
		while(!container.isEmpty()) {
			Building current = container.poll();
			
			// 이웃 ArrayList 순회
			for(int m=0; m<current.neighbors.size(); m++) {
				// 이미 방문했을 시 Pass 
				if(current.neighbors.get(m).visited) {
					continue;
				}
				// Queue에 넣기
				container.offer(current.neighbors.get(m));
				
				// 거리 값 저장
				distance[current.neighbors.get(m).data - 1] = distance[current.data - 1] + 1;
				
				// 모든 가게 순환하는 총 거리에 더하기
				sum += distance[current.neighbors.get(m).data - 1];
				
				// 방문 표시
				current.neighbors.get(m).visited = true;
			}
		}
		
		return sum;
	}
	
	
	// 모든 노드 방문 초기화
	static void resetVisited(Building[] buildings) {
		for(int i=0; i<N; i++) {
			buildings[i].visited = false;
		}
	}
}
