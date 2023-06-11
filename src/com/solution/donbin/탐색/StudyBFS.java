package com.solution.donbin.탐색;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description    :
 * packageName    : com.solution.donbin.탐색
 * fileName       : StudyBFS
 * author         : tkfdk
 * date           : 2023-06-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-10        tkfdk       최초 생성
 */
public class StudyBFS {

	public static void main(String[] args) {
		boolean[] visited = new boolean[9];
		int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
		bfs(1, graph, visited);
	}

	public static void bfs(int c, int[][] graph, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(c);
		visited[c] = true;
		while(!q.isEmpty()) {
			int index = q.poll();
			System.out.print(index+" -> ");
			for (int i : graph[index]) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
