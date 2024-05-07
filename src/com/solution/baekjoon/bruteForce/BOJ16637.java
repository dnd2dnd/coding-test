package com.solution.baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ16637 {
    static ArrayList<Integer> nums = new ArrayList<>();
    static ArrayList<Character> operator = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for (int i=0; i<n; i++) {
            if (i%2==0) {
                nums.add(Character.getNumericValue(str.charAt(i)));
            } else {
                operator.add(str.charAt(i));
            }
        }

        find(0, nums.get(0));
        System.out.println(answer);
    }
    public static void find(int i, int sum) {
        if(i==operator.size()) {
            answer = Math.max(answer, sum);
            return;
        }

        int val = calculate(sum, nums.get(i+1), operator.get(i));
        find(i+1, val);

        if(i+2 <= operator.size() - 1) {
            val = calculate(sum, calculate(nums.get(i+1), nums.get(i+2), operator.get(i+1)), operator.get(i));
            find(i+2, val);
        }
    }
    public static int calculate(int x, int y, char c) {
        if(c=='*') {
            return x*y;
        } else if(c=='+') {
            return x+y;
        } else {
            return x-y;
        }
    }
}
