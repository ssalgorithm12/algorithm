package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1715_카드정렬하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, n, ans;
    static PriorityQueue<Integer> arr;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			arr.offer(Integer.parseInt(br.readLine()));
		}
		
		while (arr.size()!=1) {
			n  = arr.poll()+arr.poll();
			ans += n;
			arr.offer(n);
		}
		
		System.out.println(ans);
		
	}

}
