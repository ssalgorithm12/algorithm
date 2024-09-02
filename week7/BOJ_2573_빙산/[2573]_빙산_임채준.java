package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리: 136208KB 시간: 476ms

public class Boj_2573_빙산 {
	
    static int N, M; // 바다의 세로 길이와 가로 길이를 저장할 변수 선언 
    static int[][] ice; // 바다의 상태를 나타낼 2차원 배열 선언 
    static boolean[][] visited; // 바다의 각 칸을 방문했는지 표시하기 위한 2차원 배열 선언
    static int[] dr = {-1, 0, 1, 0}; // 4방 행 움직임 배열
    static int[] dc = {0, 1, 0, -1}; // 4방 열 움직임 배열 

    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로길이 받고
        M = Integer.parseInt(st.nextToken()); // 가로길이 받고
        ice = new int[N][M]; // 변 길이 대입하여 크기대로 바다 생성 

        // 바다의 각 칸 입력 받기 
        for (int r = 0; r < N; r++) {
        	st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                ice[r][c] = Integer.parseInt(st.nextToken()); 
            }
        }

        // 몇 년 후 빙산이 두 동강 나는지 저장하는 변수 
        int year = 0;
        
        
        while (true) { // 무한 루프 때리고 종료 조건으로 함수 종료
            int count = countice(); // 빙산 덩이수 저장 
            if (count >= 2) { // 빙산 덩이수가 2개 이상이면 
                System.out.println(year); // 몇년 걸렸는지 반환 
                break; // while문 종료
            }
            if (count == 0) { // 덩이수가 0이라면
                System.out.println(0); // 0반환
                break; // 종료
            }
            melt(); // 둘다 아니면 덩이수가 여전히 하나라는 소리겠죠? 그럼 다시 1년 진행하고 빙산 녹여
            year++; // 연차 증가
        }
    }

    // 빙산이 1년 진행시 녹은 상태를 반환하는 함수 
    static void melt() {
        int[][] temp = new int[N][M]; // 1년 뒤의 바다의 상태를 표현하기 위해 각 칸을 임시로 받을 2차원 배열 생성 
        for (int r = 0; r < N; r++) { // 모든 행과
            for (int c = 0; c < M; c++) { // 모든 열에 대해 
                if (ice[r][c] > 0) { // 해당 칸의 값이 0보다 크다면 
                    int seaCount = 0; // 빙산을 둘러싼 바다가 몇 면인지 세어줄 변수 생성 
                    for (int d = 0; d < 4; d++) { // 4방에 대하여 
                        int nr = r + dr[d]; // 4방 행 움직임
                        int nc = c + dc[d]; // 4방 열 움직임 
                        if (nr >= 0 && nc >= 0 && nr < N && nc < M && ice[nr][nc] == 0) { // 4방 중 좌표가 범위 내에 있고 값이 0이라면
                            seaCount++; // 바다임을 알려주는 변수 1증가 
                        }
                    }
                    temp[r][c] = Math.max(ice[r][c] - seaCount, 0); // 해당 칸의 값은 현재값 - 주변 바다 개수 혹은 그 값이 0보다 작다면 0이겠죠?
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                ice[r][c] = temp[r][c]; // 1년 진행 상황을 원래 바다 상태에 복사
            }
        }
    }

    // 바다에 빙산이 총 몇 덩이인지 반환하는 함수 
    static int countice() {
        visited = new boolean[N][M]; // 방문 기록 2차원 배열 생성 
        int count = 0; // 빙산이 몇 덩이인지 저장하는 변수 생성 

        for (int r = 0; r < N; r++) { // 바다의 모든 행과
            for (int c = 0; c < M; c++) { // 모든 열에 대해서 
                if (ice[r][c] > 0 && !visited[r][c]) { // 해당 칸의 값이 0보다 크고 방문 기록이 없다면 
                    dfs(r, c); // 해당 칸에 대해서 dfs함수 실행
                    count++; // 위 함수가 끝나면 빙산 덩이 수 1 증가
                }
            }
        }
        return count; // 빙산 덩이 수 반환 
    }

    // 이어져 있는 빙산 개수를 세기 위한 함수 
    static void dfs(int r, int c) {
        visited[r][c] = true; // 들어온 좌표에 대해서는 방문 기록에 참 값을 준다 

        for (int d = 0; d < 4; d++) { // 4방의
            int nr = r + dr[d]; // 행과
            int nc = c + dc[d]; // 열에 대해 
            if (nr >= 0 && nc >= 0 && nr < N && nc < M && ice[nr][nc] > 0 && !visited[nr][nc]) { // 범위 내에 있고 해당 값이 0보다 크고 방문 기록이 없다면 
                dfs(nr, nc); // 해당 칸에 대해서도 함수 실행
            }
        }
    }
}
