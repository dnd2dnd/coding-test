package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2467 {
    public static int n, cnt = Integer.MAX_VALUE;
    public static int[] arr;
    public static int[] answer = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = n-1;

        while(s<e) {
            int x = arr[s];
            int y = arr[e];
            int value = x+y;
            if (Math.abs(value) <= cnt) {
                cnt = Math.abs(value);
                answer[0] = x;
                answer[1] = y;
            }

            if (value > 0) {
                e--;
            } else if(value < 0) {
                s++;
            } else {
                break;
            }

        }
        for (int i : answer) {
            System.out.print(i +" ");
        }
    }
}
