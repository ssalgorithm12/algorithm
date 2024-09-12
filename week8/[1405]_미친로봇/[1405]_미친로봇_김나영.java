import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1405_미친로봇_김나영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static double sum;
    static double [] probability = new double [4];
    //					동  서  남  북
	static int [] dr = {0, 0, 1, -1};
	static int [] dc = {-1, 1, 0, 0};
	static boolean [][] visited;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		visited = new boolean [2*N+1][2*N+1];
		
		for (int i = 0; i < 4; i++) {
			probability[i] = Double.parseDouble(st.nextToken())/100;
		}
		
		dfs(N, N, 0, 1);
		
		System.out.println(sum);
		
	}
	
	static void dfs(int r, int c, int cnt, double pro) {
		if (cnt == N) {
			sum += pro;
			return;
		}
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (visited[nr][nc]) continue;
			dfs(nr, nc, cnt+1, pro*probability[d]);
		}
		visited[r][c] = false;
	}
	
}
