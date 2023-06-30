package com.solution.donbin.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class 떡볶이떡만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n, m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] rice = new int[n];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i=0; i<n; i++) {
			rice[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, rice[i]);
		}

		Arrays.sort(rice);
		int left = 1;
		int right = max;
		int answer = 0;
		while(left<right) {
			int mid = (left + right) / 2;

			int cnt=0;
			for(int i=0; i<n; i++) {
				int x = rice[i]-mid;
				if(x>0) cnt += x;
			}
			System.out.println(cnt);
			if(cnt>=m) {
				answer = mid;
				left = mid + 1;
			} else{
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
