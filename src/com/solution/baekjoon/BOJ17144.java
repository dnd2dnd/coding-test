package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17144 {
    public static int[][] maps;
    public static List<Node> nodes = new ArrayList<>();
    public static int r, c, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        maps = new int[r][c];
        for (int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<c; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == -1) {
                    nodes.add(new Node(i, j));
                }
            }
        }

        for (int i=0; i<t; i++) {
            spread();
            circle();
        }

        int cnt = 0;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                cnt += maps[i][j];
            }
        }
        System.out.println(cnt+2);

    }
    public static void spread() {
        int[][] newMaps = new int[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (maps[i][j] == -1) {
                    newMaps[i][j] = maps[i][j];
                    continue;
                }

                int check = 0;
                int value = maps[i][j]/5;
                if (i-1 >= 0 && maps[i-1][j] != -1) {
                    check++;
                    newMaps[i-1][j] += value;
                }
                if (j+1 < c && maps[i][j+1] != -1) {
                    check++;
                    newMaps[i][j+1] += value;
                }
                if (j-1 >= 0 && maps[i][j-1] != -1) {
                    check++;
                    newMaps[i][j-1] += value;
                }
                if (i+1 < r && maps[i+1][j] != -1) {
                    check++;
                    newMaps[i+1][j] += value;
                }

                newMaps[i][j] += maps[i][j] - (value * check);
            }
        }

        maps = new int[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                maps[i][j] = newMaps[i][j];
            }
        }

    }

    public static void circle() {
        Node fNode = nodes.getFirst();
        int fx = fNode.x;

        for (int i=fx-1; i>0; i--) {
            maps[i][0] = maps[i-1][0];
        }
        for (int i=0; i<c-1; i++) {
            maps[0][i] = maps[0][i+1];
        }
        for (int i=0; i<fx; i++) {
            maps[i][c-1] = maps[i+1][c-1];
        }
        for (int i=c-1; i>0; i--) {
            if (i==1) {
                maps[fx][1] = 0;
            } else {
                maps[fx][i] = maps[fx][i-1];
            }
        }

        fNode = nodes.get(1);
        fx = fNode.x;

        for (int i=fx+1; i<r-1; i++) {
            maps[i][0] = maps[i+1][0];
        }
        for (int i=0; i<c-1; i++) {
            maps[r-1][i] = maps[r-1][i+1];
        }
        for (int i=r-1; i>fx; i--) {
            maps[i][c-1] = maps[i-1][c-1];
        }
        for (int i=c-1; i>0; i--) {
            if (i==1) {
                maps[fx][1] = 0;
            } else {
                maps[fx][i] = maps[fx][i-1];
            }
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
