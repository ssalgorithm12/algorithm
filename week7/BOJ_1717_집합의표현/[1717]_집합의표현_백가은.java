package algorithm;

import java.io.*;
import java.util.*;

import javax.swing.UIClientPropertyKey;

public class 집합의표현 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, op;
	static int[] p, r;
	
	public static void main(String[] args) throws IOException{
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		op = Integer.parseInt(st.nextToken());
		
		p = new int[n + 1];
		r = new int[n + 1];
		
		for(int i = 0 ; i <= n; i++) {
			p[i] = i;
			r[i] = 1;
		}
		
		for(int i = 0; i < op; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(type == 0) {
				union(a, b);
			} else {
				if(find(a) == find(b)) {
					sb.append("YES").append("\n");
				} else sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void union(int x, int y) {
		
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX != rootY) {
			
			if(r[rootX] == r[rootY]) {
				r[rootX]++;
				p[rootY] = rootX;
				
			} else if(r[rootX] > r[rootY]) {
				p[rootY] = rootX;
				
			} else if(r[rootX] < r[rootY]) {
				p[rootX] = rootY;
			}
		}
	}
	
	static int find(int x) {
		if(p[x] != x) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
}
