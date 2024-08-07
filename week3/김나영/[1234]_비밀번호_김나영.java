import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1234_비밀번호_김나영 {

	static int T = 10;
	static int N;
	static String s;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder(st.nextToken());
			
			// 슬라이딩 윈도우로 2칸씩 숫자가 같은지 확인
			for (int i = 0; i < sb.length()-1; i++) {
				// 만약 같다면 해당 숫자들을 삭제한다.
				// i가 0이면 index -1, 아니면 index-2를 해 줌
				if (sb.charAt(i)==sb.charAt(i+1)) {
					sb.delete(i, i+2);
					if(i!=0) i -= 2;
					else i -= 1;
				}
			}
			
			System.out.println("#" + t + " " + sb);
			
		}
		
	}

}
