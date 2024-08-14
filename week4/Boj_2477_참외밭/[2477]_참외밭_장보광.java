import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//메모리: 14168kb, 시간: 120ms

public class BOJ2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 입력 저장 
		int[][] a = new int[6][2];
		
		// 가로 세로 길이 최댓값을 저장 
		int xmax = 0, ymax =0;
		
		for(int i = 0; i < 6; i++) {
			String[] str = br.readLine().split(" ");
			a[i][0] = Integer.parseInt(str[0]);
			a[i][1] = Integer.parseInt(str[1]);
			// 방향에 따라 최댓값을 저장한다. xmax 가로 방향, ymax는 세로 방향 
			if((a[i][0]==1||a[i][0]==2)&&a[i][1]>xmax) xmax = a[i][1];
			if((a[i][0]==3||a[i][0]==4)&&a[i][1]>ymax) ymax = a[i][1];
		}
		
		//안 쪽 작은 사각형의 넓이
		// 비어 있는 공간의 경우 앞 뒤 순서의 방향이 같다. 
		int s = 1;
		for(int i = 0; i < 6; i++) {
			if(i==0) {
				if(a[i+1][0]==a[5][0]) s = s*a[i][1];
			}
			else if(i==5) {
				if(a[i-1][0]==a[0][0]) s = s*a[i][1];
			}
			else if(a[i-1][0] == a[i+1][0]) s = s*a[i][1];
			
		}
		
		System.out.print((xmax*ymax - s)*n);
	}
}
