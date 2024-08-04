package test;

import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t, n;
    static int input;
    static int idx, size;
    static int[] heap;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {

            sb.append("#").append(i + 1).append(" ");

            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            heap = new int[n + 1];
            size = 0;

            for(int j = 0; j < n; j++) {
                input = Integer.parseInt(st.nextToken());
                add(input);
            }

            for(int j = 1; j <= n; j++) {
                sb.append(pop()).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void add(int n) {
        size++;
        heap[size] = n;
        idx = size;

        while(idx > 1 && heap[idx] < heap[idx / 2]) {
            swap(idx, idx / 2);
            idx = idx / 2;
        }
    }

    private static int pop() {
        int min = heap[1];
        heap[1] = heap[size];
        size--;
        idx = 1;

        while(idx * 2 <= size) {

            int child = idx * 2;
            if(child + 1 <= size && heap[child] > heap[child + 1]) {
                child ++;
            }
            if(heap[child] < heap[idx]) {
                swap(child, idx);
                idx = child;
            } else break;
        }
        return min;
    }

    private static void swap(int n1, int n2) {
        int tmp = heap[n1];
        heap[n1] = heap[n2];
        heap[n2] = tmp;
    }
}