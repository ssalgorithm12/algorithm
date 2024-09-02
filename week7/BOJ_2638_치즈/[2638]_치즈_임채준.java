package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리: 43248KB 시간: 208ms

public class Boj_2638_치즈 {

    static int N, M; // 모눈 종이의 세로와 가로 길이 변수 선언
    static int[][] map; // 모눈 종이 위 공기와 치즈 상태를 나타내는 2차원 배열 선언 
    static boolean[][] visited; // 방문 기록 저장할 2차원 배열 선언 
    static int[] dr = {-1, 0, 1, 0}; // 4방 행 움직임
    static int[] dc = {0, 1, 0, -1}; // 4방 열 움직임 
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 길이 받고 
        M = Integer.parseInt(st.nextToken()); // 가로 길이 받고 

        map = new int[N][M]; // 길이 받은 걸로 모눈 종이 총 크기만하게 생성 
        
        
        // 치즈 정보 입력 받기 
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0; // 치즈가 녹는 시간 

        while (true) { // 종료 조건으로 반복문 종료 
            visited = new boolean[N][M]; // 방문 기록을 저장할 2차원 배열 생성 
            Queue<int[]> que = new LinkedList<>(); // 가장 바깥에 있는 공기들을 찾기 위해 -> bfs를 사용하기위해 생성한 que
            que.offer(new int[]{0, 0}); // 맨 가장자리는 치즈가 아님을 보장, 0,0은 무조건 공기니까 0,0에서 바깥 공기 찾기 출발
            visited[0][0] = true; // 0,0 들어갔으니까 방문 기록은 참 

            // BFS로 외부 공기를 표시
            while (!que.isEmpty()) { // 바깥 공기가 모두 que에 들어왔다가 방문 기록 참을 찍고 모든 바깥 공기의 방문이 true일 때 까지 
                int[] cur = que.poll(); // que에 순서대로 들어온 바깥 공기 하나를 꺼내
                int r = cur[0]; // 행에 대해
                int c = cur[1]; // 열에 대해

                for (int d = 0; d < 4; d++) { // 4방의
                    int nr = r + dr[d]; // 행에 대해
                    int nc = c + dc[d]; // 열에 대해 

                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) { // 범위 안에 있고 방문이 false이면 
                        if (map[nr][nc] == 0) { // 그리고 해당 칸의 값이 0이면 즉 치즈가 아니라 공기면 
                            que.offer(new int[]{nr, nc}); // que에 해당 좌표 값 넣기 
                            visited[nr][nc] = true; // 그리고 그 좌표의 방문 기록은 참
                        }
                    }
                }
            }

            boolean melted = false;
            // 외부 공기와 접촉한 치즈 찾기
            for (int r = 0; r < N; r++) { // 모든 행에 대해
                for (int c = 0; c < M; c++) { // 모든 열에 대해
                    if (map[r][c] == 1) { // 값이 1이면
                        int count = 0; // 바깥 공기가 몇 면 닿아있는지 확인하는 변수 
                        for (int d = 0; d < 4; d++) { // 4방에 대해 
                            int nr = r + dr[d]; // 행에 대해
                            int nc = c + dc[d]; // 열에 대해 
                            if (visited[nr][nc]) { // 해당 칸의 방문 기록이 참이라면
                                count++; // 닿은 면 개수 1 증가
                            }
                        }

                        // 치즈가 녹는 조건 체크
                        if (count >= 2) { // 닿은 면이 2개 이상이면 
                            map[r][c] = 0;  // 치즈 녹이기
                            melted = true;
                        }
                    }
                }
            }

            if (!melted) break;  // 더 이상 녹일 치즈가 없으면 종료
            time++; // 시간 1단위 증가 
        }

        System.out.println(time); // 치즈가 다 녹은 시간 반환 
    }
}
