package com.solution.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9934 {
	static int k;
	static int[] arr;
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int number = (int)(Math.pow(2, k) - 1);
		arr = new int[number];
		for (int i=0; i<number; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<k; i++) {
			list.add(new ArrayList<>());
		}

		search(0, number, 0);
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<k; i++) {
			for(int j=0; j<list.get(i).size(); j++) {
				sb.append(list.get(i).get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void search(int start, int end, int d) {
		if(d==k) {
			return;
		}

		int mid = (start + end)/2;
		list.get(d).add(arr[mid]);

		search(start, mid-1, d+1);
		search(mid+1, end, d+1);
	}
}
