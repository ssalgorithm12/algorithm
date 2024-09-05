import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//  51380 KB  	392 MS
public class boj_1717_집합의표현 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int [] p, r;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		makeset();
		
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (ex == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}// main
	
	
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if (x==y) return;
		if (r[x] < r[y]) {
			p[x] = y;
			r[y] += r[x];
		} else {
			p[y] = x;
			r[x] += r[y];
		}
		
		return;
	}

	static int find(int n) {
		if (p[n] == n) return n;
		return p[n] = find(p[n]);
	}

	static void makeset() {
		p = new int [N+1];
		r = new int [N+1];
		for (int i = 1; i < N+1; i++) {
			p[i] = i;
			r[i] = i;
		}
	}

}
