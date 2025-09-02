package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int low = 0;
        int high = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            if (high < x) {
                high = x;
            }
        }

        Arrays.sort(arr);

        int answer = 0;
        while (low <= high) {
            long sum = 0;

            int mid = (low + high) / 2;

            for (int i = 0; i < n; i++) {
                int v = arr[i] - mid;

                if (v > 0) {
                    sum += v;
                }
            }

            if (sum >=m) {
                if (answer < mid) {
                    answer = mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        System.out.println(answer);
    }
}
