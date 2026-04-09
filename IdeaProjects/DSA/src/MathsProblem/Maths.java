package MathsProblem;

import java.util.*;
import java.lang.Math;

public class Maths {

    public static void main(String[] args) {
        int a =28;
        int b = 10;
        System.out.println(checkPerfectNumber(a));
    }
    public static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
    public static boolean isPowerOfThree(int n) {
        if (n < 1) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
//    public static int countOperations(int num1, int num2) {
//        int count = 0;
//        while(true){
//            if(num1<=0||num2<=0){
//                break;
//            }
//            if(num1>=num2){
//                num1=num1-num2;
//            }else{
//                num2 = num2-num1;
//            }
//            count++;
//        }
//        return count;
//    }
}