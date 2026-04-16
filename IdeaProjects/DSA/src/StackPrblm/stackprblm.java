package StackPrblm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class stackprblm {
    public static void main(String[] args){
        String s = "bcabc";
//        int[] s = {2,4};
//        int[] s1 = {73,73,73,73};
        System.out.println(removeDuplicateLetters(s));
    }
//    second method for the 1081
//    public static String removeDuplicateLetters(String s) {
//        Stack<Character> stack = new Stack<>();
//        HashMap<Character,Integer> map = new HashMap<>();
//        int[] freq = new int[26];
//        StringBuffer sb = new StringBuffer();
//        int n = s.length();
//        for(int i =0; i<n;i++){
//            char c = s.charAt(i);
//            map.put(c,map.getOrDefault(c,0)+1);
//            freq[s.charAt(i)-'a']+=1;
//        }
//        for(int i =0; i<n;i++){
//            map.put(s.charAt(i),map.get(s.charAt(i))-1);
//            freq[s.charAt(i)-'a']-=1;
//            while (!stack.isEmpty()&&!stack.contains(s.charAt(i))&&freq[stack.peek()-'a']!=0) {
//                if(stack.peek()<s.charAt(i)){
//                    break;
//                }
//                System.out.println(stack.pop());
//                System.out.println(stack);
//            }
//            if(!stack.contains(s.charAt(i))) {
//                stack.push(s.charAt(i));
//            }
//            System.out.println(stack);
//        }
//        for(char c:stack){
//            sb.append(c);
//        }
//        return sb.toString();
//    }
//    the first method for the 1081
    public static String removeDuplicateLetters(String s) {
       Stack<Character> stack = new Stack<>();
       HashMap<Character,Integer> map = new HashMap<>();
       StringBuffer sb = new StringBuffer();
       int n = s.length();
       for(int i =0; i<n;i++){
           freq[s.charAt(i)-'a']+=1;
       }
       for(int i =0; i<n;i++){
           map.put(s.charAt(i),map.get(s.charAt(i))-1);
           while (!stack.isEmpty()&&!stack.contains(s.charAt(i))&&map.get(stack.peek)!=0) {
               if(stack.peek()<s.charAt(i)){
                   break;
               }
               System.out.println(stack.pop());
               System.out.println(stack);
           }
           if(!stack.contains(s.charAt(i))) {
               stack.push(s.charAt(i));
           }
           System.out.println(stack);
       }
       for(char c:stack){
           sb.append(c);
       }
       return sb.toString();
    }
    public static String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int len = word.length();
        int i = 0;
        boolean flag = false;
        while(i<len){
            stack.push(word.charAt(i));
            if(word.charAt(i)==ch){
                flag = true;
                break;
            }
            i++;
        }
        if(flag) {
            i+=1;
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            while (i < len) {
                sb.append(word.charAt(i));
                i++;
            }
        }else {
            for(int j = 0;j<len;j++){
                sb.append(word.charAt(j));
            }
        }
        return sb.toString();
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&st.peek()<=temperatures[i]){
                map.remove(st.pop());
            }
            if(!st.isEmpty()){
                result[i]=map.get(st.peek())-i;
            }else{
                result[i]=0;
            }
            st.push(temperatures[i]);
            map.put(temperatures[i],i);
        }
        return result;
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
//    public static boolean isValid(String s) {
//        Stack <Character> stack=new Stack<>();
//        int len=s.length();
//        boolean flag=true;
//        for(int i =0;i<len;i++){
//            if(s.charAt(i)=='{' || s.charAt(i)=='['||s.charAt(i)=='('){
//                stack.push(s.charAt(i));
//                flag=false;
//            }
//            if(s.charAt(i)=='}' || s.charAt(i)==']'||s.charAt(i)==')'){
//                if(stack.isEmpty())return false;
//                char temp=stack.peek();
//                if((temp=='{'&&s.charAt(i)=='}')||(temp=='['&&s.charAt(i)==']')||(temp=='('&&s.charAt(i)==')')){
//                    stack.pop();
//                    flag=true;
//                }else{
//                    return false;
//                }
//            }
//        }
//        if(!stack.isEmpty())return false;
//        if(!flag) return false;
//        return true;
//    }
}
