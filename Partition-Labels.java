## Problem3 Partition Labels (https://leetcode.com/problems/partition-labels/)

You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

 

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

//Brute force approach
In this we will use loop inside a loop and keep two variables start and end. Each time we will update end if we found the larger end
and once the outer loop index and end becomes equal that means that is the string which has no elements further so we will capture the length in result and update start to end+1
we will also update end = end+1

Time Complexity : O(n^2)
Space Complexity : O(1)

class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s==null || s.length()==0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int start=0;
        int end=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(s.charAt(j)==s.charAt(i)){
                    end=Math.max(end,j);
                }
            }
            if(i==end){
                result.add(end-start+1);
                start=end+1;
                end=end+1;
            }
        }
        return result;
    }
}

//Optimal solution
Now in above approach what were we doing we were tracking the index of last element occured so what if we maintain that in a hashmap
So hashmap will haye key as a character and a value as a last occurence index of that character

Time Complexity : O(n)
Space Complexity : O(1) -> Because the hashmap will hold at most 26 entries so constant

class Solution {
    public List<Integer> partitionLabels(String s) {
        //base condition
        if(s==null || s.length()==0){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),Math.max(map.get(s.charAt(i)),i));
            }else{
                map.put(s.charAt(i),i);
            }   
            
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " "+ entry.getValue());
        }
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
            end = Math.max(end,map.get(s.charAt(i)));
            if(i==end){
                result.add(end-start+1);
                start=end+1;
                end=end+1;
            }
        }
        return result;
    }
}