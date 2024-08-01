import java.util.Scanner;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution{
	
	static int N;
	
	static int[] bs;
	static int[] br = {-2, -1, 1, 2};
	
	public static void main(String args[]) throws Exception{

		Scanner sc = new Scanner(System.in);
		int[] result = new int[10];
		
		/*
		여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		for (int i = 0; i < 10; i++) {
			N=sc.nextInt();
			bs = new int[N];
			int sum = 0;
			int view = 0;
			
			// 건물 높이 저장
			for (int j = 0; j < N; j++) {
				bs[j] = sc.nextInt();
			}
			
			// 건물 조망권 확보 세대 수 저장
			for (int j = 2; j < N-2; j++) {
				view = bs[j];
				for (int b : br) {
					if(bs[j+b] >= bs[j]) {
						view = 0;
						break;
					}else {
						view = Math.min(view, bs[j]-bs[j+b]);
					}
				}
				sum += view;
			}
			result[i] = sum;
		}
		for (int i = 0; i < 10; i++) {
			System.out.printf("#%d %d\n" , i+1, result[i]);
		}
	}
}