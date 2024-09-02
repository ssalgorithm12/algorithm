package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;

// 무한하게 큰 수를 넣을 수 있는 BigInteger
// 메모리 150,180KB, 시간 816ms

public class BOJ_13305_주유소{

	static int N;
	static BigInteger[] distance;
	static BigInteger[] oilBank;
	static BigInteger cost;

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		distance = new BigInteger[N-1];
		oilBank = new BigInteger[N];
		cost = new BigInteger("0");
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<distance.length; i++) {
			distance[i] = new BigInteger(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		oilBank[0] = new BigInteger(st.nextToken());
		
		for(int i=1; i<oilBank.length; i++) {
			oilBank[i] = new BigInteger(st.nextToken());
			
			// 앞의 주유소보다 크면 앞의 주유소 가격 가져가기
			if(oilBank[i].compareTo(oilBank[i-1]) == 1) {
				oilBank[i] = new BigInteger(oilBank[i-1].toString());
			}
			
			// 전체 가격을 담을 String
			String newCost = cost.add(oilBank[i-1].multiply(distance[i-1])).toString();
			
			cost = new BigInteger(newCost);
		}
		
		System.out.println(cost.toString());
	}
}
