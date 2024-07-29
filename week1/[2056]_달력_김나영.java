package test;

import java.util.Arrays;
import java.util.Scanner;
//import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution{
	
	static int[] ms = new int[] {4, 6, 9, 11};
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		String[] s = new String[T];


		for(int test_case = 0; test_case < T; test_case++){
			String s1 = sc.next();
			int m = Integer.parseInt(s1.substring(4,6));
			if(m<=0 || m>=13) {
				s[test_case] = "-1";
				continue;
			}
			if(m==2) {
				if(s1.substring(6).compareTo("30")>=0) {
					s[test_case] = "-1";
					continue;
				}
			}else if(Arrays.asList(ms).contains(m)) {
				if(s1.substring(6).compareTo("31")>=0) {
					s[test_case] = "-1";
					continue;
				}
			}else if(!(Arrays.asList(ms).contains(m))) {
				if(s1.substring(6).compareTo("32")>=0) {
					s[test_case] = "-1";
					continue;
				}
			}
			
			s[test_case] = s1.substring(0,4) + "/" + s1.substring(4,6) + "/" + s1.substring(6);
		}
		for (int t = 0; t < T; t++) {
			System.out.printf("#%d " + s[t] + "\n", t+1);
		}
		
	}
}