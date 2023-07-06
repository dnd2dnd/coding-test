package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 3020번 개똥벌레, 골드 5
 */
public class BOJ3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int H = Integer.parseInt(input[1]);

		int[] bot = new int[H + 1];
		int[] top = new int[H + 1];

		for(int i=0; i<N/2; i++) {
			bot[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}

		for(int i=1; i<H+1; i++) {
			bot[i]+=bot[i-1];
			top[i]+=top[i-1];
		}

		int cnt = 0;
		int min = Integer.MAX_VALUE;
		for(int i=1; i<H+1; i++) {
			int crush = 0;
			crush += bot[H] - bot[i-1];
			crush += top[H] - top[H-i];

			if(crush<min) {
				min = crush;
				cnt = 1;
			} else if(min == crush) {
				cnt++;
			}
		}
		System.out.println(min + " " + cnt);
	}
}
