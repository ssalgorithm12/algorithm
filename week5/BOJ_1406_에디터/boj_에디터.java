package algorithm;

import java.io.*;
import java.util.*;


// 메모리 : 73204, 시간 : 460
public class boj_에디터 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n;
	static String s;
	static Stack<Character> stackL;
	static Stack<Character> stackR;
	
	
	public static void main(String[] args) throws IOException {
		
		stackL = new Stack<>();  // 커서 포함 왼쪽 문자 담을 스택
		stackR = new Stack<>();  // 커서 기준 오른쪽 문자 담을 스택
		
		s = br.readLine();
		n = Integer.parseInt(br.readLine());
		for(int i = 0; i < s.length(); i++) {
			stackL.push(s.charAt(i));
		}
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			
			// 현재 커서 위치에 문자 추가하기
			if(s.charAt(0) == 'P') {
				stackL.push(s.charAt(2));
				
			// 현재 커서에 있는 문자를 오른쪽으로 옮겨서 커서를 왼쪽으로 옮기기
			} else if(s.charAt(0) == 'L' && !stackL.isEmpty()) {
				stackR.push(stackL.pop());
				
			// 현재 커서에 있는 문자를 삭제하기
			} else if(s.charAt(0) == 'B' && !stackL.isEmpty()) {
				stackL.pop();
			
			// 커서를 오른쪽으로 옮기기
			} else if(s.charAt(0) == 'D' && !stackR.isEmpty()) {
				stackL.push(stackR.pop());
			}
		}
		
		// 왼쪽 스택에 있는걸 다 오른쪽 스택으로 옮기기
		while (!stackL.isEmpty()) {
			stackR.push(stackL.pop());
		}
		
		// 오른쪽 스택에 있는 문자 다 빼내면 원래 순서로 돌아옮
		while (!stackR.isEmpty()) {
			sb.append(stackR.pop());
		}
		
		System.out.println(sb);
	}

}
