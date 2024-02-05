package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {
	static int[] nums = new int[4];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] arr = new int[4];
		String temp = str.substring(0, p);
		for(int i=0; i<temp.length(); i++) {
			if(temp.charAt(i) == 'A') {
				arr[0]+=1;
			} else if (temp.charAt(i) == 'C') {
				arr[1]+=1;
			} else if (temp.charAt(i) == 'G') {
				arr[2]+=1;
			} else if (temp.charAt(i) == 'T') {
				arr[3]+=1;
			}
		}

		int count = 0;
		if(checkPassword(arr)) {
			count++;
		}

		for(int i=1; i<=str.length()-p; i++) {
			if(str.charAt(i-1) == 'A') {
				arr[0]--;
			} else if (str.charAt(i-1) == 'C') {
				arr[1]--;
			} else if (str.charAt(i-1) == 'G') {
				arr[2]--;
			} else if (str.charAt(i-1) == 'T') {
				arr[3]--;
			}

			if(str.charAt(i+p-1) == 'A') {
				arr[0]++;
			} else if (str.charAt(i+p-1) == 'C') {
				arr[1]++;
			} else if (str.charAt(i+p-1) == 'G') {
				arr[2]++;
			} else if (str.charAt(i+p-1) == 'T') {
				arr[3]++;
			}

			if(checkPassword(arr)) {
				count++;
			}
		}

		System.out.println(count);
	}

	public static boolean checkPassword(int[] arr) {
		for(int i=0; i<4; i++)
			if(arr[i] < nums[i]) return false;

		return true;
	}
}
