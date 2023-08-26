package com.solution.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  백준 25325, 학생 인기도 측정, 실버 5
 */
public class BOJ25325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            map.put(st.nextToken(), 0);
        }

        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<str.length; j++) {
                map.put(str[j], map.get(str[j])+1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> { // 정렬
            if(map.get(o1) - map.get(o2) == 0)
                return o1.compareTo(o2);
            else
                return map.get(o2) - map.get(o1);
        });

        for(String key : keySet) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
