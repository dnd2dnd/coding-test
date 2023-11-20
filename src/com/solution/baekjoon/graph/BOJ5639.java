package com.solution.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  백준 5639, 이진 검색 트리, 골드 5
 */
public class BOJ5639 {
	public static class Node {
		int root;
		Node left, right;

		public void insert(int v) {
			if(root==0) {
				root = v;
			} else if (root < v) {
				if(right == null) {
					right = new Node();
				}
				right.insert(v);
			} else {
				if(left == null) {
					left = new Node();
				}
				left.insert(v);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node node = new Node();
		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals(""))
				break;
			node.insert(Integer.parseInt(input));
		}

		rec(node);
	}
	public static void rec(Node node) {
		if(node==null) return;
		if(node.left != null) {
			rec(node.left);
			rec(node.right);
			System.out.println(node.root);
		} else {
			if(node.right != null) {
				rec(node.right);
			}
			System.out.println(node.root);
		}
	}
}
