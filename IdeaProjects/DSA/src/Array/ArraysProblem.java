import MathsProblem.Maths;

import java.util.*;
import java.lang.Math;

public class ArraysProblem {
    public static void main(String[] args) {
//        String[] arr1 = {"eat","tea","tan","ate","nat","bat"};
        int[] arr2 = {4,1,2};
        int[] arr3 ={1,3,4,2};
        int[][] arr4 = {
                {3,2,1,0,-1},
                {-1,-2,-3,-4,-5}
        };
//        int[][]arr2 ={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        String a="3876620623801494171";
        String b = "6529364523802684779";
//        char[] arr = {'c','f','j'};
//        rotate(arr1,5);
//        System.out.println(String.valueOf(Long.parseLong(a) + Long.parseLong(b)));
        System.out.println(countNegatives(arr4));
    }
    public static int countNegatives(int[][] grid) {
        int n = grid.length;
        int n2 = grid[0].length;
        int ans =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<n2;j++){
                if(grid[i][j]<0){
                    ans++;
                }
            }
        }
        return ans;
    }
    public static int binarySearch(int[] matrix,int target){
        int len = matrix.length;
        int st=0;
        int end=len-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(matrix[mid]==target)return matrix[mid];
            if(matrix[mid]>target)end=mid-1;
            if(matrix[mid]<target)st=mid+1;
        }
        return -1;
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res =new int[nums1.length];
        HashSet<Integer> set = new HashSet<>();

        Arrays.sort(nums2);
        int n =nums1.length;
        int n2= nums2.length;
        int k = n2-1;
        int max = nums2[k];
        for(int i =0;i<n;i++){
            for(int j =0;j<n2;j++){
                if(nums1[i]==nums2[j]&&max>nums1[i]){
                    res[i]=max;
                    k--;
                    max=nums2[k];
                    break;
                }else{
                    if(max==nums1[i]){
                        k--;
                        max=nums2[k];
                        System.out.println(max);
                    }
                    res[i]=-1;
                }
            }
        }
        return res;
    }
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(1));
        int i = 1;
        while(i<=rowIndex){
            List<Integer> innerlist = new ArrayList<>();
            innerlist.add(1);
            for(int j=1;j<i;j++){
                innerlist.add(list1.get(i-1).get(j-1)+list1.get(i-1).get(j));
            }
            innerlist.add(1);
            list1.add(innerlist);
            i++;
        }
        return list1.get(rowIndex);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(1));
        if(numRows==1)return list1;
        for(int i = 1;i<numRows;i++){
            List<Integer> innerlist = new ArrayList<>();
            innerlist.add(1);
            for(int j=1;j<i;j++){
                innerlist.add(list1.get(i-1).get(j-1)+list1.get(i-1).get(j));
            }
            innerlist.add(1);
            list1.add(innerlist);
        }
        return list1;
     }
//    baki hai minimum cost prblm
    public static int minimumCost(int[] nums) {
        int n = nums.length;
        int cost = nums[0];
        int k=3;
        int sum=0;
        int i=0;
        while(i<k) {
            sum += nums[i];
            i++;
        }
        int ans = sum;
        while(i<n){
            sum=sum-nums[i-1]+nums[i];
            if(ans>sum){
                ans = sum;
            }
            i++;
        }
        return ans;
    }
    public static int getCommon(int[] nums1, int[] nums2) {
       int n1 = nums1.length;
       int n2 = nums2.length;
       int i =0;
       int j =0;
       while(i<n1&&j<n2){
           if(nums1[i]==nums2[j])return nums1[i];
           if(nums1[i]>nums2[j])j++;
           else if(nums1[i]<nums2[j])i++;
       }
       return -1;
    }

//    public static int getCommon(int[] nums1, int[] nums2) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int num: nums1){
//            set.add(num);
//        }
//        for(int num: nums2){
//            if (set.contains(num)) {
//                return num;
//            }
//        }
//        return -1;
//    }
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list =new ArrayList<>();
        if(n==0)return list;
        Map<Integer,Integer> map =new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>n/3 && !list.contains(num)){
                list.add(num);
            }
        }
        return list;
    }
//    part 2
    public static int[] intersection(int[] nums1, int[] nums2) {
       Map<Integer,Integer> map = new HashMap<>();
       for(int i: nums1){
               map.put(i,map.getOrDefault(i,0)+1);
       }
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int i =0;
       for(int num: nums2){
           if(map.containsKey(num)&&map.get(num)>0){
               temp[i] =num;
               map.put(num,map.getOrDefault(num,0)-1);
               i++;
           }
       }
       int[] res = new int[i];
       int j=0;
       while(j<res.length){
           res[j]=temp[j];
           j++;
       }
       return res;
    }
//    public static int[] intersection(int[] nums1, int[] nums2) {
//        HashSet<Integer> set = new HashSet<>();
//        HashSet<Integer> ans = new HashSet<>(0);
//        for (int num: nums1){
//            set.add(num);
//        }
//        for (int num:nums2){
//            if(set.contains(num)){
//                ans.add(num);
//            }
//        }
//        int[] res = new int[ans.size()];
//        int i =0;
//        for(Integer num:ans){
//            res[i] = num;
//            i++;
//        }
//        return res;
//    }
//    not solved
    public static int numRescueBoats(int[] people, int limit) {
        int i=0;
        int n=people.length;
        int j=i+1;
        int count =0;
        while (j < n) {
              int ans = people[i]+people[j];
              if(ans<=limit){
                i =j+1;
                j=i+1;
                count++;
              }else if(people[i]<people[j]){
                  j++;
                  count++;
              }else{
                  i=j+1;
                  count++;
              }
        }
        return count;
    }
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        int m =matrix.length;
//        int n = matrix[0].length;
//        int st =0;
//        int end = m-1;
//        while(st<=end){
//            int mid = st+(end-st)/2;
//            if(matrix[mid][0]<=target&&matrix[mid][n-1]>=target)return binarySearch(matrix[mid],target);
//            if(matrix[mid][0]>target)end=mid-1;
//            else st=mid+1;
//        }
//        return false;
//    }
//    public static boolean binarySearch(int[] matrix,int target){
//        int len = matrix.length;
//        int st=0;
//        int end=len-1;
//        while(st<=end){
//            int mid=st+(end-st)/2;
//            if(matrix[mid]==target)return true;
//            if(matrix[mid]>target)end=mid-1;
//            if(matrix[mid]<target)st=mid+1;
//        }
//        return false;
//    }
    public static boolean search(int[] nums, int target) {
        int st = 0;
        int right = nums.length-1;
        Arrays.sort(nums);
        while(st<=right){
            int mid = st+(right-st)/2;
            if(nums[mid]==target)return true;
            if(nums[mid]>target)right=mid-1;
            else st=mid+1;
        }
        return false;
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int i=n-1;
        int goal=n-1;
        while(i>=0){
            int max=nums[i];
            if(i+max>=goal) goal=i;
            i--;
        }
        if(goal==0)return true;
        else return false;
    }
    public  static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List> map = new HashMap<>();
        for(String arr: strs ){
            char[] arr1 = arr.toCharArray();
            Arrays.sort(arr1);
            String i = Arrays.toString(arr1);
            if(!map.containsKey(i)){
                map.put(i,new ArrayList<String>());
            }
            map.get(i).add(arr);
        }
        return new ArrayList(map.values());
    }
    public static int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length;
        int n2=capacity.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=apple[i];
        }
        Arrays.sort(capacity);
        int i=n2-1;
        int capSum=0;
        while(i>=0){
            capSum+=capacity[i];
            if(capSum>=sum){
                return n2-i;
            }
            i--;
        }
        return -1;
    }
    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int range=2*k+1;
        if(k==0)return nums;
        int[] res =new int[n];
        if(n<range){
            for(int i=0;i<n;i++){
                res[i]=-1;
            }
            return res;
        }
        long sum=0;
        for(int i=0;i<k;i++){
            res[i]=-1;
            sum+=nums[i];
        }
        sum+=nums[k];
        for(int i=k+1;i<range;i++)sum+=nums[i];
        res[k]=(int)(sum/range);
        int temp=range;
        int j=k+1;
        for(int p=0;p+range<n;p++){
            sum=nums[temp]+sum-nums[p];
            res[j]=(int)(sum/range);
            temp++;
            j++;
        }
        for(int i=j;i<n;i++)res[i]=-1;
        return res;
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int [] res=new int [n-k+1];
        if(k==1)return nums;
        int max=nums[0];
        for(int i =0;i<k;i++){
            max=Math.max(max,nums[i]);
        }
        res[0]=max;
        for(int i=1;i<=n-k;i++){
            if(nums[i-1]!=res[i-1]) {
                res[i] = Math.max(res[i-1],nums[i+k-1]);
            }else{
                int j=i+1;
                max=nums[i];
                while(j<i+k){
                    max=Math.max(max,nums[j]);
                    j++;
                    System.out.println(max);
                }
                res[i]=max;
            }
        }
        return res;
    }
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        int n=arr.length;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        if(sum/k>=threshold)count++;
        for(int i=1;i<=n-k;i++){
            sum=sum-arr[i-1]+arr[i+k-1];
            if(sum/k>=threshold)count++;
        }
        return count;
    }
//    public static int longestConsecutive(int[] nums) {
//       HashSet<Integer> set = new HashSet<>();
//       for(int num:nums){
//           set.add(num);
//       }
//       return 0;
//    }
//    public static int longestConsecutive(int[] nums) {
//        Arrays.sort(nums);
//        int i =0;
//        int j=i+1;
//        int n=nums.length;
//        if(n==0)return 0;
//        int count=1;
//        int ans=0;
//        while(j<n){
//            if(nums[i]==nums[j]){
//                i++;
//                j++;
//                continue;
//            }
//            if(nums[j]==nums[i]+1){
//                count++;
//            }else{
//                if(count>ans)ans=count;
//                count=1;
//            }
//            i++;
//            j++;
//        }
//        if(count>ans)ans=count;
//        return ans;
//    }
    public static int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int[] feq = new int[10000];
        for(int i=0;i<n;i++){
            int a = nums[i];
            feq[a]++;
            if(feq[a]>=n/2)return a;
        }
        return 0;
    }
//    public static int repeatedNTimes(int[] nums) {
//        int n = nums.length;
//        HashMap<Integer,Integer> map= new HashMap<>();
//        for(int i:nums){
//            map.put(i, map.getOrDefault(i, 0) + 1);
//            if(map.get(i)>=n/2) return i;
//        }
//        return -1;
//    }
//    public static int maxProfit(int[] prices) {
//        int maxProfit=0;
//        int min1= prices[0];
//        int min2=prices[0];
//        int ans=0;
//        int i=0;
//        while(i<prices.length){
//            if(prices[i]<min1) min1=prices[i];
//            if(prices[i]-min1>=maxProfit)maxProfit=prices[i]-min1;
//            if(prices[i]-maxProfit<min2)min2=prices[i]-maxProfit;
//            if(prices[i]-min2>=ans)ans=prices[i]-min2;
//            i++;
//        }
//        return ans;
//    }

//    122
//    public static int maxProfit(int[] prices) {
//        int maxProfit=0;
//        int min=prices[0];
//        int ans=0;
//        int i=0;
//        while(i<prices.length){
//            if(prices[i]<min){
//                min=prices[i];
//                i++;
//                continue;
//            }
//            if(prices[i]-min>=maxProfit){
//                ans+=prices[i]-min;
//                min=prices[i];
//                maxProfit=0;
//            }
//            i++;
//        }
//        return ans;
//    }
    public static int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int j=0;
        for(Integer i: map.keySet()){
            if(map.get(i)==1) {
                arr[j]=i;
                j++;
            }
        }
        return arr;
    }
//    public static int singleNumber(int[] nums) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int n = nums.length;
//        for(int i:nums){
//            map.put(i,map.getOrDefault(i,0)+1);
//        }
//        for(Integer i: map.keySet()){
//            if(map.get(i)==1) return i;
//        }
//        return 0;
//    }
    public static List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i:nums){
            if(map.contains(i)){
                list.add(i);
            }
            map.add(i);
        }
        return list;
    }
    public static int findMiddleIndex(int[] nums) {
        int n = nums.length;
        long total = 0;
       for(int i:nums)total+=i;
       total-=nums[0];
       long left=0;
        if(total==left)return 0;
       int i =1;
       while(i<n){
               left+=nums[i-1];
               total-=nums[i];
           if(total==left)return i;
           i++;
       }
       return -1;
    }
//    public static int[] decrypt(int[] code, int k) {
//        int n = code.length;
//       int[] arr = new int[n];
//       int sum=0;
//       if(n==1||k==0)return arr;
//       if(k<0) {
//           for (int i =n+k; i<n; i++) {
//               sum += code[i];
//           }
//           arr[0]=sum;
//           for(int i=1;i<n;i++){
//               sum=sum-code[(n+k+i-1)%n]+code[i-1];
//               arr[i]=sum;
//               System.out.println(code[i]+"--"+sum+"--"+code[(n+k+i-1)%n]);
//
//           }
//       }else {
//           for (int i = 1; i <= k; i++) {
//               sum += code[i];
//           }
//           arr[0]=sum;
//           for(int i=1;i<n;i++){
//               sum=sum+code[(i+k)%n]-code[i];
//               arr[i]=sum;
//               System.out.println(code[i]+"--"+sum+"--"+code[(i+k)%n]);
//           }
//       }
//
//       return arr;
//    }
//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int n = nums.length;
//        if(k==0)return false;
//        for(int i=0;i<n;i++){
//            if(map.containsKey(nums[i])){
//                int j = map.get(nums[i]);
//                if(i-j<=k){
//                    return true;
//                }
//            }
//            map.put(nums[i],i);
//        }
//        return false;
//    }
//    public static double findMaxAverage(int[] nums, int k) {
//        int n = nums.length;
//        int sum =0;
//        double max=0;
//        for(int i = 0;i<k;i++){
//            sum+=nums[i];
//        }
//        max=sum;
//        for(int i=1;i<=n-k;i++){
//            sum=sum-nums[i-1]+nums[i+k-1];
//            if(max<sum)max=sum;
//        }
//       return max/k;
//    }
//    public static int findMaxConsecutiveOnes(int[] nums) {
//        int i = 0;
//        int n = nums.length;
//        int per = 0;
//        int cur = 0;
//        while (i < n) {
//            if (nums[i] == 1) {
//                per++;
//                i++;
//            } else {
//                per = 0;
//                i++;
//            }
//            if (per > cur) {
//                cur = per;
//            }
//        }
//        return cur;
//    }
//    public static int minSubArrayLen(int target, int[] nums) {
//        int n=nums.length;
//        if(n==0)return 0;
//        int i=0;
//        int sum = 0;
//        int j=0;
//        int ans =Integer.MAX_VALUE;
//        boolean count=false;
//        while(j<n){
//            if(sum<target){
//                sum+=nums[j];
//                j++;
//            }
//            if(sum>=target) {
//                ans = Math.min(ans, j - i);
//                sum -= nums[i];
//                i++;
//                count = true;
//            }
//        }
//        while(i<n){
//            if(sum>=target){
//                ans = Math.min(ans,j-i);
//                sum-=nums[i];
//            }
//            i++;
//        }
//        if(!count)return 0;
//        return ans;
//    }
//    public static int[] twoSum(int[] nums, int target) {
//        HashMap<Integer,Integer> set = new HashMap<>();
//        for(int i = 0;i<nums.length;i++){
//            if(set.containsKey(target-nums[i]))return new int[]{set.get(target-nums[i]),i};
//            set.put(nums[i],i);
//        }
//        return new int[] {-1,-1};
//    }
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        if (n == 0) return;
//        k = k % n;
//        int[] arr = new int[n];
//        int j = n - 1;
//        int i = k - 1;
//
//        if (k < n) {
//            while (i >= 0) {
//                arr[i] = nums[j];
//                i--;
//                j--;
//            }
//            j = n - 1;
//            i = 0;
//            while (k <= j) {
//                arr[k] = nums[i];
//                i++;
//                k++;
//            }
//
//            int p = 0;
//            for (int temp : arr) {
//                nums[p] = temp;
//                p++;
//            }
//        }
//        System.out.println(Arrays.toString(nums)+"--"+i+"--"+j+"--"+k);
//    }
//    public static  int findDuplicate(int[] nums) {
//        int n = nums.length;
//        int i = 0;
//        int j = i+1;
//        Arrays.sort(nums);
//        while(i<n-1){
//            if(nums[i]!=nums[j]){
//                i++;
//                j++;
//                continue;
//            }else{
//                return nums[i];
//            }
//        }
//        return 0;
//    }
//    public static int countPartitions(int[] nums) {
//        int i=1;
//        int right=0;
//        int j = nums.length-1;
//        if(j==-1)return 0;
//        while(i<=j){
//            right+=nums[i];
//            i++;
//        }
//        i = 0;
//        int left = nums[i];
//        int count = 0;
//        while(i<=j-1){
//            if((right-left)%2==0) {
//                count++;
//            }
//            i++;
//            left+=nums[i];
//            right-=nums[i];
//        }
//        return count;
//    }
//    second method
//    public static void moveZeroes(int[] nums) {
//        int i = 0;
//        int j = 0;
//        int n = nums.length;
//        while(j<n){
//            if(nums[j]!=0){
//              nums[i]= nums[j];
//              i++;
//            }
//            j++;
//        }
//        while(i<n){
//            nums[i]=0;
//            i++;
//        }
//        System.out.println(Arrays.toString(nums));
//    }
//    public static void sortColors(int[] nums) {
//        int n = nums.length;
//        for (int i = 0; i<nums.length;i++){
//            for(int j =0;j+1<n-i;j++){
//                if(nums[j]>nums[j+1]){
//                    int temp = nums[j];
//                    nums[j]=nums[j+1];
//                    nums[j+1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//    }
//    public static int pivotIndex(int[] nums) {
//        int i = 0;
//        int rightSum = 0;
//        int leftSum =0;
//        for(int j = i+1;j<nums.length;j++){
//            rightSum+=nums[j];
//        }
//        while(i<=nums.length-1){
//            if(rightSum==leftSum){
//                return i;
//            }
//            if(i==nums.length-1){
//                return -1;
//            }
//            leftSum+=nums[i];
//            rightSum-=nums[i+1];
//            i++;
//        }
//        return -1;
//    }
//    public static char nextGreatestLetter(char[] letters, char target) {
//        int i = 0;
//        int j = letters.length-1;
//        while(i<=j){
//            if(letters[i]>=target){
//                return letters[i];
//            }
//            i++;
//        }
//        return letters[0];
//    }
    // first Method
//    public static void moveZeroes(int[] nums) {
//        int i =0;
//        int j =i+1;
//        int k = nums.length;
//        while(j<k){
//            if(nums[i]==0&&nums[j]==0){
//                j++;
//                continue;
//            }else if(nums[i]==0){
//              nums[i]= nums[j];
//              nums[j]= 0;
//            }
//            i++;
//            j++;
//        }
//        System.out.println(Arrays.toString(nums));
//    }
//    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
//        for(int i:nums) {
//        set.add(i);
//        }
//        int i =0;
//        int j =1;
//        while(i<nums.length){
//            if(!set.contains(j)){
//            list.add(j);
//            }
//            j++;
//            i++;
//        }
//        return list;
//    }
//    public static int maximumWealth(int[][] accounts) {
//        int max = 0;
//        int sum = 0;
//        for (int i =0;i<accounts.length;i++){
//            for(int j =0;j<accounts[i].length;j++){
//                sum+=accounts[i][j];
//                if(sum>max){
//                    max=sum;
//                }
//            }
//            sum =0;
//        }
//        return max;
//    }
//    2nd second step of 852(best step by binary search)
//    public static int peakIndexInMountainArray(int[] arr) {
//        int st =0;
//        int end = arr.length-1;
//        while(st<end){
//            int mid = (st+end)/2;
//            if(arr[mid]>arr[mid+1]){
//                end = mid;
//            }
//            if(arr[mid]<arr[mid+1]){
//                st = mid+1;
//            }
//        }
//        return st;
//    }
//   1st step of 852(best step brutforce technique)
//    public static int peakIndexInMountainArray(int[] arr) {
//        int i =0;
//        int j = i+1;
//        while(arr[i]<arr[j]){
//            if(arr[i]>arr[j]){
//                break;
//            }
//            if(j==arr.length-1){
//                return 0;
//            }
//            i++;
//            j++;
//        }
//        return i;
//    }
//My first hard problem  number 4
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        double[] merged=new double[nums1.length+nums2.length];
//        if(nums1.length==0&&nums2.length==0)return 0;
//        int i = 0;
//        int j=0;
//        while(i<merged.length){
//            if (i < nums1.length) {
//                merged[i]=nums1[i];
//            }else{
//                merged[i]=nums2[j];
//                j++;
//            }
//            i++;
//        }
//        Arrays.sort(merged);
//        i=0;j=merged.length-1;
//        if(merged.length%2!=0){
//            return merged[(i+j)/2];
//        }
//        while(i+1!=j){
//            i++;
//            j--;
//        }
//        return (merged[i]+merged[j])/2;
//    }
//    public static List<Integer> addToArrayForm(int[] num, int k) {
//        List<Integer> li = new ArrayList<>();
//        int i =num.length-1;
//        while(k>0||i>=0){
//            if(i>=0)k+=num[i];
//            li.add(0,k%10);
//            k/=10;
//            i--;
//        }
//        return li;
//    }
//    public static int[] arrayRankTransform(int[] arr) {
//        int[] nums = new int [arr.length];
//        int min = arr[0] ;
//        int temp=0;
//        int n = 0;
//        for(int i=0;i<arr.length;i++){
//            int min = arr[0] ;
//            System.out.println(min+"fu");
//            for(int j=0;j<arr.length;j++){
//                if(min>arr[j]&&temp!=arr[j]){
//                    min = arr[j];
//                    temp = min;
//                    nums[j]=n++;
//                    System.out.println(min+""+n);
//                }
//            }
//        }
//       System.out.println(min);
//        return nums;
//    }
//    public static long findTheArrayConcVal(int[] nums) {
//        int i = 0;
//        int j = nums.length - 1;
//        long result = 0;
//        while (i <= j) {
//            if (i != j) {
//                String s = String.valueOf(nums[i]) + String.valueOf(nums[j]);
//                result += Integer.parseInt(s);
//            }
//            if (i == j) {
//              result += nums[i] ;
//            }
//            i++;
//            j--;
//        }
//        return result;
//    }
//    public static int majorityElement(int[] nums) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i: nums){
//            int count = map.getOrDefault(i,0)+1;
//            map.put(i,count);
//            if(i==2){
//                System.out.println(count);
//            }
//        }
//        for (int i : nums) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        for (Integer key : map.keySet()) {
//            Integer value = map.get(key); // get value using current key
//            System.out.println("Key: " + key + ", Value: " + value);
//        }
//        return -1;
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    count++;
//                }
//            }
//            if (count > nums.length / 2) {
//                return nums[i];
//            }
//        }
//    }
//    public static int maxProfit(int[] prices) {
//        int maxProfit=0;
//        int min=prices[0];
//        int i=0;
//        while(i<prices.length){
//            if(prices[i]<min){
//                min=prices[i];
//                i++;
//                continue;
//            }
//            if(prices[i]-min>maxProfit){
//                maxProfit=prices[i]-min;
//            }
//            i++;
//        }
//        return maxProfit;
//    }
//    public static int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int i = 0;
//        int j = i + 1;
//
//        while (j < nums.length) {
//            if (nums[i] != nums[j]) {
//                return nums[i];
//            }
//            i += 2;
//            j = i + 1;
//        }
//        return nums[nums.length - 1];
//    }
//    public static int[] sortedSquares(int[] nums) {
//     int i = 0;
//     while (i<nums.length){
//         nums[i]=nums[i]*nums[i];
//         i++;
//     }
//        Arrays.sort(nums);
//     return nums;
//    }
//        public static boolean validMountainArray(int[] arr) {
//            int n = arr.length;
//            if (n < 3) return false;
//
//            int i = 0;
//
//            while (i + 1 < n && arr[i] < arr[i + 1]) {
//                i++;
//            }
//
//            if (i == 0 || i == n - 1) return false;
//            while (i + 1 < n && arr[i] > arr[i + 1]) {
//                i++;
//            }
//            return i == n - 1;
//        }
//    public static int[] searchRange(int[] nums, int target) {
//        int[] arr= {-1,-1};
//        int st = search(nums,target,true);
//        int end = search(nums,target,false);
//        arr[0] = st;
//        arr[1]= end;
//        return arr;
//    }
//
//    public static int search(int[] nums, int target,boolean findStindex) {
//        int ans = -1;
//        int st = 0;
//        int end = nums.length-1;
//        while(st<=end){
//            int mid = (st+end)/2;
//            if(nums[mid]==target){
//                ans = mid;
//                if(findStindex)end= mid-1;
//                else st= mid+1;
//            }
//            if(nums[mid]<target)st=mid+1;
//            if(nums[mid]>target)end=mid-1;
//        }
//        return ans;
//
//    }
//    public static int[] sortArrayByParityII(int[] nums) {
//       int i =0;
//       int pos = 0;
//       int neg = 1;
//       int[] arr = new int[nums.length];
//       while(i<nums.length){
//           if(nums[i]%2==0){
//               arr[pos] = nums[i];
//               pos +=2;
//               System.out.println(pos);
//           }else{
//           arr[neg] = nums[i];
//           neg+=2;
//           }
//           i++;
//       }
//       return arr;
//    }
//    public static boolean isPowerOfTwo(int n) {
//        long st = 0;
//        long end = n;
//        while(st<=end){
//            long mid = (st+end)/2;
//            if(Math.pow(2,mid)==n){
//                return true;
//            }
//            if(Math.pow(2,mid)<n)st=mid+1;
//            if(Math.pow(2,mid)>n)end=mid-1;
//        }
//        return false;
//    }
//    public static int[] sortArrayByParity(int[] nums) {
//        int i = 0;
//        int j = nums.length-1;
//        while(i<j){
//            if(nums[i]%2==0){
//                i++;
//                continue;
//            }
//            if(nums[j]%2==0){
//                int temp = nums[i];
//                nums[i]= nums[j];
//                nums[j]=temp;
//                i++;
//            }
//            j--;
//        }
//        return nums;
//    }
//    its is first step
//    public static int[] plusOne(int[] digits) {
//          int i = digits.length-1;
//          int count =0;
//          while(i>=0){
//              if(digits[i]==9){
//                  digits[i]=0;
//                  count++;
//              }else if(digits[i]!=9&&i>=0){
//                  digits[i]++;
//                  return digits;
//              }
//              i--;
//          }
//          if(count==digits.length){
//              int[] arr = new int[digits.length+1];
//              arr[0]=1;
//              return arr;
//          }
//          return digits;
//    }
//    its second step
//public static int[] plusOne(int[] digits) {
//    int temp=0;
//    int i=0;
//    while(i<=digits.length-1){
//        if(i== digits.length-1) digits[i]=digits[i]+1;
//        temp = digits[i]+temp*10;
//        i++;
//    }
//    i = digits.length-1;
//    while(temp!=0){
//        if(temp==10){
//            i = digits.length;
//            int[] nums = new int[i+1];
//            nums[0]= 1;
//            nums[i]=0;
//            return nums;
//        }
//        else{
//            digits[i]=temp%10;
//            temp = temp/10;
//            i--;
//        }
//    }
//    return digits;
//}
//    public static int missingNumber(int[] nums) {
//        Arrays.sort(nums);
//        int i = 0;
//        int j= nums[i];
//        while(i<nums.length){
//            if(nums[i]!=j){
//                return j;
//            }
//            i++;
//            j++;
//        }
//        if(nums.length!=nums[i-1]) return nums.length;
//        return 0;
//    }
//    public static boolean containsDuplicate(int[] nums) {
//      HashMap<Integer,Integer> map = new HashMap<>();
//     for(int i: nums){
//         int count = map.getOrDefault(i,0)+1;
//         map.put(i,count);
//         if(count==2)return true;
//     }
//        return false;
//    }
//    public static int singleNumber(int[] nums) {
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]!=nums[j] && j==nums.length-1) return nums[i];
//                if(nums[i]==nums[j]&&i==j+1) i=j+1;
//                if(nums[i]==nums[j])break;
//            }
//        }
//        return nums[nums.length-1];
//    }
//    public static int mySqrt(int x) {
//        long st=0;
//        long end = x;
//        while(st<=end){
//            long mid = st+(end-st)/2;
//            if(mid*mid==x){
//                return (int)mid;
//            }
//            else if(mid*mid>x){
//                end=mid-1;
//            }
//            else if(mid*mid<x){
//                st=mid+1;
//            }
//        }
//        return (int)end;
//    }
//    public static boolean isPerfectSquare(int num) {
//        if(num==1)return true;
//        long st=0;
//        long end = num;
//        while(st<=end){
//            long mid = st+(end-st)/2;
//            if(mid*mid==num){
//                return true;
//            }
//            else if(mid*mid>num){
//                end=mid-1;
//            }
//            else if(mid*mid<num){
//                st=mid+1;
//            }
//        }
//        return false;
//    }
//    public static int removeElement(int[] nums, int val) {
//        int i=0;
//        int j=0;
//        int k=1;
//        while(j<nums.length){
//            if(val==nums[j]){
//                i=j;
//                nums[k]=nums[i];
//                k++;
//            }
//            j++;
//        }
//        System.out.println(Arrays.toString(nums));
//        return j;
//    }
// 26 =>
//    public static int removeDuplicates(int[] nums) {
//        int i=0;
//        int j=i+1;
//        int k=1;
//        while(j<nums.length){
//            if(nums[i]!=nums[j]){
//                i=j;
//                nums[k]=nums[i];
//                k++;
//            }
//            j++;
//       }
//        j=k;
//        while(k<nums.length){
//          nums[k]=0;
//          k++;
//        }
//        System.out.println(Arrays.toString(nums));
//        return j;
//    }
// 1490 =>
//    public static int[] runningSum(int[] nums) {
//        int i = 1;
//        while(i<nums.length){
//            nums[i] = nums[i-1]+nums[i];
//            i++;
//        }
//        return nums;
//    }
//    public static int search(int[] nums, int target) {
//        int st = 0, end = nums.length - 1;
//        while (st <= end) {
//            int mid = (st + end) / 2;
//            if (nums[mid] == target) return mid;
//            if (nums[st] <= nums[mid]) {
//                if (nums[st] <= target && target < nums[mid]) {
//                    end = mid - 1;
//                } else {
//                    st = mid + 1;
//                }
//            } else {
//                if (nums[mid] < target && target <= nums[end]) {
//                    st = mid + 1;
//                } else {
//                    end = mid - 1;
//                }
//            }
//        }
//        return -1;
//    }
//        public static boolean  isPalindrome(int x) {
//           if(x<0)return false;
//        int n = 0;
//           int temp = x;
//            while (x != 0) {
//                n = n * 10 + x % 10;
//                x = x / 10;
//            }
//            if(n!=temp)return false;
//            return true;
//        }
// 1929 =>
//    public static int[] getConcatenation(int[] nums) {
//        int[] arr = new int[nums.length*2];
//      int i =0;
//      while(i<nums.length){
//          arr[i]=nums[i];
//          arr[i+nums.length]=nums[i];
//          i++;
//      }
//      return arr;
//    }
//  1920 =>
//    public static int[] buildArray(int[] nums) {
//       int[] arr = new int[nums.length];
//       int i=0;
//        while(i<nums.length){
//          arr[i] = nums[nums[i]];
//          i++;
//        }
//        return arr;
//    }
//258 =>
//   Second step public static int addDigits(int num) {
//        if(num==0)return 0;
//        if(num%9==0){
//            return 9;
//        }
//        return num%9;
//    }
//   First method => public static int addDigits(int num) {
//         int temp =0;
//         int n=0;
//        while (num!=0) {
//            temp = num % 10;
//            n = n + temp;
//            num = num / 10;
//        }
//        if(n<=9){
//            return n;
//        }
//       return addDigits(n);
//    }
    //  1 =>
//    static class Solution{
//        public int[] twoSum(int[] nums, int target) {
//         int i=0;
//         int j=nums.length-1;
//         while(i!=j){
//             if (nums[i]+nums[j]==target){
//                 return new int[]{i,j};
//             }
//             else if(nums[i]+nums[j]>target){
//                 j=j-1;
//             }else if(nums[i]+nums[j]<target){
//                 i=i-1;
//             }
//
//         }
//            return new int[]{};
//        }
//    }

}