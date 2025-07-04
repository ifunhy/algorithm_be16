package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A01TwoPointerBasic {
    public static void main(String[] args) {
        // 아래 배열에서 target이 될 수 있는 두 수의 조합을 모두 찾아내라.
        // [1,9] [9,1]은 같은 것으로 취급
//        int[] nums = {7,8,9,2,4,5,1,3,6};
//        int target = 10;
//        List<int[]> myList = new ArrayList<>();
//        int sum = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                sum = nums[i] + nums[j];
//                if (sum == target)
//                    myList.add(new int[]{nums[i],nums[j]});
//            }
//        }
//        for (int[] a : myList)
//            System.out.println(Arrays.toString(a));

        int[] nums = {7,8,9,2,4,5,1,3,6};
        int target = 10;
        List<int[]> myList = new ArrayList<>();

        // 위 배열을 정렬 시 : 1,2,3,4,5,6,7,8,9 -> 순회 횟수 적어짐
        // 1. end가 0부터 출발하는 경우 / 2. end가 length-1부터 시작하는 경우
        int start = 0;
        int end = nums.length - 1;
        // 정렬이 필요한 경우 : 예) 두 수의 합
        // 정렬이 필요하지 않은 경우 : 예) 구간의 합일 경우
        Arrays.sort(nums);  // n * log(n)

        while (start < end) {   // start <= end 인 경우도 존재함
            int total = nums[start] + nums[end];

            if (total == target) {
                myList.add(new int[]{nums[start], nums[end]});
                start++;    // 또는 end--;
            } else if (total < target) {
                start++;
            } else if (total > target) {
                end--;
            }
        }
        for (int[] a : myList) {
            System.out.println(Arrays.toString(a));
        }
    }
}
