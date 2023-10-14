package com.solution.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1339 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] alpha = new int[26];
		String s;
		for (int i=0; i<n; i++) {
			s = br.readLine();
			int l = s.length();
			for (int j=0; j<l; j++) {
				alpha[s.charAt(j)-'A'] += (int) Math.pow(10, l-j-1);
			}
		}

		Integer[] arr3 = Arrays.stream(alpha).boxed().toArray(Integer[]::new);
		Arrays.sort(arr3, Collections.reverseOrder());

		int value = 9;
		int sum = 0;
		for (int i = 0; i < arr3.length; i++) {
			if(arr3[i] == 0) {
				break;
			}
			sum += arr3[i]*value--;
		}
		System.out.println(sum);
	}
}
