package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        long[] x = new long[n];
        long[] y = new long[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        long crossSum = 0; // Σ(x_i*y_{i+1} - y_i*x_{i+1})
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n; // 마지막-첫번째 연결
            crossSum += x[i] * y[j] - x[j] * y[i];
        }

        double area = Math.abs(crossSum) / 2.0;
        System.out.printf("%.1f\n", area);

    }

}
