package MathsProblem;

import java.util.*;
import java.lang.Math;

public class Maths {

    public static void main(String[] args) {
        int a =15;
        int b = 3;
        System.out.println(smallestNumber(a,b));
    }
    public static int smallestNumber(int n, int t) {
        int temp= n;
        int pro = 1;
        while(temp!=0){
            pro*=temp%10;
            temp/=10;
            if(pro%t==0&&temp==0)return n;
            if(pro%t!=0&&temp==0){
                n++;
                temp = n;
                pro=1;
            }
        }
        return 0;
    }
    public static int maxProduct(int n) {
        int temp = n;
        int firstmax = temp%10;
        temp /=10;
        int secondmax = 0;
        int i = 0;
        while(temp>0){
            int dummy = temp%10;
            if(dummy>firstmax){
                if(firstmax>secondmax){
                    secondmax = firstmax;
                }
                firstmax = dummy;
            }else if(dummy>secondmax && dummy<=firstmax){
                secondmax = dummy;
            }
            temp /=10;
            i++;
        }
        System.out.println(firstmax+"____"+secondmax);
        return firstmax*secondmax;
    }
    public static int mirrorDistance(int n) {
        int ans =0;
        int temp = n;
        while(temp>0){
            ans = ans*10 + temp%10;
            temp=temp/10;
        }
        temp=Math.abs(n-ans);
        return temp ;
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