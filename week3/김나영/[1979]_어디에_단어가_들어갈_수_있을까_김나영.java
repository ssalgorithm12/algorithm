import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1979_어디에_단어가_들어갈_수_있을까_김나영 {

	static int T, N, M;
	static char [][] map;
	static boolean isS;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			
			// cnt 초기화
			cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// N의 길이를 가진 배열 선언 후
			// char 배열 map에 toCharArray로 받음
			// toCharArray는 공백도 배열 요소로 받음,,, 잘 신경쓰고 하기
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().replaceAll(" ", "").toCharArray();
			}
			
			// int 버전
//			map = new int[N][N];
//			for (int i = 0; i < N; i++) {
//				StringTokenizer st2 = new StringTokenizer(br.readLine());
//				for (int j = 0; j < N; j++) {
//					map[i][j] = Integer.parseInt(st2.nextToken());
//					System.out.println(map[i][j]);
//				}
//			}
			
			// 슬라이딩 윈도우 사용
			// 행을 기준으로 M개만큼 연속된 1이 있는지 확인
			// M개를 넘어가면 false
			for (int r = 0; r < N; r++) {
				for (int c = 0; c <= N-M; c++) {
					isS = true;
					for (int i = 0; i < M; i++) {
						
						// c+M이 N을 넘을 경우
						if(c+M >= N) {
							if(map[r][c+i]!='1' || map[r][c-1]=='1') {
								isS = false;
								break;
							}
						// c가 0일 경우
						} else if (c == 0) {
							if(map[r][c+i]!='1' || map[r][c+M]=='1') {
								isS = false;
								break;
							}
						// 모두 인덱스 범위 내일 경우
						} else if (map[r][c+M]=='1' || map[r][c+i]!='1' || map[r][c-1]=='1') {
							isS = false;
							break;
						}
					}
					if(isS) {
						cnt++;
						c += M;
					}
				}
			}
			
			// 열을 기준으로 M개만큼 연속된 1이 있는지 확인
			// M개를 넘어가면 false
			for (int c = 0; c < N; c++) {
				for (int r = 0; r <= N-M; r++) {
					isS = true;
					for (int i = 0; i < M; i++) {
						
						// r+M이 N을 넘을 경우
						if(r+M >= N) {
							if(map[r+i][c]!='1' || map[r-1][c]=='1') {
								isS = false;
								break;
							}
						// r이 0일 경우
						}else if(r == 0) {
							if(map[r+i][c]!='1' || map[r+M][c]=='1') {
								isS = false;
								break;
							}
						// 인덱스 범위 내일 경우
						} else if(map[r+M][c]=='1' || map[r-1][c]=='1' || map[r+i][c]!='1') {
							isS = false;
							break;
						}
					}
					if(isS) {
						cnt++;
						r += M;
					}
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
		
	}

}
