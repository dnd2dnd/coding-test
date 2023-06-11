package com.solution.donbin.탐색;

/**
 * description    :
 * packageName    : com.solution.donbin.탐색
 * fileName       : StudyDFS
 * author         : tkfdk
 * date           : 2023-06-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-06-10        tkfdk       최초 생성
 */
public class StudyDFS {
	static boolean[] visited = new boolean[9];
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	public static void main(String[] args) {
		dfs(1);
	}

	public static void dfs(int c) {
		visited[c] = true;
		System.out.print(c+" -> ");
		for (int i : graph[c]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
}
