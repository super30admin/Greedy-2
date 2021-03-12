//Problem 141: Partition Labels
// Time Complexity :O(2N)=>O(N)
// Space Complexity :O(1), because there will be only 26 characters

// Your code here along with comments explaining your approach
/* Brute Force Intuition: create all possible partitions and check whether characters are unique. This will be exponential
   Optimized: Greedy: 
   build the hashmap with key as the character and value as the last occurance of this char in the given array
   Next will go on traversing the given array and for each char get its last occurance and extend the window if incoming character end is greater than the existing end.
   If all the occurances of each char in the string are within that window then the partition is added to the resultant list and start from the next char which is current index +1 or end+1;
*/

import java.util.*;
class Solution141 {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> result = new ArrayList<>();
        //TC:O(n) || SC: O(unique characters) or O(1) because of 26 characters only
        if(S==null || S.length()==0) return result;
        
        Map<Character,Integer> map = new HashMap<>();
        //save last index
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            map.put(ch,i);
        }
        
        int start = 0;
        int end   = 0;
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            end = Math.max(end,map.get(ch));
            
            if(i==end){//we founnd the partition
                result.add(end-start+1);
                start = i+1;//or end+1;
            }
        }
        
        return result;
    }
}