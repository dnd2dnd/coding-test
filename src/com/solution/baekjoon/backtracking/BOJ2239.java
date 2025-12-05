package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2239 {
    public static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++) {
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<9;j++) {
                arr[i][j] = c[j]-'0';
            }
        }
        back(0);

    }
    public static void back(int x) {
        if (x==81) {
            StringBuilder sb = new StringBuilder();
            for(int[] a : arr) {
                for(int b : a) {
                    sb.append(b);
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
            System.exit(0);
        }

        int r = x/9;
        int c = x%9;

        if (arr[r][c] != 0) {
            back(x+1);
        } else {
            for (int i=1; i<=9; i++) {
                if(!isValid(r, c, i)) {
                    continue;
                }

                arr[r][c] = i;
                back(x+1);
                arr[r][c] = 0;
            }
        }
    }
    public static boolean isValid(int r, int c, int n) {
        for (int i=0; i<9; i++) {
            if (arr[i][c] ==n || arr[r][i] == n) {
                return false;
            }
        }

        int rr = r/3 * 3;
        int cc = c / 3 * 3;

        for (int row=rr; row<rr+3; row++) {
            for(int col=cc; col<cc+3; col++) {
                if (arr[row][col] == n) {
                    return false;
                }
            }
        }
        return true;
    }
}
