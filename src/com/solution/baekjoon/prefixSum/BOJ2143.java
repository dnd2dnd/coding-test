package com.solution.baekjoon.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 2143, 두 배열의 합, 골드 3
 */
public class BOJ2143 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] numA = new int[n];
		ArrayList<Integer> listA = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			numA[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] numB = new int[m];
		ArrayList<Integer> listB = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			numB[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=i; j<n; j++) {
				sum += numA[j];
				listA.add(sum);
			}
		}

		for(int i=0; i<m; i++) {
			int sum = 0;
			for(int j=i; j<m; j++) {
				sum += numB[j];
				listB.add(sum);
			}
		}

		Collections.sort(listA);
		Collections.sort(listB);

		int la = 0;
		int rb = listB.size() - 1;
		long cnt = 0;
		while(la < listA.size() && rb>=0) {
			int x = listA.get(la) + listB.get(rb);

			if(x==t) {
				int A = listA.get(la);
				int B = listB.get(rb);
				long cntA = 0;
				long cntB = 0;

				while(la < listA.size() && listA.get(la) == A) {
					la++;
					cntA++;
				}
				while(rb>=0 && listB.get(rb) == B) {
					rb--;
					cntB++;
				}
				cnt += cntA * cntB;
			} else if(x<t) {
				la++;
			} else {
				rb--;
			}
		}
		System.out.println(cnt);
	}
}
