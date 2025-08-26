package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k  = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long low = 1;
        long high = 0;
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            high = Math.max(high, arr[i]);
        }
        Arrays.sort(arr);

        long answer = 0;
        while (low <= high) {
//            System.out.println(low + " " + high);
            long sum = 0;
            long mid = (high + low) / 2;

            for (int i = 0; i< k; i++) {
                sum += (arr[i] / mid);
            }

            if (sum >= n) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
