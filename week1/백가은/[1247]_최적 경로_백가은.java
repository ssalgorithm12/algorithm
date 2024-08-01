import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int t;
    static int n;
    static int[][] input;

    static int[] visited;

    static int startX, startY;
    static int endX, endY;

    static int ans;
    static int dist;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            ans = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            input = new int[n + 1][n + 1];
            visited = new int[n];

            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                input[j][0] = x;
                input[j][1] = y;
            }

            dfs(startX, startY, 0);
            sb.append("#").append(i + 1).append(" ").append(ans).append("\n");

        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int depth) {

        if(depth == n) {
            dist += (Math.abs(x - endX) + Math.abs(y - endY));
            ans = Math.min(ans, dist);
            dist -= (Math.abs(x - endX) + Math.abs(y - endY));
            return;
        }

        for(int i = 0; i < n; i++) {

            if(visited[i] != 1) {

                int nx = input[i][0];
                int ny = input[i][1];

                dist += (Math.abs(nx - x) + Math.abs(ny - y));
                visited[i] = 1;
                dfs(nx, ny, depth + 1);
                visited[i] = 0;
                dist -= (Math.abs(nx - x) + Math.abs(ny - y));
            }
        }
    }
}
