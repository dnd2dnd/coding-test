package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 1991, 트리 순회, 실버 1
 */
public class BOJ1991 {
	public static class Node {
		String root;
		Node left, right;

		public Node(String root, Node left, Node right) {
			this.root = root;
			this.left = left;
			this.right = right;
		}
	}
	static Node tree = new Node("A", null, null);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();

			insert(tree, a, b, c);
		}
		preOrder(tree);
		System.out.println();
		inOrder(tree);
		System.out.println();
		postOrder(tree);
	}
	public static void insert(Node cur, String root, String left, String right) {
		if(cur.root.equals(root)) {
			if(left.equals(".")) {
				cur.left = null;
			} else {
				cur.left = new Node(left, null, null);
			}
			if(right.equals(".")) {
				cur.right = null;
			} else {
				cur.right = new Node(right, null, null);
			}
		} else {
			if(cur.left != null) insert(cur.left, root, left, right);
			if(cur.right != null) insert(cur.right, root, left, right);
		}
	}
	public static void preOrder(Node cur) {
		if(cur != null) {
			System.out.print(cur.root);
			preOrder(cur.left);
			preOrder(cur.right);
		}
	}
	public static void inOrder(Node cur) {
		if(cur != null) {
			inOrder(cur.left);
			System.out.print(cur.root);
			inOrder(cur.right);
		}
	}
	public static void postOrder(Node cur) {
		if(cur != null) {
			postOrder(cur.left);
			postOrder(cur.right);
			System.out.print(cur.root);
		}
	}
}
