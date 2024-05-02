package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20922 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;
		int result = Integer.MIN_VALUE;

		int[] cnt = new int[100001];
		while(left<=right){
			if(right<=n-1 && cnt[nums[right]] < m){
				cnt[nums[right]]++;
				right++;
			}
			else if(cnt[nums[right]]==m){
				cnt[nums[left]]--;
				left++;
			}
			result = Math.max(right-left,result);

			if(right==n){
				break;
			}
		}
		System.out.println(result);
	}
}
