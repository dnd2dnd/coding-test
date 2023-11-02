package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ13913 {
	static boolean[] visited = new boolean[100001];
	public static class Node {
		int x, c;
		ArrayList<Integer> list;

		public Node(int x, int c, ArrayList<Integer> list) {
			this.x = x;
			this.c = c;
			this.list = list;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");

		int n = Integer.parseInt(strs[0]);
		int k = Integer.parseInt(strs[1]);

		bfs(n, k);

	}
	public static void bfs(int n, int k) {
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(n);
		queue.add(new Node(n, 0, temp));
		visited[n] = true;
		if(n==k) {
			System.out.println(0);
			System.out.println(n);
			System.exit(0);
		}else if(n>k) {
			System.out.println(n-k);
			for(int i=n; i>=k; i--) {
				System.out.print(i+ " ");
			}
			System.exit(0);
		}

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			for(int i=0; i<3; i++) {
				int x = node.x;
				if(i==0) {
					x-=1;
				} else if(i==1) {
					x+=1;
				} else {
					x*=2;
				}

				if(x>=0 && x<=100000) {
					if(x==k) {
						node.list.add(x);
						System.out.println(node.c+1);
						for (Integer integer : node.list) {
							System.out.print(integer+ " ");
						}
						System.exit(0);
					}

					if(!visited[x]) {
						visited[x] = true;
						ArrayList<Integer> copy = new ArrayList<>(node.list);
						// ArrayList<Integer> copy = node.list;
						copy.add(x);
						queue.add(new Node(x, node.c+1, copy));
					}
				}
			}
		}
	}
}
