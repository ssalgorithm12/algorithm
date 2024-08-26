package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 : 35652	 시간 : 436
public class boj_21278_호석이두마리치킨_김나영 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, sum = Integer.MAX_VALUE;
	static int [] arr, result = new int [2];
	static List<Integer> list[];
	static boolean [] visited;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list  = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		int [] dis;
        for(int i=1; i<= N-1; i++){
            dis = new int[N+1];
            Arrays.fill(dis, Integer.MAX_VALUE);

            for(int j=i+1; j<=N; j++){
                // i,j 위치에 치킨집을 설치했다고 가정
                dis[i] = dis[j] = 0;
                int temp = bfs(i,j, dis);

                if(sum > temp){
                    result[0] = i;
                    result[1] = j;
                    sum = temp;
                }
            }
        }
        sb.append(result[0]).append(" ").append(result[1]).append(" ").append(sum*2);
        System.out.println(sb);
    }


	static int bfs(int cnt, int cnt2, int [] dis) {
		visited = new boolean [N+1];
		int bfs_sum = 0;
		Queue<Integer> que = new ArrayDeque();
		que.offer(cnt);
		que.offer(cnt2);
		visited[cnt] = visited[cnt2] = true;
		
		while (!que.isEmpty()) {
			int n = que.poll();
			for (int i : list[n]) {
				if (!visited[i]) {
					visited[i] = true;
					dis[i] = dis[n]+1;
					bfs_sum += dis[i];
					que.offer(i);
				}
			}
		}
		return bfs_sum;
	}
	
//	static void dfs(int cnt) {
//		visited[cnt] = true;
//		for (int i = 0; i <= list.length; i++) {
//			if(!visited[cnt]) {
//				visited[i] = true;
//				dfs(i);
//			}
//		}
//	}
	
}
