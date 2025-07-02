package A5DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class A02동전관련 {
    public static void main(String[] args) {

        // 1, 4, 5의 숫자가 있을 때, 조합하여 13를 만들 수 있는 조합 중 가장 짧은 조합의 길이
        Integer[] arr = {100,400,500};
        int target = 1300;
        // greedy로 문제를 풀 경우 : 5*2 + 1*3 -> 5개의 동전
        // dp로 문제를 풀 경우 : 4*2 + 5*1 -> 3개의 동전
        // f(n) = Min(f(n-ni), f(n-n2)) + 1

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int coin : arr) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        System.out.println(dp[target]);
    }
}

// 백준 - 동전2
// import java.io.*;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Ex2294 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        int[] dp = new int[k + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//
//        for (int i = 1; i <= k; i++) {
//            for (int coin : arr) {
//                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
//                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                }
//            }
//        }
//
//        if (dp[k] == Integer.MAX_VALUE) // 만들 수 없다면
//            System.out.println(-1);
//        else System.out.println(dp[k]);
//    }
//}