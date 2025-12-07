package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ26150 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // (문제번호 I, 제목, 위치 D) 저장
        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            list.add(strs);
        }

        // 문제 번호 기준으로 정렬 (strs[1]이 문제 번호 I)
        list.sort((a, b) -> Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1])));

        StringBuilder sb = new StringBuilder();
        for (String[] strs : list) {
            char c = strs[0].charAt(Integer.parseInt(strs[2]) - 1);
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 32);  // 소문자 → 대문자
            }
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
