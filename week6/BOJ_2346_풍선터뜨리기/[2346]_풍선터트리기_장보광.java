package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2346_풍선터트리기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int count = n;
		LinkedList<Integer> ll = new LinkedList<>();
		int[] order = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= n; i++) ll.add(i);
		for(int i = 1; i <= n; i++) order[i] = Integer.parseInt(st.nextToken());
		
		int now = 0;
		
		for(int i = 0; i < n - 1; i++) {
			int num = ll.get(now);
			int now_order = order[num];
			sb.append(num+" ");
			ll.remove(now);
			count = ll.size();
			if(now_order > 0) {
				now += (now_order - 1);
				if(now >= count) now = now%count;
			}
			else {
				now -= now_order;
				if(now < 0) {
					int temp = (now*-1)%count;
					if(temp == 0) now = 0;
					else now = count - temp;
				}
			}
		}
		sb.append(ll.get(0));
		System.out.print(sb);
	}
}
