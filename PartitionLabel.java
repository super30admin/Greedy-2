/**
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
 
time complexiy : O(N)
Space complexity: O(2*N)
IsWorked on Leetcode : YES

**/
class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> counter = new HashMap();
        
        for(Character c: S.toCharArray()) {
            counter.put(c, counter.getOrDefault(c,0)+1);
        }
        
               
        List<Integer> res = new ArrayList();
        StringBuilder sb= new StringBuilder();
        int oldSize = counter.size();
        Set<Character> set = new HashSet();
        for(Character ch : S.toCharArray()) {
            if(counter.containsKey(ch)) {
                int co = counter.get(ch);
                if(co == 1 ) {
                    counter.remove(ch);
                }else{
                    counter.put(ch, co-1);
                }
                sb.append(ch);
                set.add(ch);
                int currSize = counter.size();
                if(oldSize - currSize == set.size()) {
                    res.add(sb.toString().length());
                    set = new HashSet();
                    sb = new StringBuilder();
                    oldSize = counter.size();
                    currSize = counter.size();
                }
            }
            
        }
        return res;
    }
}
