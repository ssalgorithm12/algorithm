import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution{

	static int N;
	static String data;
	static String year_data;
	static String month_data;
	static String day_data;
	static StringBuilder sb = new StringBuilder();
	
	static void valid_value() {
		sb.append(year_data).append("/");
		sb.append(month_data).append("/");
		sb.append(day_data).append("\n");
	}
	
	static void invalid_value() {
		sb.append(-1).append("\n");
	}
	
	public static void main(String[] args)throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
					
			for(int test_case = 0; test_case < N; test_case++) {
				
				sb.append("#").append(test_case + 1).append(" ");
				
				data = br.readLine();
				year_data = data.substring(0, 4);
				month_data = data.substring(4, 6);
				day_data = data.substring(6);
				
				int month = Integer.parseInt(month_data);
				int day = Integer.parseInt(day_data);
				
				if(month < 1 || month > 12) {
					invalid_value();
				}else {
					if(month == 2) {
						if(day > 28 || day < 1) {
							invalid_value();
						}else {
							valid_value();
						}
					}else if(month != 2 && month < 8 && month % 2 == 1){
						if(day > 31 || day < 1) {
							invalid_value();
						}else {
							valid_value();
						}
					}else if(month != 2 && month < 8 && month  % 2 == 0) {
						if(day > 30 || day < 1) {
							invalid_value();
						}else {
							valid_value();
						}
					}else if(month > 7 && month % 2 == 1) {
						if(day > 30 || day < 1) {
							invalid_value();
						}else {
							valid_value();
						}
					}else if(month > 7 && month % 2 == 0) {
						if(day > 31 || day < 1) {
							invalid_value();
						}else {
							valid_value();
						}
					}
				}
			}
			
			System.out.println(sb.toString());
	}
}