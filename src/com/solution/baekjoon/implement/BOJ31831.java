package com.solution.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ31831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int x = 0;
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            x += Integer.parseInt(st.nextToken());

            if (x >= m) {
                cnt++;
            }

            if (x<0) {
                x = 0;
            }
        }
        System.out.println(cnt);
    }
}
