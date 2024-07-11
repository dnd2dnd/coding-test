package com.solution.programmers.level2;

import java.util.*;

public class 무인도여행 {
    class Solution {
        static int[] dx = {1, -1, 0, 0};
        static int[] dy = {0, 0, 1, -1};
        static int[][] map;
        static boolean[][] visited;
        public List<Integer> solution(String[] maps) {
            List<Integer> answer = new ArrayList<>();
            map = new int[maps.length][maps[0].length()];
            visited = new boolean[maps.length][maps[0].length()];

            for(int i=0; i<maps.length; i++) {
                for(int j=0; j<maps[0].length(); j++) {
                    char c = maps[i].charAt(j);
                    if (Character.isDigit(c)) {
                        map[i][j] = (int)c-48;
                    }
                }
            }

            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map[0].length; j++) {
                    if(!visited[i][j] && map[i][j]!=0) {
                        visited[i][j] = true;
                        answer.add(dfs(i, j, maps) + map[i][j]);
                    }
                }
            }

            Collections.sort(answer);
            if(answer.size()==0) {
                answer.add(-1);
            }


            return answer;
        }
        public int dfs(int x, int y, String[] maps) {
            int sum = 0;
            int nx, ny;
            for(int i=0; i<4; i++) {
                nx = x+dx[i];
                ny = y+dy[i];
                if(nx<0 || ny<0 || nx >=maps.length || ny >=maps[0].length()) {
                    continue;
                }

                if(!visited[nx][ny] && map[nx][ny] != 0) {
                    sum += map[nx][ny];
                    visited[nx][ny] = true;
                    sum += dfs(nx, ny, maps);
                }
            }
            return sum;
        }
    }
}
