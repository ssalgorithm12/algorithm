package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1210ladder_임채준 {

    static int T = 10;
    static int N = 100;
    static int test;
    static int endpoint;
    static int r;
    static int c;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int tc = 1; tc <= T; tc++) {
        	test = Integer.parseInt(br.readLine());
            map = new int[N][N];
            int endPoint = -1;
            
            for (int i = 0; i < N; i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        endPoint = j;
                    }
                }
            }
            
            r = N - 1;
            c = endPoint;

            while (r > 0) {
                if (c > 0 && map[r][c - 1] == 1) {
                    while (c > 0 && map[r][c - 1] == 1) {
                        c--;
                    }
                } else if (c < N - 1 && map[r][c + 1] == 1) {
                   while (c < N - 1 && map[r][c + 1] == 1) {
                      c++;
                    }
                }
                r--;
            }
            System.out.println("#" + tc + " " + c);
        }
    }
}