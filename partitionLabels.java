// Time Complexity: O(N)
// Space Complexity: O(1)

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastOccurence = new int[26];
        for(int i=0; i < S.length(); i++)
        {
            char c = S.charAt(i);
            lastOccurence[c-'a']=i;
        }
        int k=0;
        List<Integer> result = new ArrayList<>();
        while(k<S.length())
        {
            int lastIndex = lastOccurence[S.charAt(k)-'a'];
            int start=k;
            while(k<=lastIndex)
            {
                lastIndex=Math.max(lastIndex, lastOccurence[S.charAt(k)-'a']);
                k++;
            }
            
            result.add(lastIndex-start+1);
        }
        return result;
    }
    
}