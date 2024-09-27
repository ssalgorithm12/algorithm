import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9205_맥주마시면서걸어가기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, x1, y1, x2, y2;
	static int [][] map;
	static boolean [] visited;
	static int ans;
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {

			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			
			map = new int[N][2];
			visited = new boolean[N];
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			// 집과 펜타포트 락 페스티벌이 한 번에 갈 수 있거나
			if (Math.abs(x1-x2) + Math.abs(y1-y2)<=1000) {
				ans = 1;
			}
			// 편의점에서 펜타포트까지 한 번에 갈 수 있을 때, 
			// 해당 편의점에 갈 수 있는지 확인
			else {
				for (int i = 0; i < N; i++) {
					if (Math.abs(x1-map[i][0]) + Math.abs(y1-map[i][1]) <= 1000) {
						pentaport(i);
					}
					if (ans==1) break;
				}
			}
			
			if (ans==1) sb.append("happy\n");
			else sb.append("sad\n");
			
		}//t
		System.out.println(sb.toString());
	}

	static void pentaport(int n) {
		if (Math.abs(x2-map[n][0]) + Math.abs(y2-map[n][1])<=1000) {
			ans=1;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				if (Math.abs(map[n][0]-map[i][0]) + Math.abs(map[n][1]-map[i][1])<=1000) {
					visited[i] = true;
					pentaport(i);
					
					if (ans==1) return;
				}
			}
		}
	}

}
