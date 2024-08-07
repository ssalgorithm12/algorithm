package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea_1234비밀번호_임채준 {

	static int T = 10; // 테스트케이스 변수 선언 및 초기
	static int len; // 입력 문자열 길이 변수 선언
	static char[] inputs; // 입력 문자열 받는 배열 선언
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // bufferedreader 객체 생성
		
		for(int t = 1; t <= T; t++) { // 모든 테스트케이스에 대하여
			StringTokenizer st = new StringTokenizer(br.readLine()); // stringtokenizer 객체생성 및 입력 받은 라인 토큰화
			len = Integer.parseInt(st.nextToken()); // 첫 토큰은 입력값의 길이
			inputs = st.nextToken().toCharArray(); // 입력값은 char array에 저장
			Stack<Integer> nums = new Stack<>(); // 입력값을 우선 받을 stack 생성
			Stack<Integer> temp = new Stack<>(); // 일부 값들을 일시적으로 받아둘 stack 생성
			
			for(int i = 0; i < len; i++) { // 입력값의 길이만큼에 대하여
				int num = inputs[i] - '0'; // char array에 저장해둔 요소들을 정수로 변환
				nums.push(num); // 정수로 변환한 모든 요소들을 stack에 밀어넣기
			}
			while(!nums.isEmpty()) { // nums stack이 비워질 때까지
				int p = nums.pop(); // 가장 뒤에있는 요소 하나 꺼내기
				if(!nums.isEmpty() && p == nums.peek()) { // nums stack안에 요소가 있고, 꺼낸 요소와 그 다음으로 맨 뒤에있는 요소와 꺼낸 요소의 값이 같다면
					nums.pop(); //nums 안에 있는 같은 값을 가진 요소 stack에서 제거
				} else { // nums에서 꺼낸 요소의 값과 그 다음으로 맨 뒤에 있는 값이 다르다면
					if(temp.isEmpty()) { // temp stack이 비어있다면
						temp.push(p); // 꺼낸 요소 temp에 집어넣기
					} else if(temp.peek() == p) { // temp stack에 있는 맨 뒤의 요소와 꺼낸 값이 같다면 
						temp.pop(); // temp에 있는 맨 뒤의 요소 제거
					} else {  // 꺼낸 값과 temp 맨 뒤의 요소의 값이 같지 않다면 
						temp.push(p); // 꺼낸 값 temp에 넣기
					}
				}
			
			}
			
			
			StringBuilder result = new StringBuilder(); // stack에 있는 요소들 하나의 string으로 반환하기 위한 stringbuilder 객체 생성
            while(!temp.isEmpty()) { // temp가 비워질 때까지
                result.append(temp.pop()); // stringbuilder 변수에 temp 맨 마지막부터 비워질때까지 다 합치기
            }
			System.out.println("#"+t+" "+result.toString()); // 다 합친 stringbuilder 변수 문자열로 변환 후 출력
			
		}

	}

}
