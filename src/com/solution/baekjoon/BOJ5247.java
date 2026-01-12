package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5247 {
    public static String[][] buildings;
    public static boolean[][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static Queue<Node> fire;
    public static Queue<Node> person;
    public static int sx, sy, W, H;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            buildings = new String[H][W];
            check = new boolean[H][W];
            fire = new LinkedList<>();
            person = new LinkedList<>();

            for (int h=0; h<H; h++) {
                String strs = br.readLine();
                for (int w=0; w<W; w++) {
                    String s = String.valueOf(strs.charAt(w));
                    buildings[h][w] = s;
                    if (s.equals("@")) {
                        person.add(new Node(h, w, 0));
                    } else if (s.equals("*")) {
                        fire.add(new Node(h, w, 0));
                    }
                }
            }
            cnt = Integer.MAX_VALUE;
            bfs();
            if (cnt == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(cnt);
            }

        }
    }
    public static void bfs() {
        while(!person.isEmpty()) {
            int fSize = fire.size();
            for(int i=0; i<fSize; i++) {
                Node fireNode = fire.poll();

                int nx, ny;
                for(int j=0; j<4; j++) {
                    nx = fireNode.x + dx[j];
                    ny = fireNode.y + dy[j];

                    if(nx<0 || ny<0 || nx>=H || ny>=W) continue;

                    if (buildings[nx][ny].equals(".") || buildings[nx][ny].equals("@")) {
                        buildings[nx][ny] = "*";
                        fire.add(new Node(nx, ny, 0));
                    }
                }
            }

            int pSize = person.size();
            for (int i=0; i<pSize; i++) {
                Node personNode = person.poll();

                int nx, ny;
                for(int j=0; j<4; j++) {
                    nx = personNode.x + dx[j];
                    ny = personNode.y + dy[j];

                    if(nx<0 || ny<0 || nx>=H || ny>=W) {
                        cnt = Math.min(cnt, personNode.z+1);
                        return;
                    }

                    if (buildings[nx][ny].equals(".")) {
                        buildings[nx][ny] = "@";
                        person.add(new Node(nx, ny, personNode.z+1));
                    }
                }
            }
        }
    }

    public static class Node {
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
