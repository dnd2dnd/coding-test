package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * description    :
 * packageName    : com.solution.donbin.탐색
 * fileName       : 숨바꼭질
 * author         : tkfdk
 * date           : 2023-06-11
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-11        tkfdk       최초 생성
 */
public class BOJ1697 {
	static int[] map = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] inputs = input.split(" ");

		int n = Integer.valueOf(inputs[0]);
		int k = Integer.valueOf(inputs[1]);

		Queue<Integer> q = new LinkedList<>();
		q.add(n);

		while(!q.isEmpty()) {
			int x = q.poll();
			if (x==k) {
				System.out.println(map[x]);
				break;
			}
			int a = x-1;
			int b = x+1;
			int c = 2*x;

			if(a>=0&&a<=100000 && map[a] == 0) {
				map[a] = map[a + 1] + 1;
				q.add(a);
			}

			if(b>=0&&b<=100000 && map[b] == 0) {
				map[b] = map[b - 1] + 1;
				q.add(b);
			}

			if(c>=0&&c<=100000 && map[c] == 0) {
				map[c] = map[c / 2] + 1;
				q.add(c);
			}
		}
	}
}

