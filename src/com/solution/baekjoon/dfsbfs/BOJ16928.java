package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 16928, 뱀과 사다리 게임, 골드 5
 */
public class BOJ16928 {
	public static class Node {
		int v, cnt;

		public Node(int v, int cnt) {
			this.v = v;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] nums = new int[101];
		boolean[] check = new boolean[101];
		for(int i=0; i<n+m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nums[a] = b;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 0));
		check[1] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();

			if(nums[node.v]>0 && !check[node.v]) {
				queue.add(new Node(nums[node.v], node.cnt+1));
				check[node.v] = true;
				continue;
			}

			for(int i=1; i<=6; i++) {
				int a = node.v+i;

				if(a<100 && !check[a]) {
					if(nums[a]>0) {
						queue.add(new Node(nums[a], node.cnt+1));
						check[nums[a]] = true;
					} else {
						queue.add(new Node(a, node.cnt+1));
						check[a] = true;
					}
				} else if(a==100){
					System.out.println(node.cnt+1);
					System.exit(0);
				}
			}
		}
	}
}

