package A5DP;

public class A01계단관련 {
    // 프로그래머스 - 멀리 뛰기
    public static void main(String[] args) {
        int n = 4;
        long answer = 0;
        // dp를 수행할 배열 선언
        int[]dp = new int[n+1];
        // dp 초기값 세팅
        dp[1]=1;
        if(n>=2) dp[2]=2;
        // dp 수행
        for(int i=3; i<=n; i++){
            dp[i]=(dp[i-1]+dp[i-2])%1234567;
        }

        // 정답 저장
        answer = dp[n];
//        return answer;
        System.out.println(answer);
    }
    // 백준 - 계단오르기
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //
    //        int N = Integer.parseInt(br.readLine());
    //        int[] score = new int[N + 1];
    //        int[] dp = new int[N + 1];
    //
    //        for (int i = 1; i <= N; i++) {
    //            score[i] = Integer.parseInt(br.readLine());
    //        }
    //
    //        dp[1] = score[1];
    //        if (N >= 2)
    //            dp[2] = score[1] + score[2];
    //
    //        for (int i = 3; i <= N; i++) {
    //            dp[i] = Math.max(dp[i - 2] + score[i],
    //                    dp[i - 3] + score[i - 1] + score[i]);
    //        }
    //
    //        System.out.println(dp[N]);
}
