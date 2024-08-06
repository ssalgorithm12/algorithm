package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Swea_1979 {

	static int testCase;
	static int mapSize;
	static int wordLength;
	static int[][] map;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			mapSize = Integer.parseInt(st.nextToken());
			wordLength = Integer.parseInt(st.nextToken());
			map = new int[mapSize + 2][mapSize + 2];
			int count = 0;
			
			for(int i=1; i<mapSize+1; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<mapSize+1; j++) {
					int input = Integer.parseInt(st.nextToken());
					if(input == 1) {
						map[i][j] = 1;
					}
				}
			}
			for(int i=1; i<mapSize+1; i++){
				for(int j=1; j<mapSize+1; j++) {
					if(map[i-1][j] == 0) {
						int currentY = i;
						int length = 0;
						while(map[currentY][j] != 0) {
							length++;
							currentY++;
						}
						if(length == wordLength) {
							count++;
						}
						
					}
					if(map[i][j-1] == 0) {
						int currentX = j;
						int length = 0;
						while(map[i][currentX] != 0) {
							length++;
							currentX++;
						}
						if(length == wordLength) {
							count++;
						}
					}
				}
			}
			
			result.append("#" + (t+1) + " ");
			result.append(count + "\n");
		}
		System.out.println(result);
	}

}
