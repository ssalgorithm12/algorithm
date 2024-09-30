import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 메모리: 15024kb , 시간: 900ms
public class Main {
	
	static int r;
	static int c;
	static char[][] map;
	static boolean[] visited;
	static int max;
	static int[] xr = {1, -1, 0, 0};
	static int[] yc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visited = new boolean[26];
		
		for(int i = 0; i < r; i++) 
			map[i] = br.readLine().toCharArray();
		max = 0;
		
		int temp = map[0][0] - 'A';
		visited[temp] = true;
		dfs(0,0, 1);
		System.out.print(max);
		
	}
	
	static void dfs(int x, int y, int length) {
		if(length > max)
			max = length;
		
		for(int i = 0; i < 4; i++) {
			int xx = x + xr[i];
			int yy = y + yc[i];
			if(xx < r && xx > -1 &&  yy < c && yy > -1) {
				int temp = map[xx][yy] - 'A';
				if(!visited[temp]) {
					visited[temp] = true;
					dfs(xx, yy, length+1);
					visited[temp] = false;	
				}
			}
		}
	}
}
