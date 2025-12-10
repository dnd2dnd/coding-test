package com.solution.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12993 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        System.out.println(solve(x, y));
    }

    public static int solve(long x, long y) {
        if (x == 0 && y == 0) return 1; // 시작점이 목적지인 경우

        while (x > 0 || y > 0) {
            if (x % 3 == 1 && y % 3 == 0) {
                // x방향으로 이동한 경우
                x /= 3;
                y /= 3;
            } else if (x % 3 == 0 && y % 3 == 1) {
                // y방향으로 이동한 경우
                x /= 3;
                y /= 3;
            } else {
                // 둘 다 0이거나(건너뜀), 둘 다 1이거나(중복), 2가 포함된 경우
                return 0;
            }
        }
        return 1;
    }
}
