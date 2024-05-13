package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11561 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int left = 1;
			int right = n;

			int ans = Integer.MIN_VALUE;
			while(left <= right) {
				int mid = (left + right) / 2;

				long value = (long)mid *(mid+1)/2;

				if(value <= n) {
					ans = Math.max(ans, left);
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			System.out.println(ans);
		}

	}
}
