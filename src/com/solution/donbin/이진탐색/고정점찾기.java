package com.solution.donbin.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class 고정점찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<5; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = n-1;
		int answer = -1;

		while(left<=right) {
			int mid = (left + right) / 2;

			if (num[mid] > mid) {
				right = mid - 1;
			} else if(num[mid] < mid) {
				left = mid + 1;
			} else {
				answer = mid;
				break;
			}
		}
		System.out.println(answer);

	}
}
