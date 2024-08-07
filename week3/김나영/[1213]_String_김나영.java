import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1213_String_김나영 {

	static int T = 10;
	static int N;
	static String s;
	static char[] s2;
	static boolean isS;
	static int sum;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			sum = 0;
			
			s = br.readLine();
			s2 = br.readLine().toCharArray();
			
			// 슬라이스윈도우로 s2에 s와 같은 부분이 있는지 확인
			for (int i = 0; i < s2.length-s.length()+1; i++) {
				isS = true;
				for (int j = 0; j < s.length(); j++) {
					if(!(s.charAt(j)==s2[j+i])) {
						isS = false;
						break;
					}
				}
				if(isS) sum++;
			}
			System.out.println("#" + N + " " + sum);
		}
		
	}

}
