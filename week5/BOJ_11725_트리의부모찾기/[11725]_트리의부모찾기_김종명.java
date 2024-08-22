package algol0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 시간 초과

public class Boj_11725{
	
	static int N;							// 노드 개수
	static int[][] trunks;				// 간선들 저장
	static int[] parent;				// 부모를 저장
	static boolean[] visited;
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		trunks = new int[N-1][2];
		parent = new int[N+1];
		visited = new boolean[N+1];
		
		// 입력 부분
		for(int i=0; i<N-1; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			trunks[i][0] = Integer.parseInt(st.nextToken());
			trunks[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// Tree 생성 재귀 함수
		makeTree(1);
		
		for(int i=2; i<parent.length; i++) {
			result.append(parent[i] + "\n");
		}
		
		System.out.println(result);
	}
	
	static void makeTree(int n) {
		// 방문 노드 true
		visited[n] = true;
		
		for(int i=0; i<N-1; i++) {
			int child = 0;
			
			// n과 연결된 자식을 찾아서 가져옴
			// parent 배열에 n을 부모로 저장
			if(trunks[i][0] == n) {
				child = trunks[i][1];
			}else if(trunks[i][1] == n) {
				child = trunks[i][0];
			}else {
				continue;
			}
			
			if(child > 0 && !visited[child]) {
				parent[child] = n;
				makeTree(child);
			}
		}
	}
}
