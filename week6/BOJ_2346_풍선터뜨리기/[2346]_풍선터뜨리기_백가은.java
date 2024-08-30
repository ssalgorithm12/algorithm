package algorithm;

import java.io.*;
import java.util.*;

public class 풍선터뜨리기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, cnt;
	static int[] arr;
	static boolean[] visited;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		visited = new boolean[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		popBallon();
		System.out.println(sb);
	}
	
	static void popBallon() {
		q = new LinkedList<>();
		q.add(1);
		
		while (!q.isEmpty()) {
			
			int cur = q.poll();
			sb.append(cur).append(" ");
			cnt++;
			if(cnt == n) {
				break;
			}
			
			visited[cur] = true;
			int move = arr[cur];
			
			int tmp = 0;
			while (tmp < Math.abs(move)) {
				
				int next = 0;
				if(move < 0) {
					next = cur - 1 == 0 ? n : cur - 1;
					if(!visited[next]) {
						tmp++;
					}
					
				} else {
					next = cur + 1 == n + 1 ? 1 : cur + 1;
					if(!visited[next]) {
						tmp++;
					}
				}
				cur = next;
			}
			
			q.add(cur);
		}
	}
}
