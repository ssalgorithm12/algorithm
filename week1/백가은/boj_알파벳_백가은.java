import java.io.*;
import java.util.*;

public class b2 {

    static int[][] arr;
    static boolean[] visited;

    static int r, c;

    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    static int depth;
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        visited = new boolean[26];

        for(int i = 0; i < r; i++) {
            String input = br.readLine();
            for(int j = 0; j < c; j++) {
                arr[i][j] = input.charAt(j) - 'A';
            }
        }

        visited[arr[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int x, int y, int depth) {

        for(int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(check(nx, ny) && !visited[arr[nx][ny]]) {

                visited[arr[nx][ny]] = true;
                dfs(nx, ny, depth + 1);
                visited[arr[nx][ny]] = false;
            }

        }

        if (depth > max) {
            max = depth;
        }
        return;

    }



    static boolean check(int nx, int ny) {
        if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
            return true;
        } else return false;

    }
}

