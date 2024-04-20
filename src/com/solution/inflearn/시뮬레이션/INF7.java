package com.solution.inflearn.시뮬레이션;

import java.util.ArrayList;

public class INF7 {
	static int[][] map = new int[3][3];
	int[] dy = {-1, -1, 0, 1, 1, 1 ,0, -1};
	int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	public int solution(int[] keypad, String password){
		int answer = 0;

		for (int i = 0; i < password.length(); i++) {
			for (int k : keypad) {
				int num = (int)password.charAt(i);
				if(k == num) {

				}
			}

		}

		return answer;
	}

	public void findNumber(int y, int x, int k) {
		ArrayList<Integer> list = new ArrayList<>();

		map[y][x] = k;
		int nx, ny;
		for(int i=0; i<8; i++) {
			ny = y + dy[i];
			nx = x + dx[i];

			if(ny < 0 || nx < 0 || ny >= 3 || nx >= 3 || map[y][x] != 0) continue;

			map[ny][nx] = k;
		}
	}

	public static void main(String[] args){
		INF7 T = new INF7();
		System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
		System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}