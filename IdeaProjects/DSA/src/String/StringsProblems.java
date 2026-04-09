package String;

import java.util.Arrays;
import java.util.HashMap;
import java.lang.StringBuilder;
import java.util.HashSet;


public class StringsProblems {
    public static void main(String[] args) {
        String s = "0";
        String s1 = "01";
//        String[] s = {"cba","efg","dgi"};
        System.out.println(addBinary(s,s1));
    }
    public static  String addBinary(String a, String b) {
        int num1 = Integer.parseInt(a);
        int num2 =Integer.parseInt(b);
        int carry =0;
        boolean temp = false;
        StringBuilder sb = new StringBuilder();
        while(num1!=0||num2!=0){
            int sum = num1%10+num2%10+carry;
            if(sum==0){
                sb.insert(0,"0");
                carry=0;
            }
            else if(sum==1){
                sb.insert(0,"1");
                carry=0;
            }
            else if(sum==2){
                sb.insert(0,"0");
                carry=1;
            }
            else if(sum==3){
                sb.insert(0,"1");
                carry=1;
            }
            num1=num1/10;
            num2=num2/10;
            temp=true;
        }
        if((a.length() >= 0 || b.length() >= 0)&&!temp) {
                sb.insert(0, "0");
        }
        if(carry==1)sb.insert(0,"1");
        return sb.toString();
    }
//    not done this prblm
    public static String removeDuplicateLetters(String s) {
        HashSet<Character> set = new HashSet<>();
        int i=s.length();
        for(int j =0;j<i;j++){
            set.add(s.charAt(j));
        }
        StringBuilder sb = new StringBuilder();
        for(char k: set){
            sb.append(k);
        }
        return sb.toString();
    }
    public static int maxPower(String s) {
       int n = s.length();
       int ans =0;
       int curr = 1;
       for(int i=1;i<n;i++){
           if(s.charAt(i-1)==s.charAt(i)){
               curr++;
           }else{
               if(curr>ans)ans=curr;
               curr=1;
           }
       }
       if(curr>ans)ans=curr;
        return ans;
    }
//    public static int maxPower(String s) {
//        char[] sb = s.toCharArray();
//        int i =0;
//        int j = i+1;
//        int n = sb.length;
//        int curr = 0;
//        int ans =1;
//        while(j<n){
//            if(sb[i]==sb[j]&&sb[i] >= 'a' && sb[i] <= 'z'){
//                curr++;
//            }else{
//                curr+=1;
//                if(curr>ans)ans=curr;
//                curr=0;
//            }
//            j++;
//            i++;
//        }
//        curr+=1;
//        if(curr>ans)ans=curr;
//        return ans;
//    }
//    public static boolean isPalindrome(String s) {
//        StringBuilder sb = new StringBuilder(s.trim().toLowerCase().replace(" ", ""));
//        int i =0;
//        int j = sb.length()-1;
//        if(j<0)return true;
//        while(i<j){
//            if(!Character.isLetterOrDigit(sb.charAt(i))){
//                i++;
//                continue;
//            }
//            if(!Character.isLetterOrDigit(sb.charAt(j))){
//                j--;
//                continue;
//            }
//            if(sb.charAt(i)!=sb.charAt(j)){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//    public static int lengthOfLongestSubstring(String s) {
//        HashSet<Character> set = new HashSet<>();
//        int len =0;
//        int n = s.length();
//        int i =0;
//        int j = 0;
//        while(j<n){
//            if(!set.contains(s.charAt(j))){
//                set.add(s.charAt(j));
//                j++;
//            }else {
//                len = Math.max(len, j - i);
//                set.remove(s.charAt(i));
//                i++;
//            }
//        }
//        len = Math.max(len, j - i);
//        return len;
//    }
//    public static String addBinary(String a, String b) {
//        int i = a.length()-1;
//        int j = b.length()-1;
//        int carry = 0;
//        StringBuilder ans = new StringBuilder();
//        while(i>=0&&j>=0){
//            if(a.charAt(i)!=b.charAt(j)&&carry==0){
//                ans.append('1');
//            }
//           else if(a.charAt(i)!=b.charAt(j)&&carry==1){
//                ans.append('1');
//                carry = 1;
//            }
//            else if(a.charAt(i)==0&&b.charAt(j)==0&&carry==0){
//                ans.append('0');
//            }
//            else if(a.charAt(i)==1&&b.charAt(j)==1&&carry==0){
//                ans.append('0');
//            }
//            i--;
//            j--;
//        }
//        return ans.toString();
//    }
//    public static boolean isAnagram(String s, String t) {
//      HashMap<Character,Integer> map = new HashMap<>();
//      HashMap<Character,Integer> map2 = new HashMap<>();
//      int j = s.length();
//      int k = t.length();
//      if(j!=k)return false;
//      for(int i =0; i<j;i++){
//          map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
//          map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
//      }
//      if(map.equals(map2)){
//          return true;
//      }
//      return false;
//    }
//    public static int strStr(String haystack, String needle) {
//        if(haystack.length()<needle.length()){
//            return -1;
//        }
//        int i = 0;
//        int j=0;
//        int count =0;
//        while (i < haystack.length()) {
//            if (haystack.charAt(i) == needle.charAt(j)) {
//                i++;
//                j++;
//                if (j == needle.length()) {
//                    return count;
//                }
//            }else{
//            count++;
//            i = count;
//            j = 0;
//            }
//        }
//        return -1;
//    }
//    public static String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) return "";
//
//        String prefix = strs[0];
//
//        for (int i = 1; i < strs.length; i++) {
//            while (!strs[i].startsWith(prefix)) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) return "";
//            }
//        }
//
//        return prefix;
//    }

//    public static int lengthOfLastWord(String s) {
//        int len = s.length()-1;
//        int count = 0 ;
//        while(len>=0&&s.charAt(len)==' '){
//         len--;
//        }
//        while(len>=0&&s.charAt(len)!=' '){
//            len--;
//            count++;
//        }
//        return count;
//    }
}