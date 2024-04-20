package com.solution.inflearn.시뮬레이션;

import java.util.Arrays;

public class INF4 {
	public static int[] cy = {-1, 0, 1, 0};
	public static int[] cx = {0, 1, 0, -1};


	static int d, t, startY, startX;
	public int[] solution(int c, int r, int k){
		int[] answer = new int[2];
		int[][] chair = new int[r][c];

		d = 0;
		t = 1;
		startY = r-1;
		startX = 0;
		chair[startY][startX] = 1;
		while (true) {
			move(c, r, chair);
			if(t==k) {
				answer[0] = startX+1;
				answer[1] = startY+1;
				break;
			} else if(t>= c*r) {
				break;
			}
		}

		return answer;
	}

	public void move(int c, int r, int[][] chair) {
		int ny = startY + cy[d];
		int nx = startX + cx[d];
		if(nx<0 || ny<0 || nx>=c || ny>=r || chair[ny][nx] == 1) {
			d = (d+1)%4;
		} else {
			chair[ny][nx] = 1;
			t++;
			startY = ny;
			startX = nx;
		}
	}

	public static void main(String[] args){
		INF4 T = new INF4();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}
