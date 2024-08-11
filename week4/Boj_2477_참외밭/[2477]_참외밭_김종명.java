import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 메모리 14156KB, 실행 시간 96ms

public class Boj_2477 {
	
	// 참외 개수
	static int melon;
	// 입력 저장 배열
	static int[][] directionLength = new int[6][2];
	// 중복 방향 찾기
	static boolean[] directionValid= new boolean[4];
	// 큰 사각형
	static int[] bigIndex = new int[2];
	// 작은 사각형
	static int[] smallIndex = new int[2];
	
	public static void main(String[] args)throws IOException {
		
		// 입력 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		melon = Integer.parseInt(br.readLine());
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken()) - 1;
			int length = Integer.parseInt(st.nextToken());
			
			// 중복 되는 방향 false, 중복 되지 않는 방향 true
			directionValid[direction] = !directionValid[direction];
			directionLength[i][0] = direction;
			directionLength[i][1] = length;
		}
		
		// 중복 되지 않는 방향의 인덱스 찾기
		int index = 0;
		for(int i=0; i<6; i++) {
			if(directionValid[directionLength[i][0]]) {
				bigIndex[index++] = i;
			}
		}
		
		// 작은 사각형의 index는 큰 사각형의 index와 한 칸 떨어져 있음
		if(bigIndex[0] == 0 && bigIndex[1] == 5) {
			smallIndex[0] = 2;
			smallIndex[1] = 3;
		}else {
			smallIndex[0] = (bigIndex[1] + 2) % 6;
			smallIndex[1] = (bigIndex[1] + 3) % 6;
		}
		
		// 밭의 총 넓이
		long extent = directionLength[bigIndex[0]][1] * directionLength[bigIndex[1]][1] 
				- directionLength[smallIndex[0]][1] * directionLength[smallIndex[1]][1];
		
		// 총 참외 개수
		long totalMelon = extent * melon;
		
		// 출력 부분
		System.out.printf("%.0f", totalMelon);

	}
}
