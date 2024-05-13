package com.solution.baekjoon.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1005 {
	static List<List<Integer>> list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] buildings = new int[n+1];
			int[] arr = new int[n+1];
			visited = new boolean[n+1];
			list = new ArrayList<>();
			list.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				list.add(new ArrayList<>());
				buildings[i] = Integer.parseInt(st.nextToken());
				arr[i] = buildings[i];
			}

			int[] edge = new int[n+1];
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.get(x).add(y);
				edge[y]++;
			}
			int w = Integer.parseInt(br.readLine());

			Queue<Integer> queue = new LinkedList<>();
			for(int i=1; i<edge.length; i++) {
				if(edge[i] == 0) {
					queue.add(i);
				}
			}

			while(!queue.isEmpty()) {
				int x = queue.poll();

				for (Integer next : list.get(x)) {
					arr[next] = Math.max(arr[next], arr[x] + buildings[next]);
					edge[next]--;
					if(edge[next]==0) {
						queue.add(next);
					}
				}
			}
			System.out.println(arr[w]);
		}
	}
}
