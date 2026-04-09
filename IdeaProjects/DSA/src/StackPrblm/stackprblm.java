package StackPrblm;

import java.util.Arrays;
import java.util.Stack;

public class stackprblm {
    public static void main(String[] args){
//        String[] s = {"5","+"};
        int[] s = {2,4};
        int[] s1 = {1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(s,s1)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[10000];
        int[] res =new int[nums1.length];
        Stack<Integer> st =new Stack<>();
        int n1 =nums2.length;
        int j =0;
        for(int i = n1-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()<=nums2[i]){
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[nums2[i]] = st.peek();
            } else {
                ans[nums2[i]] = -1;
            }
            st.push(nums2[i]);
        }
        for(int i =0;i<nums1.length;i++){
            res[i]=ans[nums1[i]];
        }
        return res;
    }
//    public static int[] dailyTemperatures(int[] temperatures) {
//        int n = temperatures.length;
//        int[] result = new int[n];
//        for (int i = 0;i<n;i++){
//            for (int j =i+1;j<n;j++){
//                if(temperatures[i]<temperatures[j]){
//                    result[i]=j-i;
//                    break;
//                }else{
//                    result[i]=0;
//                }
//            }
//        }
//        return result;
//    }
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String a: operations){
            if(a.equals("C")){
                stack.pop();
            }else if(a.equals("D")){
                stack.push(2*stack.peek());
            }else if(a.equals("+")){
                int temp = stack.pop();
                int ans = temp+stack.peek();
                stack.push(temp);
                stack.push(ans);
            }else {
                stack.push(Integer.parseInt(a));
            }
        }
        int ans =0;
        while(!stack.isEmpty()){
            ans+=stack.peek();
            stack.pop();
        }
        return ans;
    }
    public static boolean isValid(String s) {
        Stack <Character> stack=new Stack<>();
        int len=s.length();
        boolean flag=true;
        for(int i =0;i<len;i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='['||s.charAt(i)=='('){
                stack.push(s.charAt(i));
                flag=false;
            }
            if(s.charAt(i)=='}' || s.charAt(i)==']'||s.charAt(i)==')'){
                if(stack.isEmpty())return false;
                char temp=stack.peek();
                if((temp=='{'&&s.charAt(i)=='}')||(temp=='['&&s.charAt(i)==']')||(temp=='('&&s.charAt(i)==')')){
                    stack.pop();
                    flag=true;
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty())return false;
        if(!flag) return false;
        return true;
    }
}
