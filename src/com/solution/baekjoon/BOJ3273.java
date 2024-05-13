package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ3273 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[n+1];
		for(int i=1; i<=n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());

		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=1; i<=n; i++) {
			int x = nums[i];
			map.put(x, i);
			if(map.get(m-x) != null && i > map.get(m-x)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
