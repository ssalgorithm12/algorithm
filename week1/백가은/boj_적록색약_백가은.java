import java.io.*;
import java.util.*;

public class b1 {

    static char[][] arr;
    static boolean[][] visited1;
    static boolean[][] visited2;

    static int n;
    static int cnt1;
    static int cnt2;

    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(!visited1[i][j]) {

                    visited1[i][j] = true;
                    dfs1(i, j);
                    cnt1++;

                }
                if(!visited2[i][j]) {

                    visited2[i][j] = true;
                    dfs2(i, j);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }

    static void dfs1(int x, int y) {

        for(int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(check(nx, ny)) {

                if(!visited1[nx][ny] && arr[nx][ny] == arr[x][y]) {

                    visited1[nx][ny] = true;
                    dfs1(nx, ny);

                }
            }

        }
    }

    static void dfs2(int x, int y) {

        for(int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(check(nx, ny)) {

                if(!visited2[nx][ny] && checkColor(x, y, nx, ny)) {

                    visited2[nx][ny] = true;
                    dfs2(nx, ny);
                }
            }

        }
    }



    static boolean check(int nx, int ny) {
        if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
            return true;
        } else return false;

    }

    static boolean checkColor(int x, int y, int nx, int ny) {

        if(arr[x][y] == 'B' && arr[nx][ny] == 'B') {
            return true;

        } else if((arr[x][y] == 'R' || arr[x][y] == 'G')
                && (arr[nx][ny] == 'R' || arr[nx][ny] == 'G')) {
            return true;

        } else return false;
    }
}

