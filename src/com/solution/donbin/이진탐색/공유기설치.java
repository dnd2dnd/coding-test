package com.solution.donbin.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class 공유기설치 {
	static int n, c;
	static int[] home;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		home = new int[n];
		for(int i=0; i<n; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);

		int left = 1;
		int right = home[n-1] - home[0] + 1;

		while(left < right) {
			int mid = (left + right) / 2;

			if(install(mid) < c) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(right - 1);
	}
	public static int install(int m) {
		int cnt = 1;
		int lastLoc = home[0];
		for(int i=0; i<n; i++) {
			int loc = home[i];

			if(loc-lastLoc >= m) {
				lastLoc = loc;
				cnt++;
			}
		}
		return cnt;
	}

}
