package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();;
	static StringTokenizer st;
	static int N; // 노드 개수
	static int [] parents; // 부모 노드 저장(ans)
	static boolean [] visited; // 방문여부 확인
	static ArrayList<Integer> list[];
	
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		visited = new boolean [N+1];
		list = new ArrayList[N+1];
		parents = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			list[n].add(m);
			list[m].add(n);
		}
		
		dfs(1);
		
		for (int i = 2; i < N+1; i++) {
			System.out.println(parents[i]);
		}
	}


	static void dfs(int cnt) {
		visited[cnt] = true;
		for (int i : list[cnt]) {
			if(!visited[i]) {
				parents[i] = cnt;
				dfs(i);
			}
		}
	}

}
