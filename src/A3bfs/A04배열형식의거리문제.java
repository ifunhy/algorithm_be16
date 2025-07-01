package A3bfs;
import java.util.*;

public class A04배열형식의거리문제 {
    // 프로그래머스 - 게임 맵 최단거리
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        // return 값 : 11과 15 중 최솟값인 11 리턴
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        boolean[][] visited  = new boolean[maps.length][maps[0].length];
        Queue<List<Integer>> myQueue = new LinkedList<>();  // 좌표값 + distance
        myQueue.add(Arrays.asList(0,0,1));  // 시작위치 + 초기거리 설정

        visited[0][0] = true;

        while (!myQueue.isEmpty()) {
            List<Integer> temp = myQueue.poll();
            int x = temp.get(0);
            int y = temp.get(1);
            int distance = temp.get(2);

            if (x == maps.length - 1 && y == maps[0].length - 1) { // 종료조건
                System.out.println(distance);
                return ;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 범위 안이고, 방문 안했고, 길이면
                if ((0 <= nx && nx < maps.length) && (0 <= ny && ny < maps[0].length)) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                         visited[nx][ny] = true;
                         myQueue.add(Arrays.asList(nx,ny,distance + 1));
                    }
                }
            }
        }
    }
}


// [1,0,1,1,1],
// [1,0,1,0,1],
// [1,0,1,1,1],
// [1,1,1,0,1],
// [0,0,0,0,1]

// 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return
// 상대 팀 진영에 도착할 수 없을 때는 -1을 return

// 1. Queue에 x,y,distance 형태로 저장
// 2. visited[][] 배열로 방문 여부 관리
// 3. bfs 루프 안에서 좌표 꺼냄
// 4. 도착하면 거리 출력
// 5. 4방향 탐색 후 갈 수 있다면 queue에 추가
