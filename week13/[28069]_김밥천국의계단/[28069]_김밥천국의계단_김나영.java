package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_28069_김밥천국의계단 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, k;
    static boolean[] visited; 
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (bfs()) System.out.println("minigimbob");
		else System.out.println("water");
		
	}

	// bfs로 N까지 갈 수 있는지 확인
	static boolean bfs() {
		// N번째 계단에 K번에 도착했는지 확인
		visited = new boolean [N+1];
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {0, 0});
		
		while (!que.isEmpty()) {
			int[] q = que.poll();
			
			// 계단이 N보다 크거나 횟수가 K를 넘어갔거나 방문했으면 continue
			if(q[1] > K  || q[0] > N || visited[q[0]]) continue;
			visited[q[0]] = true;
			
			// N번째 계단에 도착했으면 break
			// K보다 적은 횟수에 도착했어도 0번째 계단에서 횟수를 조절할 수 있으므로 상관없다
			if(q[0]==N) {
				return true;
			}
			
			// 방문하지 않은 계단이면 두 가지 방법을 que에 넣음
			que.offer(new int[] {q[0]+1, q[1]+1});
			que.offer(new int[] {q[0]+(int)q[0]/2, q[1]+1});
		}
		
		return false;
		
	}

}
