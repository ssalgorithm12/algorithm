import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ28069_김밥천국의계단 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		if(n==1) {
			dp[1] = 1;
		}else {
			dp[2] = 2;
			
			for(int i = 2; i < n; i++) {
				if(dp[i+1] > dp[i]+1)
					dp[i+1] = dp[i]+1;
				int x = i + i/2;
				if(x <= n && dp[x] > dp[i]+1)
					dp[x] = dp[i]+1;
			}
		}
		
		if(dp[n] <= k)
			System.out.print("minigimbob");
		else 
			System.out.print("water");
		
	}
}
