package com.solution.baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> nums = getPrimes(N);

        int cnt = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        while (true) {
            if (sum >= N) {
                sum -= nums.get(start);
                start++;
            } else if (end >= nums.size()) {
                break;
            } else {
                sum += nums.get(end);
                end++;
            }

            if (sum == N) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static List<Integer> getPrimes(int N) {
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
