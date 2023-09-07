import java.util.*;

// problem link : https://leetcode.com/problems/partition-labels/description/
// optimized solution
// space complexity : O(1);
// time compplexity : O(n);
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0 ;i <s.length() ; i++)
            map.put(s.charAt(i), i);
        List<Integer> result = new ArrayList<>();
        int max = 0;
        int prev = -1;
        for(int i = 0 ;i<s.length(); i++){
            max = Math.max(max, map.get(s.charAt(i)));
            if(i==max){
                result.add(max-prev);  
                prev = max;
            }
        }
        return result;
    }
}


class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0 ;i <s.length() ; i++)
            map.put(s.charAt(i), i);

        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for(int i = 0 ;i<s.length(); i++){
            max = Math.max(max, map.get(s.charAt(i)));
            sb.append(s.charAt(i));
            if(i==max){
                result.add(sb.length());
                sb.setLength(0);
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0)+1);

        List<Integer> result = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        set.add(s.charAt(0));
        sb.append(s.charAt(0));
        for(int i = 1 ; i<s.length(); i++ ){
            char ch = s.charAt(i);
            if(set.size()==0){
                result.add(sb.length());
                sb.setLength(0);
            }
            sb.append(ch);
            set.add(ch);
            if(map.get(ch)==1){
                map.remove(ch);
                set.remove(ch);
            }
            else{
                map.put(ch, map.get(ch)-1);
            }
        }
        result.add(sb.length());
        return result;

    }
}
