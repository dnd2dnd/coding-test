package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            Set<Integer> set = new HashSet<>();

            Set<Integer> temp = new HashSet<>();
            Arrays.sort(nums);
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            for(int i=1; i<n; i+=2) {
                list.add(0, nums[i]);
                if(i+1<n) {
                    list.add(nums[i+1]);
                }
            }

            int ans = -1;
            for(int i=0; i<n; i++) {
                if(i==n-1) {
                    ans = Math.max(ans, Math.abs(list.get(n-1) - list.get(0)));
                } else {
                    ans = Math.max(ans, Math.abs(list.get(i) - list.get(i+1)));
                }
            }
            System.out.println(ans);
        }

    }
}
