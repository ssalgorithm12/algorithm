package algol0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.Iterator;

public class Boj_1406{

	static int orderLength;								// 명령 길이
	static Stack<Character> word;				// 글자 Stack
	static Stack<Character> container;			// 마우스 이동시 보관할 Stack
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		word = new Stack<>();
		container = new Stack<>();
		
		for(int i=0; i<input.length; i++) {
			word.push(input[i]);
		}
		
		orderLength = Integer.parseInt(br.readLine());
		
		for(int i=0; i<orderLength; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			// P는 문자 입력
			if(order.equals("P")) {
				word.push(st.nextToken().toCharArray()[0]);
			}else if(order.equals("L")) {
				// 왼쪽으로 옮기면서 스택에서 빠진 값 컨테이너에 저장
				if(!word.isEmpty()) {
					container.push(word.pop());
				}
			}else if(order.equals("B")) {
				// 만약 문자가 있다면 삭제
				if(!word.isEmpty()) {
					word.pop();
				}
			}else if(order.equals("D")) {
				// 컨테이너에 저장해놓은 값 다시 스택에 저장
				if(!container.isEmpty()) {
					word.push(container.pop());
				}
			}
		}
		
		while(!container.isEmpty()) {
			word.push(container.pop());
		}
		
		Iterator<Character> iterator = word.iterator();
		
		while(iterator.hasNext()) {
			result.append(iterator.next());
		}
		
		System.out.println(result);
	}
}
