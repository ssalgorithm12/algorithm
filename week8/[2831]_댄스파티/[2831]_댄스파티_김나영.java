import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// 메모리 : 43828	KB  시간 : 656 MS
public class boj_2831_댄스파티_김나영 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, max, n;
	static List<Integer> bMinus, bPlus, gMinus, gPlus;
	static boolean [] visited;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		bMinus = new ArrayList<>();
		bPlus = new ArrayList<>();
		gMinus = new ArrayList<>();
		gPlus = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			
			if (n > 0) bPlus.add(n);
			else bMinus.add(-n);
		}
		
		Collections.sort(bMinus);
		Collections.sort(bPlus);

		int n1 = 0;
		int n2 = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			
			if (n > 0) gPlus.add(n);
			else gMinus.add(-n);
		}
		
		Collections.sort(gMinus);
		Collections.sort(gPlus);
		
		if(bMinus.size()!=0 && gPlus.size()!=0) {
			for (int i = 0; i < gPlus.size(); i++) {
				while (n1 < bMinus.size() && !(gPlus.get(i) < bMinus.get(n1))){
					n1++;
				}
				if (n1 >= bMinus.size()) break;
				max++;
				n1++;
			}
		}
		
		
		if(bPlus.size()!=0 && gMinus.size()!=0) {
			for (int i = 0; i < bPlus.size(); i++) {
				while (n2 < gMinus.size() && !(bPlus.get(i) < gMinus.get(n2))){
					n2++;
				}
				if (n2 >= gMinus.size()) break;
				max++;
				n2++;
			}
		}
		
		System.out.println(max);
	}

}