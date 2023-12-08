package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  백준 1865, 웜홀, 골드 3
 */
public class BOJ1865 {
	public static class Node {
		int x, y, value;

		public Node(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int q=0; q<tc; q++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			ArrayList<Node> list = new ArrayList<>();

			int s, e, t;
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				list.add(new Node(s, e, t));
				list.add(new Node(e, s, t));
			}

			for(int i=0; i<w; i++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				list.add(new Node(s, e, -t));
			}

			boolean check = false;
			for(int i=1; i<=n; i++) {
				if(rec(i, n, list)) {
					check = true;
					break;
				}
			}
			if(check) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	public static boolean rec(int x, int n, ArrayList<Node> list) {
		int[] area = new int[n+1];
		for(int i=0; i<=n; i++) {
			area[i] = 5000000;
		}
		area[x] = 0;
		boolean check = false;
		for(int i=1; i<n; i++) {
			check = false;
			for (Node node : list) {
				if(area[node.x] != 5000000 && area[node.x] + node.value < area[node.y]) {
					area[node.y] = area[node.x] + node.value;
					check = true;
				}
			}

			if(!check) {
				break;
			}
		}

		if(check) {
			for (Node node : list) {
				if(area[node.x] != 5000000 && area[node.x] + node.value < area[node.y]) {
					area[node.y] = area[node.x] + node.value;
					return true;
				}
			}
		}

		return false;
	}
}
