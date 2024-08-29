package algorithm;

import java.io.*;
import java.util.*;

// 19180kb, 228ms
public class 치즈{

static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static StringTokenizer st;

static int r, c, time;
static int[][] map;
static boolean[][] visited;

static int[] dx = {0, -1, 0, 1};
static int[] dy = {-1, 0, 1, 0};

// 치즈 : 1, 공기 : 2, 녹은 부분 : 3, 내부 공간 : 0
public static void main(String[] args) throws IOException {

    st = new StringTokenizer(br.readLine(), " ");
    r = Integer.parseInt(st.nextToken());  //
    c = Integer.parseInt(st.nextToken());
    map = new int[r][c];

    for(int i = 0; i < r; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        for(int j = 0; j < c; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    // 치즈 녹이기 시작
    while (true) {
        visited = new boolean[r][c];  // 방문 여부 배열 초기화
        // 가장자리에는 치즈가 없으므로
        // (0, 0) 부터 시작해서 공기 표시하기
        visited[0][0] = true;
        markOuter(0, 0);
        meltedToOuter();  // 녹은 부분을 공기로 만들기
        if(isEnd()) {  // 모든 부분이 다 공기로 바뀌면 반복 종료
            break;
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                // 치즈가 있으면 함수 실행
                if(map[i][j] == 1 && !visited[i][j]) {
                    melt(i, j);
                }
            }
        }
        time++;
    }
    System.out.println(time);
}

// 치즈가 없는 공간 중 외부만 공기로 만들기
// 넓이우선탐색
static void markOuter(int x, int y) {

    visited[x][y] = true;
    map[x][y] = 2;

    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(check(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
            markOuter(nx, ny);
        }
    }
}

// 녹은 부분을 공기로 바꿔주기
static void meltedToOuter() {
    for(int i = 0; i < r; i++) {
        for(int j = 0; j < c; j++) {
            if(map[i][j] == 3) {
                map[i][j] = 2;
            }
        }
    }
}

// 치즈 녹이기
static void melt(int x, int y) {

    visited[x][y] = true;
    if(isEdge(x, y)) {  // isEdge()로 공기와 두 면 이상 닿아있는지 확인
        map[x][y] = 3;
    }

    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(check(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
            melt(nx, ny);
        }
    }
}

static boolean isEnd() {
    for(int i = 0; i < r; i++) {
        for(int j = 0; j < c; j++) {
            if(map[i][j] != 2) {
                return false;
            }
        }
    }
    return true;
}

static boolean isEdge(int x, int y) {
    int cnt = 0;

    for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        // 주변이 바깥공기인 2와 인접했으면 cnt 값 증가
        if(check(nx, ny) && map[nx][ny] == 2) {
            cnt++;
        }
    }

    // 두 면 이상 닿아있으면 녹을 수 있는 치즈로 판별
    if(cnt >= 2) {
        return true;
    }
    return false;
}

static boolean check(int x, int y) {
    if(x < 0 || x >= r || y < 0 || y >= c) return false;
    return true;
}
}