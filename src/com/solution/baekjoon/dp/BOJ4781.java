package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 4181, 사탕 가게, 골드 4
 * 사탕 가격에 소수점이 있는데 부동소수점을 고려해야 하므로 100을 곱한 뒤에  반올림을 해줘야 한다.
 * rounding error
 */
public class BOJ4781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] strs = br.readLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int m = (int) Math.round(Double.parseDouble(strs[1])*100);
            if(n==0 && m==0) {
                break;
            }

            int[] calorie = new int[n];
            int[] price = new int[n];
            StringTokenizer st;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                calorie[i] = Integer.parseInt(st.nextToken());
                price[i] = (int) Math.round(Double.parseDouble(st.nextToken())*100);
            }

            int[] dp = new int[m+1];
            dp[0] = 0;
            for(int i=0; i<n; i++) {
                int p = price[i];
                for(int j=p; j<m+1; j++) {
                    dp[j] = Math.max(dp[j], dp[j-p] + calorie[i]);
                }
            }
            System.out.println(dp[m]);
        }




    }
}
