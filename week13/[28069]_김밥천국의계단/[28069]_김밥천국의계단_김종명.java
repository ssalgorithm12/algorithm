package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_28069_김밥천국의계단 {

	static int N, K;
	static List<Integer>[] stair;
	static boolean[] visited;
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) {
			System.out.println("minigimbob");
			return; 
		}
		
		stair = new ArrayList[K+1];
		
		for(int i=0; i<K+1; i++) {
			stair[i] = new ArrayList<>();
		}
		
		stair[0].add(0);
		
		visited = new boolean[N+1];
		visited[0] = true;
		
		for(int i=1; i<K+1; i++) {
			
			for(int j=0; j<stair[i-1].size(); j++) {
				
				int index = stair[i-1].get(j);
				
				if((index + (index / 2)) < N+1) {
					if(!visited[index + (index / 2)]) {
						visited[index + (index/2)] = true;
						stair[i].add(index + (index / 2));
					}
				}
				
				if((index + 1) < N + 1) {
					if(!visited[index+1]) {
						visited[index+1] = true;
						stair[i].add(index+1);
					}
				}
				
			}
			
		}
		
		if(visited[N]) {
			System.out.println("minigimbob");
		}else {
			System.out.println("water");
		}
		
	}

}
