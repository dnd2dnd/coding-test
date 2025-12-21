package com.solution.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int x = Integer.parseInt(br.readLine());

            if (x==-1) {
                break;
            }

            int value = x;
            List<Integer> list = new ArrayList<>();
            for (int i=1; i<Math.sqrt(x); i++) {
                if (x%i==0) {
                    list.add(i);
                    if(x/i != i && x/i!=value) {
                        list.add(x/i);
                    }
                }
            }
            Collections.sort(list);

            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }

            StringBuilder sb = new StringBuilder();
            if (sum == value) {
                sb.append(x).append(" = ");
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size()-1) {
                        sb.append(list.get(i));
                    } else {
                        sb.append(list.get(i)).append(" + ");
                    }
                }
            } else {
                sb.append(x).append(" is NOT perfect.");
            }
            System.out.println(sb);
        }
    }
}
