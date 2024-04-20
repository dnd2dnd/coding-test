package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();

		int[] dp = new int[num.length()+1];
		dp[0] = 1;
		for(int i=1; i<=num.length(); i++) {
			int x = num.charAt(i-1) - '0';

			if(x>=1 && x<=9) {
				dp[i] += dp[i-1];
				dp[i]%=1000000;
			}
			if(i==1) continue;

			int xb = num.charAt(i-2) - '0';

			int b = xb*10 + x;
			if(b>=10 && b<=26) {
				dp[i] += dp[i-2];
				dp[i]%=1000000;
			}
		}
		System.out.println(dp[num.length()]);
	}
}
