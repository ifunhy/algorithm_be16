package A1sort;
import java.util.*;

// 트리탐색 + 재귀적호출
public class A01HeapSort구현 {
    static int heapSize;

    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,6};
        heapSize = arr.length;

        // 최초힙구성 : n*log(n)
        for (int i = (heapSize / 2) - 1; i >= 0 ; i--) {
            heapify(arr, i);    // 배열, 부모노드의 현재 위치 넘김
        }
        // 루트노드와 최하위노드를 자리 change 해 가면서 재heapify
        for (int  i = (heapSize - 1); i >= 0; i--) {
            // 0번째 index와 마지막 index의 자리를 change
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapSize--; // 힙 크기 하나 줄임
            heapify(arr, 0);
        }
//        System.out.println(Arrays.toString(arr));   // 출력했을 때 정렬이 되어 있어야 함

        // pq를 통한 정렬 방법
        // 최초힙구성 : n * log(n)
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(7,6,5,8,3,5,9,1,6));
        System.out.println(pq.poll());  // log(n)
        pq.add(6);  // log(n)

    }


    static void heapify(int[] arr, int parent) {
        // 자식노드와의 비교 : 왼쪽자식노드(parent*2+1), 오른쪽자식노드(parent*2+2)
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int smallest = parent;

        // 자식이 더 작으면 자리 change
        if (left < heapSize && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < heapSize && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != parent) {
            int temp = arr[parent];
            arr[parent] = arr[smallest];
            arr[smallest] = temp;

            // 만약 자리 change가 발생하면 재귀적 호출
            heapify(arr, smallest);
        }
    }
}


//package A1sort;
//import java.util.*;
//
//// 트리탐색 + 재귀적호출
//public class A01HeapSort구현 {
//    static int heapSize;
//
//    public static void main(String[] args) {
//        int[] arr = {7,6,5,8,3,5,9,1,6};
//
//        // 최초힙구성 : n*log(n)
//        for (int i = (arr.length / 2) - 1; i >= 0 ; i--) {
//            heapify(arr, i, arr.length);    // 배열, 부모노드의 현재 위치 넘김
//        }
//        // 루트노드와 최하위노드를 자리 change 해 가면서 재heapify
//        for (int  i = (arr.length - 1); i >= 0; i--) {
//            // 0번째 index와 마지막 index의 자리를 change
//            int temp = arr[0];
//            arr[0] = arr[i];
//            arr[i] = temp;
//
//            heapify(arr, 0, i);
//        }
//        System.out.println(Arrays.toString(arr));   // 출력했을 때 정렬이 되어 있어야 함
//    }
//    static void heapify(int[] arr, int parent, int length) {
//        // 자식노드와의 비교 : 왼쪽자식노드(parent*2+1), 오른쪽자식노드(parent*2+2)
//        int left = parent * 2 + 1;
//        int right = parent * 2 + 2;
//        int smallest = parent;
//
//        // 자식이 더 작으면 자리 change
//        if (left < length && arr[left] < arr[smallest]) {
//            smallest = left;
//        }
//        if (right < length && arr[right] < arr[smallest]) {
//            smallest = right;
//        }
//
//        if (smallest != parent) {
//            int temp = arr[parent];
//            arr[parent] = arr[smallest];
//            arr[smallest] = temp;
//
//            // 만약 자리 change가 발생하면 재귀적 호출
//            heapify(arr, smallest, length);
//        }
//    }
//}
