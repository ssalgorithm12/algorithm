import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

//메모리: 14628kb, 시간: 116ms

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[n]; 

		// 스위치 배열 입력 
		for(int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

		// 학생 수 
		int m = Integer.parseInt(br.readLine());

		// 명령 실행 
		for(int i = 0; i < m; i++) {
			String[] str = br.readLine().split(" ");
			// 남자일 경우 
			if(str[0].equals("1")) {
				int b = Integer.parseInt(str[1]);
				// b에 c를 곱해줘서 b의 배수를 구한다. 
				int c = 1;
				// n의 범위를 벗어나면 while 문 종료 
				while(b*c<=n){
					// xor 연산으로 스위치 전환 
					a[b*c-1] = a[b*c-1]^1;
					c++;
				}
			}
			// 여자일 경우 
			else {
				int b = Integer.parseInt(str[1]);
				int c = 1; 
				a[b-1] = a[b-1]^1;
				// 한 쪽이 밭깥으로 벗어날 경우 
				while(b+c-1<n && b-c-1>=0) {
					// b를 중심으로 대칭되는 두 지점 
					if(a[b+c-1]==a[b-c-1]) {
						a[b+c-1] = a[b+c-1]^1;
						a[b-c-1] = a[b-c-1]^1;
						c++;
					}
					else break;
				}
			}
		}

		// 결과 출력 
		for(int i = 1; i <= n; i++) {
			sb.append(a[i-1]+" ");
			// %20이 0이 될 때마다 -> 20개씩 출력될 때마다 줄바꿈 시행 
			if(i%20==0) sb.append("\n"); 
		}
		
		System.out.print(sb);
	}
}
