package com.solution.programmers.dfsbfs;
import java.util.*;
public class 게임맵최단거리 {
    class Solution {
        public int solution(int[][] maps) {
            int answer = 0;
            int[] sx = {1, -1, 0, 0};
            int[] sy = {0, 0, 1, -1};
            boolean[][] visited = new boolean[maps.length][maps[0].length];

            Queue<Node> q = new LinkedList<>();
            q.add(new Node(0,0));
            visited[0][0]=true;
            while(!q.isEmpty()) {
                Node n = q.poll();
                int dx, dy;

                if(n.x==maps.length-1 && n.y==maps[0].length-1) {
                    return maps[n.x][n.y];
                }

                for(int i=0; i<4; i++) {
                    dx = n.x+sx[i];
                    dy = n.y+sy[i];

                    if(dx<0 || dy<0 || dx>=maps.length || dy>=maps[0].length || maps[dx][dy]==0) continue;
                    if(!visited[dx][dy]) {
                        maps[dx][dy]=maps[n.x][n.y]+1;
                        visited[dx][dy]=true;
                        q.add(new Node(dx,dy));
                    }
                }
            }
            return -1;
        }
        public class Node {
            int x, y;
            Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
    }
}
