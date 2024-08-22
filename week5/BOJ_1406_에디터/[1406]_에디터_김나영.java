package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406_에디터 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Stack<Character> stack = new Stack<Character>(), editor = new Stack<Character>();
	static char[] charns;
	static int N;
	
	public static void main(String[] args) throws Exception {
		charns = br.readLine().toCharArray();
		
		N = Integer.parseInt(br.readLine());
		
		// stack으로 풀기
		for (int i = 0; i < charns.length; i++) {
			editor.push(charns[i]);
		}
		
		// stack을 두 개로 나누어 왼쪽 부분을 editor, 오른쪽 부분을 stack에 줌
		// 커서는 두 스택 사이에 위치하게 됨
		for (int i = 0; i < N; i++) {
			char [] c = br.readLine().replace(" ", "").toCharArray();
			if(c[0]=='P') {
				editor.push(c[1]);
			} else if(c[0]=='L' && !editor.empty()) {
				stack.push(editor.pop());
			} else if(c[0]=='D' && !stack.empty()) {
				editor.push(stack.pop());
			} else if(c[0]=='B' && !editor.empty()) {
				editor.pop();
			}
		}
		
		for (int i = 0; i < editor.size(); i++) {
			sb.append(editor.get(i));
		}
		
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}

}
