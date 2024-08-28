package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class boj_1002_터렛 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static StringTokenizer st;
	static int T;
	static int x1, x2, y1, y2, r1, r2, x3, y3, sum;
	static Set<Integer> set1, set2;
	
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		set1 = new HashSet<>();
		set2 = new HashSet<>();
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			sum = 0;
			
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			// 조규현의 경우에서의 류재명의 위치를 set에 저장
			for (int i = 0; i <= r1; i++) {
				set1.add(x1 + r1-i);
				set1.add(x1 - (r1-i));
				set2.add(y1 + i);
				set2.add(y1 - i);
			}
			
			// 백승환의 경우에서의 류재명의 위치를 찾아 비교
			for (int i = 0; i <= r2; i++) {
				x3 = x2 + r2-i;
				y3 = y2 + i;
				
				if(x1 == x2 && y1 == y2 && r1 == r2) {
					sum = -1;
					break;
				}
				
				if (set1.contains(x3) && r1-Math.abs(x3) == Math.abs(y3)) {
//					if (Math.abs(x3)!=r1 && Math.abs(y3)!=r1) {
//						sum+=2;
//						break;
//					} else sum++;
					if (set1.contains(-x3) || set2.contains(-y3)) {
						sum+=2;
						break;
					} else {
						sum++;
						break;
					}
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
