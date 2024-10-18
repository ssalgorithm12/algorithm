package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16928_뱀과사다리게임 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, ans=Integer.MAX_VALUE;
	static int [][] ladder, snake;
	static HashMap<Integer, Integer> ladder2, snake2;
	static int [] visited;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		snake = new int [M][M];
		ladder2 = new HashMap<>();
		snake2 = new HashMap<>();
		visited = new int [101];
		Arrays.fill(visited, Integer.MAX_VALUE);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ladder2.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			snake2.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		bfs();
		
		System.out.println(ans);
		
	}

	static void bfs() {
		Queue<int []> que = new LinkedList<>();
		que.offer(new int [] {1, 0});
		
		while(!que.isEmpty()) {
			int [] arr = que.poll();
			
			if (arr[0]==100) {
				ans = Math.min(ans, arr[1]);
			}
			
			if (arr[0] <= 100 && visited[arr[0]] > arr[1]) {
				visited[arr[0]] = arr[1];
				int a = 0;
				if (ladder2.containsKey(arr[0])) {
					a = ladder2.get(arr[0]);
					que.offer(new int [] {a, arr[1]});
				} else if (snake2.containsKey(arr[0])) {
					a = snake2.get(arr[0]);
					que.offer(new int [] {a, arr[1]});
				} else {
					for (int i = 6; i > 0; i--) {
						a = arr[0] + i;
						que.offer(new int [] {a, arr[1]+1});
					}
				}
			}
			
		}
	}
}