import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1189_컴백홈_김나영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C, K, sum;
	static char [][] map;
	static int [] dr = {-1, 0, 1, 0};
	static int [] dc = {0, 1, 0, -1};
	static boolean [][] visited;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		visited = new boolean [R][C];
		
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		dfs(R-1, 0, 1);
		
		System.out.println(sum);
		
	}

	static void dfs(int r, int c, int cnt) {
		if (cnt == K) {
			if (r == 0 && c == C-1) sum++;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (!check(nr,  nc) || map [nr][nc]=='T' || visited[nr][nc]) continue;
			visited[r][c] = true;
			dfs(nr, nc, cnt+1);
			visited[r][c] = false;
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
