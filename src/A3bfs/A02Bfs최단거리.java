package A3bfs;

import java.util.*;

public class A02Bfs최단거리 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) {
        // 방문할 수 있는 점이 여러 개인 경우, 정점 번호가 작은 것을 먼저 방문
        // 출발은 0부터 bfs로 방문 시 0 -> 1 -> 2 -> 3 -> 4
        int[][] nodes = {{0,2},{0,1},{1,3},{2,3},{2,4}};

        adjList = new ArrayList<>();
        visited = new boolean[5];

        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]);
            adjList.get(nodes[i][1]).add(nodes[i][0]);
        }

        for (int i = 0; i < adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        // Queue 안에 Integer가 아니라 int[]을 담아서 0번째는 노드번호, 1번째는 distance 설계 가능
        // Queue<int[]> myQueue = new LinkedList<>();
        Queue<Integer> myQueue = new LinkedList<>();
        int[] distance = new int[5];    // 거리 기록
        int target = 4;
        myQueue.add(0);
        visited[0] = true;

        while (!myQueue.isEmpty()) {
            int temp = myQueue.poll();

            for (int a : adjList.get(temp)) {
                if (!visited[a]) {
                    myQueue.add(a);
                    visited[a] = true;  // queue에 담는 시점에 true 세팅해야 queue에 중복으로 담기지 않음
                    distance[a] = distance[temp] + 1;
                    // 만약 찾고자 하는 target이 정해져 있다면 break;
                    if (target == a) {
                        break;
                    }
                }
            }
        }
        // 0에서 출발했을 때 4까지의 최단거리가 얼마냐
        System.out.println(distance[target]);
//        System.out.println(거리배열[4]);
    }
}



//package A3bfs;
//
//import java.util.*;
//
//public class A01Bfs최단거리 {
//    static List<List<Integer>> adjList;
//    static boolean[] visited;
//    public static void main(String[] args) {
/// /        방문할수 있는점이 여러개인경우, 정점번호가 작은것을 먼저 방문
/// /        출발은 0부터 bfs로 방문시 방문순서 : 0->1->2->3->4
//        int[][] nodes = {{0,2},{0,1}, {1,3}, {2,3}, {2,4}};
//        adjList = new ArrayList<>();
//        visited = new boolean[5];
//        for (int i=0; i<5; i++){
//            adjList.add(new ArrayList<>());
//        }
//        for (int i=0; i<nodes.length; i++){
//            adjList.get(nodes[i][0]).add(nodes[i][1]);
//            adjList.get(nodes[i][1]).add(nodes[i][0]);
//        }
//        for (int i=0; i<adjList.size(); i++){
//            adjList.get(i).sort(Comparator.naturalOrder());
//        }
//
////        Queue안에 Integer가 아니라 int[]을 담아서 0번째는 노드번호, 1번째는 distance설계 가능.
//        Queue<int[]> myQueue = new LinkedList<>();
//        int[] distacne = new int[5];
//        int target = 4;
//        myQueue.add(new int[]{0, 0});
//        visited[0]=true;
//        while (!myQueue.isEmpty()){
//            int[] temp = myQueue.poll();
//            for (int a : adjList.get(temp[0])){
//                if(!visited[a]){
//                    myQueue.add(new int[]{a, temp[1]+1});
//                    visited[a] = true; //queue에 담는시점에 true세팅해야지, 중복해서 queue에 안담김.
////                    만약에 찾고자하는 target이 정해져 있으면 break;
//                    if(target==a){
//                        break;
//                    }
//                }
//            }
//        }
//        System.out.println(distacne[target]);
//
//
//    }
//}