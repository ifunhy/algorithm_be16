package A2dfs;
import java.util.*;

public class A02Dfs모든경우의수 {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static List<Integer> temp = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[][] nodes = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {4, 9}, {5, 10}};

        int maxNode = 10; // 가장 큰 노드 번호
        adjList = new ArrayList<>();
        visited = new boolean[maxNode + 1];  // 1~10번 노드 사용

        for (int i = 0; i <= maxNode; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : nodes) {
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
        }

        // 자식 정렬
        // 여기서는 1번이 루트노드라고 정해졌기 때문에, visited 제외하고 단방향노드로 설계
        for (int i = 0; i < adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        dfs(1);  // 노드 번호 1에서 시작 (start == 노드 번호)
        System.out.println(result);
    }

    static void dfs(int start) {
        visited[start] = true;
        temp.add(start);

        if (adjList.get(start).isEmpty()) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int next : adjList.get(start)) {
                if (!visited[next]) {
                    dfs(next);
                }
            }
        }
        // 백트래킹
        temp.remove(temp.size() - 1);
        visited[start] = false;
    }
}


// 결과 : [[1, 2, 4, 8], [1, 2, 4, 9], [1, 2, 5, 10], [1, 3, 6], [1, 3, 7]]
// 백준 - 1260 DFSBFS
// 백준 - 11724 연결요소의 개수



// 강사님 코드
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//public class A02Dfs모든경우의수 {
//
//    static List<List<Integer>> adjList;
//    static List<List<Integer>> answer;
//    public static void main(String[] args) {
////        1~10까지의 노드가 존재
//        int[][] nodes = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3,7}, {4,8}, {4,9}, {5,10}};
//        adjList = new ArrayList<>();
////        1부터 시작할경우 인접리스트를 1개 더 넉넉하게 생성
//        for (int i=0; i<11; i++){
//            adjList.add(new ArrayList<>());
//        }
////        여기서는 1번이 루트노드라고 정해졌기 때문에, visited제외하고 단방향노드로 설계.
//        for (int i=0; i<nodes.length; i++){
//            adjList.get(nodes[i][0]).add(nodes[i][1]);
//        }
//        for (int i=0; i<adjList.size(); i++){
//            adjList.get(i).sort(Comparator.naturalOrder());
//        }
//        answer = new ArrayList<>();
//        dfs(1, new ArrayList<>());
//        System.out.println(answer);
//    }
//    static void dfs(int start, List<Integer> temp){
//        temp.add(start);
//        if(adjList.get(start).isEmpty()){
//           answer.add(new ArrayList<>(temp));
//        }
//        for (int a : adjList.get(start)){
//            dfs(a, temp);
//            temp.remove(temp.size()-1);
//        }
//    }
//}