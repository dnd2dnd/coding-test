package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1865 {
    public static int cnt;
    public static boolean[] visited;
    public static List<List<Node>> loads;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int q=0; q<T; q++) {
            loads = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            for (int i=0; i<=n; i++) {
                loads.add(new ArrayList<>());
            }
            visited = new boolean[n+1];


            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                loads.get(s).add(new Node(e, t));
                loads.get(e).add(new Node(s, t));
            }

            for (int i=0; i<w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                loads.get(s).add(new Node(e, -t));
            }

            int[] dist = new int[n+1];
            Arrays.fill(dist, 0);
            boolean hasCycle = false;
            for (int i=1; i<=n; i++) {
                boolean hasUpdate = false;

                for (int j=1; j<=n; j++) {
                    for (Node node : loads.get(j)) {
                        if (dist[node.end] > dist[j] + node.time) {
                            dist[node.end] = dist[j] + node.time;
                            hasUpdate = true;

                            if (i==n) {
                                hasCycle = true;
                            }
                        }
                    }
                }

                if (!hasUpdate) {
                    break;
                }
            }
            sb.append(hasCycle ? "YES\n" : "NO\n");
        }
        System.out.println(sb);

    }
    public static class Node {
        int end, time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
    public static void dfs(int x) {
        for (Node node : loads.get(x)) {
            if (!visited[node.end]) {
                visited[node.end] = true;
                cnt += node.time;
                dfs(node.end);
            }
        }
    }
}
