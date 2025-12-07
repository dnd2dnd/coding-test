package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int[] nums = new int[5];
        for (int i=0; i<5; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        for (int i=0; i<5; i++) {
            for (int j=0; j<4; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;

                    for (int k=0; k<5; k++) {
                        System.out.print(nums[k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
