import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_22342_계산로봇 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, input, max;
	static char [] arr;
	static int [][] map, dp;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new char [M];
		map = new int [M][N];
		
		for (int r = 0; r < M; r++) {
			arr = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				map[r][c] = arr[c]-'0';
			}
		}
		
		for (int j = 1; j < N; j++) {
			for (int i = 0; i < M; i++) {
				robot(i, j);
			}
		}
		
		System.out.println(max);
	}
	
	static void robot(int i, int j) {
		input = map[i][j-1];
		if (i > 0) {
			input = Math.max(input, map [i-1][j-1]);
		}
		if (i < M-1) {
			input = Math.max(input, map [i+1][j-1]);
		}
		map [i][j] += input;
		if (j == N-1) max = Math.max(max, input);
	}

}
