package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		ArrayList<Integer> restRoom = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			restRoom.add(Integer.parseInt(st.nextToken()));
		}
		restRoom.add(0);
		restRoom.add(l);

		Collections.sort(restRoom);
		int left = 1;
		int right = l;

		while (left <= right) {
			int mid = (left + right) / 2;

			int sum = 0;
			for (int i = 1; i < restRoom.size(); i++) {
				sum += (restRoom.get(i) - restRoom.get(i-1) - 1)/mid;
			}

			if(sum > m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(left);

		// int ans = Integer.MAX_VALUE;
		// for(int i=1; i<=m; i++) {
		// 	Collections.sort(restRoom);
		// 	int max = Integer.MIN_VALUE;
		// 	int left = 0, right = l;
		// 	for(int j=1; j<=n; j++) {
		// 		int x = restRoom.get(j) - restRoom.get(j-1);
		// 		if(max < x) {
		// 			max = x;
		// 			left = restRoom.get(j-1);
		// 			right = restRoom.get(j);
		// 		}
		// 	}
		//
		// 	while(left <= right) {
		// 		int mid = (left + right) / 2;
		// 		int y = Math.max(mid - left, right - mid);
		// 		if (max > y) {
		// 			left = mid + 1;
		// 		} else {
		// 			if(!restRoom.contains(mid)) {
		// 				System.out.println(ans + " " + y);
		// 				System.out.println(left + " " + right);
		// 				System.out.println();
		// 				ans = Math.min(ans, y);
		// 			}
		// 			right = mid - 1;
		// 		}
		// 	}
		// 	restRoom.add(ans);
		// }
		// System.out.println(ans);

	}
}
