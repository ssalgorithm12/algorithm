package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj_7511_소셜네트워킹어플 {

	static int T,n,k,m;
	static int[] parent;
	
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<= T; t++) {
			
			result.append("Scenario " + t + ":\n");
			
			n = Integer.parseInt(br.readLine());
			
			makeSet(n);
			
			k = Integer.parseInt(br.readLine());
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				union(A, B);
			}
			
			m = Integer.parseInt(br.readLine());
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				int parentA = findSet(A);
				int parentB = findSet(B);
				
				if(parentA == parentB) {
					result.append(1).append("\n");
				}else {
					result.append(0).append("\n");
				}
			}
			
			result.append("\n");
		}
		
		System.out.println(result);
	}

	static void makeSet(int n) {
		parent = new int[n];
		
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		
		if(parent[x] == x) {
			
			return x;
		}
		
		return parent[x] = findSet(parent[x]);
	}
	
	static void union(int A, int B) {
		
		int parentA = findSet(A);
		int parentB = findSet(B);
		
		if(parentA <= parentB) {
			parent[parentB] = parentA;
		}else {
			parent[parentA] = parentB;
		}
		
	}
}
