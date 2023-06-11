package com.solution.donbin.탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * description    :
 * packageName    : com.solution.donbin.탐색
 * fileName       : 특정거리의도시찾기
 * author         : tkfdk
 * date           : 2023-06-11
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-11        tkfdk       최초 생성
 */
public class 특정거리의도시찾기 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] d = new int[300001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();

		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
			d[i]=0;
		}

		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			graph.get(a).add(b);
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		while(!q.isEmpty()) {
			int now = q.poll();
			for (Integer i : graph.get(now)) {
				if (d[i]==0) {
					q.add(i);
					d[i] = d[now] + 1;
				}
			}
		}

		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(d[i]==k) {
				System.out.println(i);
				cnt+=1;
			}
		}

		if(cnt==0) {
			System.out.println(-1);
		}
	}

}
