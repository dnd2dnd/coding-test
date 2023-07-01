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

		int answer = upperBound(num, x, 0, n-1) - lowerBound(num, x, 0, n-1);

		System.out.println((answer==0) ? -1 : answer);
	}
	public static int lowerBound(int[] num, int x, int left, int right) {
		while(left < right) {
			int mid = (left + right) / 2 ;
			if(num[mid] >= x) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	public static int upperBound(int[] num, int x, int left, int right) {
		while(left < right) {
			int mid = (left + right) / 2 ;
			if(num[mid] > x) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
}
