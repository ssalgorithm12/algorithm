package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1244스위치켜고끄기_임채준 {

    static int num; // 스위치 개수를 저장하는 변수 선언
    static int[] status; // 스위치 상태를 저장하는 1차원 배열 선언

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력값 받는 BufferedReader 객체 생성
        num = Integer.parseInt(br.readLine()); // 스위치 개수 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine()); // 각 스위치 상태를 입력받기 위한 StringTokenizer 객체 선언 및 생성
        status = new int[num + 1]; // 스위치 개수보다 하나 크게 1차원 배열 생성
        for (int i = 1; i <= num; i++) { // 배열의 1번 인덱스부터 모든 스위치에 대하여
            status[i] = Integer.parseInt(st.nextToken()); // 배열에 각각의 스위치 상태 입력받기
        }
        int len = Integer.parseInt(br.readLine()); // 학생수 저장 변수 선언 및 생성 후 입력 받기
        for (int i = 0; i < len; i++) { // 모든 학생들에 대하여 
            st = new StringTokenizer(br.readLine()); // StringTokenizer 객체를 통해
            int gen = Integer.parseInt(st.nextToken()); // 학생의 성별 입력받기
            int idx = Integer.parseInt(st.nextToken()); // 해당 학생이 시작할 스위치 상태 입력받기
            if (gen == 1) { // 학생이 남학생이라면 
                for (int j = idx; j <= num; j += idx) { // 시작 스위치로부터 스위치 인덱스의 배수 만큼 올라가며
                    status[j] = 1 - status[j]; // 스위치 상태 바꾸기
                }
            } else if (gen == 2) { // 학생이 여학생이라면
                status[idx] = 1 - status[idx]; // 먼저 받은 인덱스의 스위치 상태를 바꾸고
                int j = 1;
                while (idx - j > 0 && idx + j <= num) { // 스위치가 있는 범위 까지
                    if (status[idx - j] == status[idx + j]) { // 받은 스위치의 양 옆의 같은 거리의 스위치의 상태가 같다면
                        status[idx - j] = 1 - status[idx - j]; // 인덱스부터 일정 거리의 앞 스위치 상태 변환
                        status[idx + j] = 1 - status[idx + j]; // 인덱스부터 일정 거리의 뒷 스위치 상태 변환
                    } else {
                        break; // 탐색했을 때 양옆 일정 거리의 스위치 상태가 다르다면 반복문 종료
                    }
                    j++; // j를 하나씩 키워가며 탐색
                }
            }
        }
        StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder 객체 선언 및 생성
        for (int i = 1; i <= num; i++) { // 모든 스위치에 대해
            sb.append(status[i]).append(" "); // 모든 스위치 상태를 StringBuilder에 추가
            if (i % 20 == 0) sb.append("\n"); // 한 줄에 20개가 넘어가면 다음 줄로 넘어가기
        }
        System.out.println(sb.toString().trim()); // StringBuilder에 담긴 스위치 상태 String으로 결과 출력
    }
}
