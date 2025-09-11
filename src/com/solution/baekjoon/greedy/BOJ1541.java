package com.solution.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split("-");

        int sum = 0;

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<strs.length; i++) {
            String[] nums = strs[i].split("\\+");
            int v = 0;
            for (String num : nums) {
                v += Integer.parseInt(num);
            }
            list.add(v);
        }

        sum += list.get(0);
        for (int i=1; i<list.size(); i++) {
            sum -= list.get(i);
        }

        System.out.println(sum);
    }

}
