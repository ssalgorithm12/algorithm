package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2477_참외밭 {

	static int N, M, max;
	static int[][] melon = new int[6][6];
	static int answer;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		max = -1;
		int index = 0;
		answer = 0;
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			melon[i][0] = Integer.parseInt(st.nextToken());
			melon[i][1] = Integer.parseInt(st.nextToken());
			
			// 변의 최대값과 해당 최댓값의 위치 저장
			if(max < melon[i][1]) {
				max = melon[i][1];
				index = i;
			}
		}
		
		// 최댓값 변의 양 변의 길이 비교
		// 직사각형에서 직사각형을 뺀다고 생각한다
		
		int r1 = check(index-1);
		int r2 = check(index+1);
		
		if(melon[r1][1] < melon[r2][1]) {
			answer = melon[index][1] * melon[r2][1] - melon[check(r1-1)][1] * melon[check(r1-2)][1];
		} else {
			answer = melon[index][1] * melon[r1][1] - melon[check(r2+1)][1] * melon[check(r2+2)][1];
		}
		
		System.out.println(answer * N);
		
	}
	
	public static int check(int n) {
		if (n < 0) n += 6;
		else if (n > 5) n -= 6;
		return n;
	}

}
