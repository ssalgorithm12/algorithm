package algorithm;

import java.io.*;
import java.util.*;

public class boj_트리의부모찾기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n;
	static List<Integer>[] nodes;
	static int[] parent;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		nodes = new List[n + 1];  // 자신과 연결된 루트를 저장할 리스트배열
		for(int i = 1; i <= n; i++) {
			nodes[i] = new ArrayList<>();  // 배열의 각 인덱스마다 리스트 초기화하기
		}
		parent = new int[n + 1];  // 부모 정보 저장할 배열
		visited = new boolean[n + 1];  // 방문된 노드 저장할 배열
		
		for(int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 리스트배열의 부모, 자식 인덱스에 서로의 노드 번호 추가하기
			nodes[a].add(b);
			nodes[b].add(a);
		}
		
		// 자신의 자식을 재귀적으로 호출하여 부모 정보 저장하는 메서드
		findChild(1);
		for(int i = 2; i <= n; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void findChild(int node) {
		visited[node] = true;  // 현재 노드 방문처리
		
		// 현재 노드와 연결된 노드번호 반복 돌리기
		Iterator<Integer> iterator = nodes[node].iterator();
		while (iterator.hasNext()) {
			int a = iterator.next();
			// 노드번호 1부터 시작하므로 자신의 부모는 다 방문처리가 되어있음
			// 방문처리가 안 된 연결된 노드는 다 자신의 자식임
			if(!visited[a]) {
				parent[a] = node;  // 부모의 노드번호 저장
				findChild(a);  // 자신의 자식을 찾기 위해 재귀호출
			}
		}
	}

}
