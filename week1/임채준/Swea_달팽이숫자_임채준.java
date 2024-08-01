package Study;

import java.util.Scanner;

public class Swea_달팽이숫자_임채준 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int r = 0;
        int c = 0;
        int num = 1;
        int temp = 1;
        int[][] map = new int[n][n];
        
        for(int i = 0; i < n; i ++) {
            map[r][c] = num++;
            c++;
        }
        c--;
        r++;
        
        while(num <= n * n) {
            if(temp % 2 == 1) {
                for(int i = 0; i < n - temp; i++) {
                    map[r][c] = num++;
                    r++;
                }
                r--;
                c--;
                for(int i = 0; i < n - temp; i++) {
                    map[r][c] = num++;
                    c--;
                }
                c++;
                r--;
                temp++;
            } else {
                for(int i  = 0; i < n - temp; i++) {
                    map[r][c] = num++;
                    r--;    
                }
                r++;
                c++;
                for(int i = 0; i < n - temp; i++) {
                    map[r][c] = num++;
                    c++;
                }
                c--;
                r++;
                temp++;
            }
        }
        
        // Print the map
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        
    }
}
