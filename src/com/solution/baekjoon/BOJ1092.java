package com.solution.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> cranes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        cranes.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if(cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            System.exit(-1);
        }

        int day = 0;
        while(!boxes.isEmpty()) {
            int craneId = 0, boxId = 0;
            while(craneId < n) {
                if(boxId == boxes.size()) {
                    break;
                } else if(cranes.get(craneId) >= boxes.get(boxId)) {
                    boxes.remove(boxId);
                    craneId++;
                } else {
                    boxId++;
                }
            }
            day++;
        }
        System.out.println(day);
    }
}
