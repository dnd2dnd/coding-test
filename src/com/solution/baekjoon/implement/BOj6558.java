package com.solution.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOj6558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        double d = Double.parseDouble(st.nextToken());

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            st = new StringTokenizer(line);

            String teamStr = st.nextToken();
            int team = Integer.parseInt(teamStr);

            boolean dq = false;
            long totalSec = 0;

            for (int i = 0; i < n; i++) {
                String time = st.nextToken();
                if (time.equals("-:--:--")) {
                    dq = true;
                    // 남은 토큰은 버려도 되지만, 그냥 계속 읽기
                } else {
                    String[] hms = time.split(":");
                    int h = Integer.parseInt(hms[0]);
                    int m = Integer.parseInt(hms[1]);
                    int s = Integer.parseInt(hms[2]);
                    totalSec += h * 3600L + m * 60 + s;
                }
            }

            System.out.printf("%3d: ", team);
            if (dq) {
                System.out.println("-");
            } else {
                double avg = totalSec / d;
                long sec = Math.round(avg);
                System.out.printf("%d:%02d min/km\n", sec / 60, sec % 60);
            }
        }
    }
}
