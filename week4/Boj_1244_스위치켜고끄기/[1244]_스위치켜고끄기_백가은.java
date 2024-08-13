package study;

import java.io.*;
import java.util.*;


//메모리 : 14140kb, 시간 : 100ms
public class boj_스위치_켜고_끄기 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int switchCnt, studentCnt;
	static int[] status;
	
	public static void main(String[] args) throws IOException {
		
		switchCnt = Integer.parseInt(br.readLine());  // 스위치 개수
		status = new int[switchCnt + 1];  // 스위치 상태 배열
		
		st = new StringTokenizer(br.readLine(), " ");
		//스위치 상태를 배열의 인덱스 1부터 저장
		for(int i = 1; i <= switchCnt; i++) {
			status[i] = Integer.parseInt(st.nextToken());
		}
		
		studentCnt = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < studentCnt; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int gender = Integer.parseInt(st.nextToken());  //성별
			int num = Integer.parseInt(st.nextToken());  //받은 스위치 번호
			
			//남자인 경우
			if(gender == 1) {
				
				//받은 번호부터 시작해서 해당 수의 배수로 증가하면서 반복하며 배열 값 반대로 바꾸기
				for(int j = num; j <= switchCnt; j += num) {
					status[j] = (status[j] == 0 ? 1 : 0);
				}
				
			//여자인 경우	
			} else {
				
				//투포인터
				int s = num; //시작점
				int e = num; //마지막점
				
				//받은 번호의 값은 반대로 바꿔주기
				status[s] = (status[s] == 0 ? 1 : 0);
				
				while(true) {
					
					//만약 시작점와 마지막점을 1씩 옮길 수 있으면
					if(s - 1 >= 1 && e + 1 <= switchCnt) {
						
						//시작점과 마지막점을 1씩 옮겼을 때 대칭이 아니면 반복 종료
						if(status[--s] != status[++e]) {
							break;
							
						//대칭이면 값을 반대로 바꿔주기
						} else {
							status[s] = (status[s] == 0 ? 1 : 0);
							status[e] = status[s];
						}
					
					//범위 밖으로 나가면 반복 종료
					} else break;
				}
			}
		}
		
		for(int i = 1; i <= switchCnt; i++) {
			
			sb.append(status[i]);
			
			//마지막 스위치면 continue
			if(i == switchCnt) {
				continue;
				
			//인덱스가 20의 배수가 아니면 띄어쓰기
			} else if(i % 20 != 0) {
				sb.append(" ");
				
			//인덱스가 20의 배수이면 줄바꿈
			} else sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
