package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea_1234비밀번호_임채준 {

	static int T = 10;
	static int len;
	static char[] inputs;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= T; t++) {		
			StringTokenizer st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			inputs = st.nextToken().toCharArray();
			Stack<Integer> nums = new Stack<>();
			Stack<Integer> temp = new Stack<>();
			
			for(int i = 0; i < len; i++) {
				int num = inputs[i] - '0';
				nums.push(num);
			}
			while(!nums.isEmpty()) {
				int p = nums.pop();
				if(!nums.isEmpty() && p == nums.peek()) {
					nums.pop();
				} else {
					if(temp.isEmpty()) {
						temp.push(p);
					} else if(temp.peek() == p) {
						temp.pop();
					} else {
						temp.push(p);
					}
				}
			
			}
			
			
			StringBuilder result = new StringBuilder();
            while(!temp.isEmpty()) {
                result.append(temp.pop());
            }
			System.out.println("#"+t+" "+result.toString());
			
		}

	}

}
