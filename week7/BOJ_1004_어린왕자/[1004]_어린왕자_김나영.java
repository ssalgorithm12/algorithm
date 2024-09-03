import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1004_어린왕자 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, K, cnt, x1, y1, x2, y2;
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			cnt = 0;
			
			// 출발점과 도착점
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			N = Integer.parseInt(br.readLine());
			
			// 행성계의 좌표와 반지름 길이를 받음
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				if (isIn(x, y, z)) cnt++;
			}
			sb.append(cnt).append("\n");
		}// t
		System.out.println(sb);
	}// main
	
	// 행성계 내부에 해당 좌표가 있는지 확인
	static boolean isIn(int x, int y, int r) {
		double d1 = Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
		double d2 = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
		
		if (d1 <= r && d2 <= r) return false;
		if (d1 > r && d2 > r) return false;
		return true;
	}

}
