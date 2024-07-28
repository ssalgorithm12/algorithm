import java.io.*;
import java.util.*;

public class b3 {

    static int[][] arr;
    static int c, r;

    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    static List<int[]> list = new ArrayList<>();
    static int max;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st1 = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st1.nextToken());
        r = Integer.parseInt(st1.nextToken());

        arr = new int[r][c];


        for(int i = 0; i < r; i++) {

            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < c; j++) {

                int input = Integer.parseInt(st2.nextToken());
                if(input == 1) {
                    list.add(new int[] {i, j});
                }

                arr[i][j] = input;
            }
        }
        System.out.println(bfs());

    }

    static int bfs() {
        Deque<int[]> q = new LinkedList<>();

        // 초기값 설정
        Iterator<int[]> iterator = list.iterator();
        while(iterator.hasNext()) {

            int[] has = iterator.next();
            int a = has[0];
            int b = has[1];

            q.add(new int[] {a, b, 0});
        }

        while(!q.isEmpty()) {

            int[] popped = q.pop();

            int x = popped[0];
            int y = popped[1];
            int cnt = popped[2];

            for(int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(check(nx, ny) && arr[nx][ny] == 0) {

                    arr[nx][ny] = 1;
                    q.add(new int[] {nx, ny, cnt + 1});
                    if (cnt + 1 > max) {
                        max = cnt + 1;
                    }
                }

            }

        }


        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {

                if(arr[i][j] == 0) {
                    return -1;
                }
            }
        }
        return max;

    }

    static boolean check(int nx, int ny) {

        if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
            return true;
        } else return false;

    }
}
