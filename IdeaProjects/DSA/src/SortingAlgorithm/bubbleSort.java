package SortingAlgorithm;

import java.util.Arrays;
import java.lang.Math;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr1 = {2, 0, 1};
        System.out.println(Arrays.toString(BubbleSort(arr1)));
    }

    public static int[] BubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j + 1 < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
      return nums;
    }
}