package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1717_집합의표현 {
	
	static int N, M;
	static int[] p;
	static int[] r;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		makeset();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int act = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(act == 0) {
				union(s, e);
			} else {
				if(find(s) == find(e)) System.out.println("YES");
				else System.out.println("NO");
			}
		}

	}
	static void makeset() {
		p = new int[N + 1];
		r = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return false;
		if(r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		} else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
	}
	
	static int find(int x) {
		if(x == p[x]) return p[x];
		return p[x] = find(p[x]);
	}

}
