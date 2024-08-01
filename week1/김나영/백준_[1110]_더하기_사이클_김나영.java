import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		List<String> s2 = new ArrayList<>();
		
		String s = sc.next();
		String s2;
		int cnt = 1;
		if(Integer.parseInt(s) < 10) {
			s2 = s+s;
		} else {
			s2 = s.substring(1)+(Integer.parseInt(s.substring(0, 1)) + Integer.parseInt(s.substring(1)) + "");
			if(s2.length()==3) s2 = s2.substring(0, 1) + s2.substring(2);
		}
//		System.out.println(s); // s2 = s로 하고 s2의 값을 바꿔도 s가 바뀌지 않는다
		
		while(!(Integer.parseInt(s) == Integer.parseInt(s2))) {// 외때묺애 !(s2.equals(s))가 먹히지 않는가,,,
			int c1 = Integer.parseInt(s2.substring(0, 1));
			int c2 = Integer.parseInt(s2.substring(1));
			if((c1+c2+"").length() == 1) {
				s2 = s2.substring(1) + (c1+c2+"");
 			} else {
				s2 = s2.substring(1) + (c1+c2+"").substring(1);
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	
}