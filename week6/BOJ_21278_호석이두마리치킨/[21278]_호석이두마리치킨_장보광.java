package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리: 21204kb, 시간: 256ms

public class [21278]_호석이두마리치킨_장보광 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] a = new ArrayList[n+1];// 경로를 저장
		for (int i = 0; i <= n; i++) a[i] = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();// BFS를 위한 Queue
		int[][] distance = new int[n+1][n+1];// 최단 거리를 저장 
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			a[x].add(y);
			a[y].add(x);
		}
		
		ArrayList<Integer> temp;// 중간 경로를 임시로 저장 
		boolean[] visited;
		
		// 이미 구한 거리는 제외하는 것으로 최적화할 수 있을 듯 
		// 각 치킨집에서 다른 건물과의 거리를 구한다. 
		for(int i = 1; i <= n; i++) {
			q.add(i);
			visited = new boolean[n+1];
			visited[i] = true;
			
			// BFS로 거리를 구한다. 
			while(!q.isEmpty()) {
				int num = q.poll();
				temp = a[num];
				
				for(int t: temp) {
					if(!visited[t]) {
						visited[t] = true;
						distance[i][t] = distance[i][num] + 2; 	
						q.add(t);
					}
				}
			}
		}
		
		// 결과를 저장하는 변수 
		int min = Integer.MAX_VALUE;
		int x_min = 0;
		int y_min = 0;
		
		// 각 경우마다 거리 합을 구한다. 
		// 두 지점을 선택하는 경우를 이중포문으로 구한다. 
		for(int i = 1; i <= n - 1; i++) {
			for(int j = i+1; j <= n; j++) {
				int sum = 0;
				
				// 두 지점 중에 가까운 지점의 값으로 합을 저장한다. 
				for(int k = 1; k <= n; k++) {
					if(distance[i][k] < distance[j][k]) sum += distance[i][k];
					else sum += distance[j][k];
				}
				
				// 더 작은 값이 나올 경우 값을 갱신한다. 
				if(sum < min) {
					min = sum;
					x_min = i;
					y_min = j;
				}
			}
		}
		
		
		// 결과 출력 
		System.out.print(x_min+" "+y_min+" "+min);		
	}
}
