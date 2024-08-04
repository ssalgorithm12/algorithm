import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Swea_1248 {

	static int testCase;
	static int V;
	static int E;
	static int numberA;
	static int numberB;
	static int[] map;
	static List<Integer> wayA = new ArrayList<>();
	static List<Integer> wayB = new ArrayList<>();
	static int motherRoot;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			numberA = Integer.parseInt(st.nextToken());
			numberB = Integer.parseInt(st.nextToken());
			map = new int[V + 1];
			
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int firstNumber = Integer.parseInt(st.nextToken());
				int secondNumber = Integer.parseInt(st.nextToken());
				
				map[secondNumber] = firstNumber;
			}
			
			int way = numberA;
			
			while(way != 0) {
				wayA.add(map[way]);
				way = map[way];
			}
			
			way = numberB;
			while(way != 0) {
				wayB.add(map[way]);
				way = map[way];
			}
			
			
			for(int i=wayA.size()-1; i>=0; i--) {
				if(wayB.contains(wayA.get(i))) {
					motherRoot = wayA.get(i);
				}
			}
			
			System.out.println(motherRoot);

			
		}
		
	}

}
