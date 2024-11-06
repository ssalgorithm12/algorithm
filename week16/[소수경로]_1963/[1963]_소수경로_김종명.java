package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1963_소수경로 {

	static int T;
	static boolean[] prime;
	static boolean[] visited;
	static int count;
	static Queue<Integer> container;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		prime = new boolean[10000];
		
		for(int i=2; i <= 100; i++) {
			
			if(!prime[i]) {
				for(int j= i * i; j < 10000; j += i) {
					prime[j] = true;
				}
			}
			
		}
		
		 
		for(int t=0; t<T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			
			int finish = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			
			BFS(start, finish);
			
			if(prime[finish]) {
				System.out.println("Impossible");
			}else {
				System.out.println(count);
			}
			
		}

	}
	
	static void BFS(int start, int finish) {
		
		container = new LinkedList<>();
		
		container.offer(start);
		visited[start] = true;
		
		count = 0;
		
		while(!container.isEmpty()) {
		
			int size = container.size();
			
			for(int i=0; i<size; i++) {
				
				int cur = container.poll();
				
				if(cur == finish) {
					return;
				}
				
				for(int j=0; j<10; j++) {
					
					if(j > 0) {
						
						int n = (cur % 1000) + (1000 * j);
						
						if(!prime[n]) {
							if(!visited[n]) {
								container.offer(n);
								visited[n] = true;
							}
						}
						
					}
					
					int n_100 = (cur - ((cur % 1000) / 100) * 100) + (100 * j);
					if(!prime[n_100]) {
						if(!visited[n_100]) {
							container.offer(n_100);
							visited[n_100] = true;
						}
					}
					
					int n_10 = (cur - ((cur % 100) / 10) * 10) + (10 * j);
					if(!prime[n_10]) {
						if(!visited[n_10]) {
							container.offer(n_10);
							visited[n_10] = true;
						}
					}
					
					int n_1 = (cur - (cur % 10)) + j;
					if(!prime[n_1]) {
						if(!visited[n_1]) {
							container.offer(n_1);
							visited[n_1] = true;
						}
					}
				}
				
			}
			
			count += 1;
		}
		
		
		
	}

}
