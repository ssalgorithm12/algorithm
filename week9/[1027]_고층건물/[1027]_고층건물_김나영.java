import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1027_고층빌딩 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, max;
	static double n, a;
	static double [][] map;
	static int [] ans;
	static boolean isS;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new double [N][2];
		ans = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i][0] = i+1;
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				isS = true;
				n = (map[j][1] - map[i][1]) / (map[j][0] - map[i][0]);
				a = map[i][1] - n * map[i][0];
				for (int k = i+1; k < j; k++) {
					if (map[k][1] >= n * map[k][0] + a) {
						isS = false;
						break;
					}
				}
				if (isS) {
					ans[i]++;
					ans[j]++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			max = Math.max(ans[i], max);
		}
		
		System.out.println(max);
		
	}

}
