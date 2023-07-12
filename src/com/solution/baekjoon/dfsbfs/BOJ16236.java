package com.solution.baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 16236번 아기 상어, 골드 3
 */
public class BOJ16236 {
    static int N;
    static int[][] place;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int size=2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        place = new int[N][N];
        StringTokenizer st;

        int x = 0;
        int y = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int c = Integer.parseInt(st.nextToken());
                if(c==9) {
                    x=i;
                    y=j;
                }
                place[i][j] = c;
            }
        }


        int cnt=0;
        int ans=0;
        while(true) {
            List<Node> list = bfs(x, y);
            if(list.size()==0) {
                break;
            }
            Node saveNode = list.get(0);
            for(int i=1; i<list.size(); i++) {
                if(saveNode.d > list.get(i).d){
                    saveNode = list.get(i);
                } else if(saveNode.d == list.get(i).d) {
                    if(saveNode.x > list.get(i).x) {
                        saveNode = list.get(i);
                    } else if(saveNode.x == list.get(i).x) {
                        if(saveNode.y > list.get(i).y) {
                            saveNode = list.get(i);
                        }
                    }
                }
            }

            place[x][y] = 0;
            place[saveNode.x][saveNode.y] = 9;
            x = saveNode.x;
            y = saveNode.y;
            cnt++;
            ans+= saveNode.d;
            if (cnt==size) {
                size++;
                cnt=0;
            }
        }
        System.out.println(ans);
    }
    public static List<Node> bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));

        List<Node> list = new ArrayList<>();
        int sx, sy;
        boolean[][] check = new boolean[N][N];
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i=0; i<4; i++) {
                sx = node.x+dx[i];
                sy = node.y+dy[i];

                if(sx<0 || sy<0 || sx>=N || sy>=N) continue;

                if(!check[sx][sy] && place[sx][sy]<=size) {
                    if(place[sx][sy]>=1 && place[sx][sy]<=6 && place[sx][sy]<size) {
                        list.add(new Node(sx, sy, node.d+1));
                    }
                    check[sx][sy]=true;
                    queue.add(new Node(sx, sy, node.d+1));
                }
            }
        }
        return list;
    }

    public static class Node {
        int x, y, d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
