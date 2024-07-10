package com.solution.programmers.level2;
import java.util.*;

public class 행렬테두리계산하기 {
    class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> solution(int rows, int columns, int[][] queries) {
            int[][] map = new int[rows][columns];
            for(int i=0; i<rows; i++) {
                for(int j=0; j<columns; j++) {
                    map[i][j] = i*columns + j + 1;
                }
            }

            for(int k=0; k<queries.length; k++) {
                change(queries[k], map);
            }

            return list;
        }

        public void change(int[] queries, int[][] map) {
            int x1 = queries[0]-1;
            int y1 = queries[1]-1;
            int x2 = queries[2]-1;
            int y2 = queries[3]-1;

            int temp = map[x1][y2];
            int min = temp;
            for(int i=y2-1; i>=y1; i--){
                min = Math.min(min, map[x1][i]);
                map[x1][i+1] = map[x1][i];
            }

            for(int i=x1+1; i<=x2; i++){
                min = Math.min(min, map[i][y1]);
                map[i-1][y1] = map[i][y1];
            }

            for(int i=y1+1; i<=y2; i++){
                min = Math.min(min, map[x2][i]);
                map[x2][i-1] = map[x2][i];
            }

            for(int i=x2-1; i>=x1; i--){
                min = Math.min(min, map[i][y2]);
                map[i+1][y2] = map[i][y2];
            }

            map[x1+1][y2] = temp;
            list.add(min);
        }
    }
}
