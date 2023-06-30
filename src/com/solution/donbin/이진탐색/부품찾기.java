package com.solution.donbin.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class 부품찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		String[] check = new String[m];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int x = Integer.parseInt(st.nextToken());

			int min = 0;
			int max = num.length-1;
			boolean b = false;
			while(min<=max) {
				int mid = (min + max) / 2;

				if(num[mid]<x) min = mid + 1;
				else if(num[mid]>x) max = mid - 1;
				else{
					b = true;
					break;
				}
			}
			check[i] = b ? "yes" : "no";
		}

		for(int i=0; i<m; i++) {
			System.out.print(check[i]+" ");
		}
	}
}
