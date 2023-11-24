package com.solution.programmers.level2;

import java.util.*;

public class 미로탈출 {
	class Solution {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		boolean[][] visited;
		public int solution(String[] maps) {
			int answer = -1;
			visited = new boolean[maps.length][maps[0].length()];
			int lx = 0, ly = 0, lc = 0;
			Queue<Node> queue = new LinkedList<>();
			boolean b = false;
			for(int i=0; i<maps.length; i++) {
				for(int j=0; j<maps[i].length(); j++) {
					if(maps[i].charAt(j) == 'S') {
						b = true;
						queue.add(new Node(i, j, 1));
						visited[i][j] = true;
					} else if(maps[i].charAt(j) == 'L') {
						lx = i;
						ly = j;
					}
				}
			}

			boolean lever = false;
			while(!queue.isEmpty()) {
				Node node = queue.poll();

				int nx, ny;
				for(int i=0; i<4; i++) {
					nx = node.x + dx[i];
					ny = node.y + dy[i];

					if(nx<0 || ny<0 || nx>=maps.length || ny>= maps[0].length() || maps[nx].charAt(ny)=='X') continue;
					if(lever) {
						if(maps[nx].charAt(ny)=='E') {
							return node.c;
						}
					}

					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new Node(nx, ny, node.c+1));
						if(!lever) {
							if(nx==lx && ny==ly) {
								lever = true;
								visited = new boolean[maps.length][maps[0].length()];
								queue.clear();
								queue.add(new Node(nx, ny, node.c+1));
								break;
							}
						}
					}
				}
			}

			return answer;
		}
		public class Node {
			int x, y, c;


			Node(int x, int y, int c) {
				this.x = x;
				this.y = y;
				this.c = c;
			}
		}
	}
}
