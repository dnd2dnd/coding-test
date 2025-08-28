package com.solution.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1759 {
    public static int l, c;
    public static String[] arr;
    public static boolean[] visited;
    public static List<String> moeum = Arrays.asList("a", "e", "i", "o", "u");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new String[c];
        visited = new boolean[c];
        String[] strs = br.readLine().split(" ");
        for (int i=0; i<c; i++) {
            arr[i] = strs[i];
        }
        Arrays.sort(arr);

        back(0, 0, new ArrayList<>());

    }

    public static void back(int x, int d, List<String> temp) {
        if (d==l) {
            int j = 0, m = 0;

            for (String s : temp) {
                if (moeum.contains(s)) {
                    m++;
                } else {
                    j++;
                }
            }

            if (m>=1 && j>=2) {
                System.out.println(String.join("", temp));
            }
        }

        for (int i=x; i<c; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(arr[i]);
                back(i+1, d+1, temp);
                temp.remove(d);
                visited[i] = false;
            }
        }
    }


}
