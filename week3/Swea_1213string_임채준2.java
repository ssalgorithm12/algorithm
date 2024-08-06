package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Swea_1213string_임채준2 {
	
	static int T = 10;
    static String find;
    static char[] sentence;
    static String[] sum;
    static int test;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= T; t++) {
	        test = Integer.parseInt(br.readLine());
	        find = br.readLine();
	        int finlen = find.length();
	        sentence = br.readLine().toCharArray();
	        int senlen = sentence.length;
	        
	        int count = 0;
	        for (int i = 0; i <= senlen - finlen; i++) {
                String sub = new String(sentence, i, finlen);
                if (sub.equals(find)) {
                    count++;
                }
            }

            System.out.println("#" + test + " " + count);
		}
	}
}