import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1034_램프 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K, max, count;
	static char [][] map;
	static HashMap<String, Integer> map2;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		map2 = new HashMap<>();
		
		for (int r = 0; r < N; r++) {
			String s = br.readLine();
			map2.put(s, map2.getOrDefault(s, 0) + 1);
		}
		
		K = Integer.parseInt(br.readLine());
		
		maxCount();
		
		System.out.println(max);
	}
	
	static void maxCount () {
		
		for (String s : map2.keySet()) {
			count = 0;
			for (int i = 0; i < M; i++) {
				if (s.charAt(i)=='0') count++;
			}
			
			if (count <= K && (count-K&1)!=1) max = Math.max(map2.get(s), max);
		}
		
	}

	
	
}
