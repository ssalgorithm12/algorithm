package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 메모리 : 50020KB, 시간 : 380ms
// 크루스칼로 부모 찾기

public class BOJ_1717_집합의표현 {

	// 정점 개수
	static int size;
	// 명령 개수 
	static int count;
	// 부모 저장 배열
	static int[] parent;
	// 출력 
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		count = Integer.parseInt(st.nextToken());
		
		// 배열 생성
		makeSet();
		
		for(int i=0; i<count; i++) {
			st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(command == 0) {
				union(A, B);
			}else {
				compareParent(A, B);
			}
		}
		
		System.out.println(result);
	}
	
	// 배열 생성
	static void makeSet() {
		parent = new int[size + 1];
		
		for(int i=0; i<size + 1; i++) {
			parent[i] = i;
		}
	}
	// 부모 탐색
	static int findSet(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = findSet(parent[x]);
	}
	// 서로 합쳐주는 유니온
	static boolean union(int A, int B) {
		int aParent = findSet(A);
		int bParent = findSet(B);
		
		if(aParent == bParent) {
			return false;
		}
		
		if(aParent < bParent) {
			parent[bParent] = aParent;
		}else {
			parent[aParent] = bParent;
		}
		
		return true;
	}
	// A와 B 부모 비교
	static void compareParent(int A, int B) {
		int aParent = findSet(A);
		int bParent = findSet(B);
		
		if(aParent == bParent) {
			result.append("YES\n");
			return;
		}
		
		result.append("NO\n");
		return;	
	}
}
