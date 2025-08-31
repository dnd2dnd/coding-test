package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i=0; i<n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int low = 0;
        int high = n-1;
        int answer = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(low < high) {
            int sum = num[low] + num[high];

            int abs = Math.abs(sum);
            if (answer > abs) {
                answer = abs;
                ans[0] = num[low];
                ans[1] = num[high];
            }

            if (sum == 0) {
                ans[0] = num[low];
                ans[1] = num[high];
                break;
            } else if (sum > 0) {
                high -= 1;
            } else {
                low += 1;
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
