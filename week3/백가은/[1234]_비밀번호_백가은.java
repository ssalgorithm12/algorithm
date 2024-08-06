package study;

import java.io.*;
import java.util.*;

public class 비밀번호 {
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int len;
	static String[] nums;
	static Stack<Integer> stack;
	static String ans;
	
	public static void main(String[] args) throws IOException  {
		
		
		for(int tc = 0; tc < 10; tc++) {
			
			sb.append("#").append(tc + 1).append(" ");
			stack = new Stack<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			len = Integer.parseInt(st.nextToken());
			nums = st.nextToken().split("");
			
			for(int i = 0; i < len; i++) {
				
				
				if(!stack.isEmpty() && Integer.parseInt(nums[i])== stack.peek()) {
					stack.pop();
				} else {
					stack.push(Integer.parseInt(nums[i]));
				}
			}
			
			ans = "";
			Iterator<Integer> iterator = stack.iterator();
			while (iterator.hasNext()) {
				ans += String.valueOf(iterator.next());
				
			}
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

}
