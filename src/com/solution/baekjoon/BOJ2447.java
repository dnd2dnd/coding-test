package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2447 {
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(arr[i], " ");
        }

        pattern(0, 0, n);
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void pattern(int x, int y, int len) {
        if(len == 1) {
            arr[x][y] = "*";
            return;
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(i==1 && j==1) {
                    continue;
                }
                pattern(x+i*len/3, y+j*len/3, len/3);
            }
        }
    }
}
