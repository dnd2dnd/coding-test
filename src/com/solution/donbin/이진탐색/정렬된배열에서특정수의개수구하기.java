package com.solution.donbin.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class 정렬된배열에서특정수의개수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n, x;
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = n-1;
		int answer = 0;
		while(left<=right) {
			int mid = (left + right) / 2;

			if(num[mid] < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			System.out.println(left + " " + right);
		}

		System.out.println(answer);
	}
}
