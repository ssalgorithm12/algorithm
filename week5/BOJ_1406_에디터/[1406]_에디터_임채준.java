package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1406에디터_임채준 {
	
	static int N; // 총 진행할 단계 수 
	static char[] chars; // 처음 주어진 문자열 저장 배열 
	static char[] temp; // 각 실행 단계 문자 저장 배열  
	static Stack<Character> save; // 커서 오른쪽을 표현할 스택  
	static Stack<Character> stack; // 커서 왼쪽을 표현할 스택  

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		chars = br.readLine().toCharArray(); // 처음 시작할 문자열 chararray로 받기 
		int len = chars.length; // 첫 문자 배열 길이 저장 
		
		// 모든 문자들 스택에 저장 
		stack = new Stack<Character>(); 
		for(int i = 0; i < len; i++) {
			stack.push(chars[i]);
		}
		// 총 실행할 동작 수 저장 
		N = Integer.parseInt(br.readLine());
		
		// 커서 오른쪽을 표현하는 스택 생성  
		save = new Stack<Character>();
		
		// 커서는 두 스택의 가운데라고 생각하시면 되겠죠?? 
		
		// 실행할 동작 하나씩 받기 문자 배열로 받기  
		for(int i = 0; i < N; i++) {
			temp = br.readLine().trim().toCharArray();
			// 실행 동작이 P이면 커서 왼쪽에 넣기 
			if(temp[0] == 'P') {
				stack.push(temp[2]);
			// 실행 동작이 L이면 커서 왼쪽 스택에서 오른쪽으로 하나 넘기기 
			} else if(temp[0] == 'L') {
				if(!stack.isEmpty()) {
					save.push(stack.pop());
				// 왼쪽이 비었으면 그대로니까 넘어가기 
				} else {
					continue;
				}	
			// 실행 동작이 D이면 오른쪽 스택에서 왼쪽 스택으로 하나 넘기기 
			} else if(temp[0] == 'D') {
				if(!save.isEmpty()) {
					stack.push(save.pop());
				// 오른쪽 스택이 비었으면 그대로니까 넘어가기 
				} else {
					continue;
				}
			// 실행 동작이 B이면 커서 왼쪽 스택에서 하나 빼기 
			} else if(temp[0] == 'B') {
				if(!stack.isEmpty()) {
					stack.pop();
				// 커서 왼쪽이 비었으면 그대로니까 넘어가기 
				} else {
					continue;
				}
			}			
		}
		// 스택을 출력할 요소들이 맨 뒤에서부터 나오니까 커서 왼쪽 스택에 남은 모든 요소를 오른쪽 스택으로 옮기기 
		if(!stack.isEmpty()) {
			while(!stack.isEmpty()) {
				save.push(stack.pop());
			}
		}
		// 오른쪽으로 넘긴 요소들은 맨 뒤에서부터 StringBuilder에 저장되겠죠? 
		StringBuilder sb = new StringBuilder();
		int leng = save.size();
		for(int i = 0; i < leng; i++) {
			sb.append(save.pop());
		}
		// 스택에 쌓인 모든 실행을 마친 문자열 출력 
		System.out.println(sb.toString());	
	}
}