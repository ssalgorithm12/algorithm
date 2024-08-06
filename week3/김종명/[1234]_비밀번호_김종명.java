package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Swea_1234 {
	
	static int testCase = 10;
	static int caseLength;
	static char[] numbers;
	static Stack<Character> stack;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			stack = new Stack<>();
			
			caseLength = Integer.parseInt(st.nextToken());
			numbers = st.nextToken().toCharArray();
			
			for(int i=numbers.length-1; i>=0; i--) {
				if(stack.empty()) {
					stack.push(numbers[i]);
				}else {
					if(stack.peek() == numbers[i]) {
						stack.pop();
					}else if(stack.peek() != numbers[i]) {
						stack.push(numbers[i]);
					}
				}
			}

			
			result.append("#" + (t+1) + " ");
			while(!stack.empty()) {
				result.append(stack.pop());
			}
			result.append("\n");
		}
		System.out.println(result);
	}

}
