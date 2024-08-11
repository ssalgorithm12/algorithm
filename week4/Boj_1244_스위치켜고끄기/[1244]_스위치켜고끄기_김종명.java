import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 메모리 : 14212KB, 시간 : 100ms

public class Boj_1244 {
	
	// 변수
	static int switchCount;
	static boolean[] switches;
	static int studentCount;
	static int gender;
	static int givenNumber;
	
	// 출력 값 저장용 StringBuilder
	static StringBuilder result = new StringBuilder();
	
	// 스위치 조작을 명령 하는 함수
	static void swapSwitches(int gender, int givenNumber) {
		
		if(gender > 1) {
			girlSwap(givenNumber);
		}else {
			boySwap(givenNumber);
		}
	}
	
	// 남자일 경우 스위치 조작 방법
	static void boySwap(int givenNumber) {
		for(int i=0; i<switchCount; i++) {
			if((i+1) % givenNumber == 0) {
				switches[i] = !switches[i];
			}
		}
	}
	
	// 여자일 경우 스위치 조작 방법
	static void girlSwap(int givenNumber) {
		int index = givenNumber - 1;
		int step = 0;
		
		// IndexOutOfBounds 안 나오는 선에서 while문 실행 
		while(index - step >= 0  && index + step < switchCount) {
			
			// 좌우 대칭 스위치 상태 비교
			boolean ruleValid = (switches[index-step] == switches[index+step]);
			
			if(ruleValid) {
				if(step == 0) {
					// step이 0일 경우 스위치 한개
					switches[index-step] = !switches[index-step];
				}else {
					// step이 0이 아닐 경우 스위치 두개
					switches[index-step] = !switches[index-step];
					switches[index+step] = !switches[index+step];
				}
			}else {
				break;
			}
			
			// 좌우로 하나 씩 넓혀 가기 위한 step
			step++;
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 값 입력 부분
		switchCount = Integer.parseInt(br.readLine());
		switches = new boolean[switchCount];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<switchCount; i++) {
			int input = Integer.parseInt(st.nextToken());
			if(input == 1) {
				switches[i] = true;
			}
		}
		
		studentCount = Integer.parseInt(br.readLine());
		for(int i=0; i<studentCount; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			givenNumber = Integer.parseInt(st.nextToken());
			
			// 스위치 조작 함수
			swapSwitches(gender, givenNumber);
		}
		
		// 결과 값 출력용 StringBuilder에 저장 
		for(int i=0; i<switchCount; i++) {
			if(switches[i]) {
				result.append("1 ");
			}else {
				result.append("0 ");
			}
			
			if((i+1) % 20 == 0) {
				result.append("\n");
			}
		}

		// 출력
		System.out.println(result);
	}
}
