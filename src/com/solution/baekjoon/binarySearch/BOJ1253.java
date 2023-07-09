package com.solution.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class BOJ1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		int cnt = 0;
		for(int i=0; i<N; i++) {
			int left = 0;
			int right = N-1;
			int x = num[i];
			while(left < right) {
				int mid = (num[left] + num[right]);

				if (x<mid) {
					right--;
				} else if (x>mid) {
					left++;
				} else {
					if(left != i && right != i) {
						cnt++;
						break;
					} else if (left == i){
						left++;
					} else {
						right--;
					}

				}
			}
		}
		System.out.println(cnt);
	}
}
