package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Swea_1213string_임채준2 {
	
	static int T = 10; // 테스트케이스 
    static String find; // 찾는 문자열의 길이
    static char[] sentence; // 총 문자열의 길이
    static String[] sum;
    static int test; // 테스트케이스 숫자

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //bufferedreader 객체생
		for(int t = 1; t <= T; t++) { // 테스트케이스 수에 대해
	        test = Integer.parseInt(br.readLine()); // 테스트케이스 숫자 받기
	        find = br.readLine(); // 찾는 문자열 받기
	        int finlen = find.length(); // 찾는 문자열 길이 변수 생성
	        sentence = br.readLine().toCharArray(); // 총 문자열 받기
	        int senlen = sentence.length; // 총 문자열 길이 변수 생성
	        
	        int count = 0; // 총 문자열 안에 찾는 문자열 횟수 기록 변수 생성
	        for (int i = 0; i <= senlen - finlen; i++) { // 총 문자열 안에서 총 문자열의 길이에서 찾는 문자열을 뺀 수 만큼에 대해
                String sub = new String(sentence, i, finlen); // 찾는 문자열의 길이 크기의 문자열 생성(sliding window 사용...?)
                if (sub.equals(find)) { // 총 문자열에서 찾는 문자열 길이 만큼 자른 문자열과 찾는 문자열이 같다면
                    count++; // 개수 확인 변수 1 증가
                }
            }

            System.out.println("#" + test + " " + count); // 갯수 확인 변수 출력
		}
	}
}
