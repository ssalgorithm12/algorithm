package test;

import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br;
    static StringTokenizer st;

    static int n;

    static int quadrant;
    static int start;
    static int cnt;

    public static void main(String[] args) throws IOException{

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, n);
        find(size, r, c);
        System.out.println(cnt);

    }

    static void find(int size, int r, int c) {

        if(size == 1) {
            return;
        }

        if(r < size / 2) {

            if(c < size / 2) {
                find(size / 2, r, c);

            } else {
                cnt += size * size / 4 * 1;
                find(size / 2, r, c - size / 2);
            }

        } else {

            if(c < size / 2) {
                cnt += size * size / 4 * 2;
                find(size / 2, r - size / 2, c);

            } else {
                cnt += size * size / 4 * 3;
                find(size / 2, r - size / 2, c - size / 2);
            }
        }

    }
}