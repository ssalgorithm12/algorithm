package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1027_고층건물 {
	
	static int N, count, max;
	static double[] nums;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new double[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		max = 0;
		for(int i = 0; i < N; i++) {
			count = 0;
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				double g = ((double)(nums[i] - nums[j])/(i - j));
				double y = nums[i] - ((double)(nums[i] - nums[j])/(i - j)) * i;
				if(i > j) {
					int temp = 0;
					for(int k = j + 1; k < i; k++) {
						if(g * k + y <= nums[k]) {
							break;
						}
						temp++;
					}
					if(temp == i - j - 1) count++;
				} else {
					int temp = 0;
					for(int k = i + 1; k < j; k++) {
						if(g * k + y <= nums[k]) {
							break;
						}
						temp++;
					}
					if(temp == j - i - 1) count++;
				}
			}
			if(count > max) max = count;
		}
		System.out.println(max);

	}

}
