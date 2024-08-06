package algol0729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Swea_1213 {

	static int testCase = 10;
	static int caseNumber;
	static char[] input;
	static char[] word;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<testCase; t++) {
			caseNumber = Integer.parseInt(br.readLine());
			input = br.readLine().toCharArray();
			word = br.readLine().toCharArray();
			
			int leftIndex = 0;
			int rightIndex = input.length - 1;
			int count = 0;
			
			while(rightIndex < word.length) {
				boolean validation = true;
				int inputIndex = 0;
				
				for(int i=leftIndex; i<=rightIndex; i++) {
					if(input[inputIndex] != word[i]) {
						validation = false;
						break;
					}
					inputIndex++;
				}
				
				if(validation) {
					count++;
				}
				
				leftIndex++;
				rightIndex++;
			}
			
			result.append("#" + (caseNumber) + " ");
			result.append(count + "\n");
		}
		System.out.println(result);
	}

}
