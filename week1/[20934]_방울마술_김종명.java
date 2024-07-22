import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class Solution{

	static int N;
	static int ball_position;
	static int K;
	static int result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int test_case = 0; test_case < N; test_case++) {
			sb.append("#").append(test_case + 1).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ball_position = st.nextToken().indexOf("o");
			K = Integer.parseInt(st.nextToken());
			if(K == 0) {
				result = ball_position;
				sb.append(result).append("\n");
				continue;
			}
			
			// ball rule
			switch(ball_position) {
				case 0:
					if(K % 2 == 0) {
						result = 0;
					}else {
						result = 1;
					}
					break;
				case 1:
					if(K % 2 == 0) {
						result = 1;
					}else {
						result = 0;
					}
					break;
				case 2:
					if(K % 2 == 0) {
						result = 0;
					}else {
						result = 1;
					}
					break;
			}
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
