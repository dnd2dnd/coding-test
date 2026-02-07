package com.solution.baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1644 {
    public static List<Integer> primes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        if (n>2) {
            for (int i=2; i<=n; i++) {
                isDecimal(i);
            }

            int s = 0, e = 0;
            int sum =0;
//            System.out.println(primes);
            while(s<=e && e < primes.size()) {
                sum += primes.get(e);

                while (sum >= n) {
//                    System.out.println("sum :" + sum);
                    if (sum == n) {
                        answer++;
                    }
                    sum -= primes.get(s);
                    s++;
                }
                e++;
            }

        } else if (n==2) {
            answer = 1;
        }

        System.out.println(answer);

    }

    public static void isDecimal(int x) {
        for (int i=2; i<=Math.sqrt(x); i++) {
            if (x%i == 0) {
                return;
            }
        }

        primes.add(x);
    }
}
