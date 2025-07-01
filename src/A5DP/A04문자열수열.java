package A5DP;

public class A04문자열수열 {
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
}

// 백준 - 계단오르기