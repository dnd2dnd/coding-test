package com.solution.baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        String[] strs = br.readLine().split(" ");
        int[] nums = new int[N];
        for (int i=0; i< strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        int answer = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int sum = 0;
        while(start <= end && end < N) {
            sum += nums[end];

            while (sum >= S) {
                answer = Math.min(answer, end-start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
