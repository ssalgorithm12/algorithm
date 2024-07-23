import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int x = 1; x <= t; x++)
        {
            int a=0, result=0;
            String str = br.readLine();
            for(int i = 0; i<3; i++) if(str.charAt(i)=='o') a = i;
            int n = Integer.parseInt(str.substring(4));
            if(a==2&&n == 0) result = 2;
            else if(a==1 &&(n&1)==0 ) result = 1;
            else if(a!=1 &&(n&1)==1 ) result = 1;
            sb.append("#"+x+" "+ result +"\n");
        }
        System.out.print(sb);
    }
}
