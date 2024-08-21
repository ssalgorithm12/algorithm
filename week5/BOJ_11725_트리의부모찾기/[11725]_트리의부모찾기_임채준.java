package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 메모리: 79556kb 시간: 1084ms  

public class Boj_11725트리의부모찾기2_임채준 {
	
	static int N; // 노드의 개수
	static boolean[] visited; // 노드 방문 기록 배열
	static ArrayList<Integer>[] tree; // 트리 데이터 저장 배열
	static int[] answer; // 부모 노드 저장 배열

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 변수에 노드 개수 저
		visited = new boolean[N + 1]; // 0부터 N까지 방문 기록 저장 배열 생성
		tree = new ArrayList[N + 1]; // 각 노드에 연결된 노드들을 저장하는 arraylist 생
		answer = new int[N + 1]; // 각 노드의 부모 노드를 저장할 배열 생성
		
		// 인덱스가 노드이고 노드에 연결된 모든 노드를 arraylist에 저장
		for(int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();  
		}
		
		// 입력 값에서 한 줄에 연결된 두 노드가 주어졌는데 각 인덱스로 취급된 노드에 연결된 노드를 저
		for(int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			tree[n1].add(n2);
			tree[n2].add(n1);
		}
		
		// DFS라는 함수에 루트 노드로 지정된 노드를 인자로 전달 후 함수 실행 
		DFS(1);
		
		// DFS 함수가 실행이 완료된 후 각 노드의 부모 노드가 저장된 배열 출력 
		for(int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}
	}

	static void DFS(int number) {
		visited[number] = true; // 들어온 노드의 방문 기록을 true로 저장
		for(int i : tree[number]) { // Arraylist에서 들어온 노드의 인덱스에 있는 모든 노드들에 대하여 
			if(!visited[i]) { // 노드의 방문 기록이 false라면 
				answer[i] = number; // 그 노드의 부모 노드는 처음 들어온 노드 
				DFS(i); // 들어온 노드의 자식 노드 중 방금 true가 된 노드들에 대하여 다시 함수 실행 
			}
		}
		
	}

}
