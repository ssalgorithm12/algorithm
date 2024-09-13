package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2831_댄스파티 {

    static int N, countp, count;
    static int[] M, F, MM, PM, MF, PF;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = new int[N];
        F = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        countp = 0;
        for (int i = 0; i < N; i++) {
            M[i] = Integer.parseInt(st.nextToken());
            if (M[i] > 0) countp++; 
        }

        Arrays.sort(M);
        PM = new int[countp]; 
        int lenPM = countp;
        MM = new int[N - countp];
        int lenMM = N - countp;

        if (lenMM != 0) {
            int a = 0;
            for (int i = lenMM - 1; i >= 0; i--) {
                MM[a] = Math.abs(M[i]);
                a++;
            }
        }

        if (lenPM != 0) {
            int a = 0;
            for (int i = N - countp; i < N; i++) {
                PM[a] = M[i];
                a++;
            }
        }

        countp = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            F[i] = Integer.parseInt(st.nextToken());
            if (F[i] > 0) countp++; 
        }

        Arrays.sort(F); 
        PF = new int[countp]; 
        int lenPF = countp;
        MF = new int[N - countp]; 
        int lenMF = N - countp;

        if (lenMF != 0) {
            int a = 0;
            for (int i = lenMF - 1; i >= 0; i--) {
                MF[a] = Math.abs(F[i]);
                a++;
            }
        }

        if (lenPF != 0) {
            int a = 0;
            for (int i = N - countp; i < N; i++) {
                PF[a] = F[i];
                a++;
            }
        }

        count = 0;

        if (lenPM != 0 && lenMF != 0) {
            int i = lenPM - 1, j = lenMF - 1;
            while (i >= 0 && j >= 0) {
                if (PM[i] < MF[j]) {
                    count++;
                    i--;
                    j--;
                } else {
                    i--;
                }
            }
        }

        if (lenPF != 0 && lenMM != 0) {
            int i = lenPF - 1, j = lenMM - 1;
            while (i >= 0 && j >= 0) {
                if (PF[i] < MM[j]) {
                    count++;
                    i--;
                    j--;
                } else {
                    i--;
                }
            }
        }

        System.out.println(count);
    }
}
