package A3bfs;

import java.util.*;

public class A03인접리스트활용거리문제 {
    // 프로그래머스 - 가장 먼 노드
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        // return 값 : 3

        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < vertex.length; i++) {
            adjList.get(vertex[i][0]).add(vertex[i][1]);
            adjList.get(vertex[i][1]).add(vertex[i][0]);
        }

        for (int i = 0; i < adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        Queue<Integer> myQueue = new LinkedList<>();
        int[] distance = new int[n + 1];
        myQueue.add(1);
        visited[1] = true;
        List<Integer> count = new ArrayList<>();

        while (!myQueue.isEmpty()) {
            int temp = myQueue.poll();

            for (int a : adjList.get(temp)) {
                if (!visited[a]) {
                    myQueue.add(a);
                    visited[a] = true;
                    distance[a] = distance[temp] + 1;
                    count.add(distance[a]);
                }
            }
        }
        count.sort(Comparator.reverseOrder());
        int result = Collections.frequency(count, count.get(0));
        System.out.println(result);
    }
}

// 숙제 : 백준 - 촌수 계산