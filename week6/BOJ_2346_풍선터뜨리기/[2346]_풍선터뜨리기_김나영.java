import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 : 14360 kb  시간 132 ms
public class Main_2346_풍선터뜨리기_김나영 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, n, s;
	static int [] balloons;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		balloons = new int [N];
		visited = new boolean [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			balloons[i] = Integer.parseInt(st.nextToken());
		}
		
		// 1부터 시작
		n = 0;
		sb.append(n+1).append(" ");
		for (int i = 1; i < N; i++) {
			s = balloons[n];
			visited[n] = true;
			while (s!=0) {
				if (s < 0) {
					n--;
				} else {
					n++;
				}
				if (Math.abs(n)==N) n = 0;
				if (visited[check(n)]) continue;
				if (s < 0) {
					s++;
				} else {
					s--;
				}
			}
			n = check(n);
			sb.append(n+1).append(" ");
		}
		System.out.println(sb);
	}

	// 인덱스 점검
	static int check(int k) {
		if (k >= N) k -= N;
		else if(k < 0) k += N;
		return k;
	}
	
}
