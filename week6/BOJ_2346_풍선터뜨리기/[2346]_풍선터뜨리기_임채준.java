package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2346_풍선터뜨리기 {
	
	static int N;
	static Queue<Integer> bals;
	static Queue<Integer> nums;
	static Queue<Integer> ans;
	static Stack<Integer> tempb;
	static Stack<Integer> tempn;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		bals = new LinkedList<>();
		nums = new LinkedList<>();
		tempb = new Stack<>();
		tempn = new Stack<>();
		ans = new LinkedList<>();
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums.offer(Integer.parseInt(st.nextToken()));
			bals.offer(i);
		}
		
		int count = N - 1;
		ans.offer(bals.poll());
		int n = nums.poll();
		while(!nums.isEmpty()) {			
			if(n > 0) {
				for(int i = 0; i < n - 1; i++) {
					tempb.push(bals.poll());
					tempn.push(nums.poll());
				}
				if(tempb.isEmpty()) {
					ans.offer(bals.poll());
					n = nums.poll();
					count--;
				} else {
					ans.offer(bals.poll());
					n = nums.poll();
					for(int i = 0; i < n - 1; i++) {
						if(tempb.isEmpty()) break;
						bals.offer(tempb.pop());
						nums.offer(tempn.pop());
					}
					count--;
				}			
			} else if(n < 0) {
				for(int i = 0; i < count + n - 1; i++) {
					tempb.push(bals.poll());
					tempn.push(nums.poll());
				}
				if(tempb.isEmpty()) {
					ans.offer(bals.poll());
					n = nums.poll();
				} else {
					ans.offer(bals.poll());
					n = nums.poll();
					for(int i = 0; i < count + n - 1; i++) {
						if(tempb.isEmpty()) break;
						bals.offer(tempb.pop());
						nums.offer(tempn.pop());
					}
					count--;
				}			
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(ans.poll() + " ");
		}
		System.out.println(sb.toString());
	}

}
