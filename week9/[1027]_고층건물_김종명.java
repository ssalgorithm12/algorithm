package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 메모리 14256KB, 시간 104ms
// 기울기 비교

public class Boj_1027_고층건물 {

	static int count;
	static double[] buildings;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		count = Integer.parseInt(br.readLine());
		buildings = new double[count];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<count; i++) {
			buildings[i] = Double.parseDouble(st.nextToken());
		}
		
		if(count == 1) {
			System.out.println(0);
			return;
		}
		
		int maxTotal = 0;
		int index = 0;
		for(int i=0; i<count; i++) {
			int total = 0;
			
			// 왼쪽 최대 기울기
			double leftMin = 1000000001;
			for(int j=i-1; j>=0; j--) {
				
				double angle = (buildings[i] - buildings[j]) / Math.abs((i - j)); 
				
				if(angle < leftMin) {
					leftMin = angle;
					total += 1;
				}
				
			}
			// 오른쪽 최대 기울기
			double	rightMin = 1000000001;
			for(int j=i+1; j<count; j++) {
				
				double angle = (buildings[i] - buildings[j]) / Math.abs((i - j)); 
				
				if(angle < rightMin) {
					rightMin = angle;
					total += 1;
				}
			}
			
			if(total > maxTotal) {
				index = i;
				maxTotal = total;
			}
		}
		
		System.out.println(maxTotal);
	}

}
