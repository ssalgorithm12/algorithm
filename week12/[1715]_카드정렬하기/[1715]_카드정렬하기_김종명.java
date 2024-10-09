package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.io.IOException;

public class Boj_1715 {

	static int N;
	static PriorityQueue<Long> arr;
	static long total;
	
	public static void main(String[] args)throws IOException {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new PriorityQueue<>();
		total = 0;
		
		for(int i=0; i<N; i++) {
			arr.offer(Long.parseLong(br.readLine()));
		}
		
		//
			
		while(arr.size() > 1) {
			
			long A = arr.poll();
			long B = arr.poll();
			
			total += (A + B);
			arr.offer(A + B);
		}
		
		System.out.println(total);
	}

}
