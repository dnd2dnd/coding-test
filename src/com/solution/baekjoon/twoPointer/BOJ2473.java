package com.solution.baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        long value = Long.MAX_VALUE;
        List<Long> ans = new ArrayList<>();
        for (int i=0; i<N-2; i++) {
            int start = i +1;
            int end = N-1;
            while (start < end) {
                long sum = (nums[start] + nums[i] + nums[end]);

                if (value > Math.abs(sum)) {
                    ans.clear();
                    ans.add(nums[start]);
                    ans.add(nums[i]);
                    ans.add(nums[end]);
                    value = Math.abs(sum);
                }

                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    break;
                }
            }
        }

        Collections.sort(ans);
        for (Long l : ans) {
            System.out.print(l + " ");
        }
    }

}
