package Greedy2;

import java.util.ArrayList;
import java.util.List;

//Time complexity : O(n)
//Space complexity: O(1)
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int [] map = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map[c-'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();

        int partIdx = 0;
        int currIdx=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            partIdx = Math.max(map[c-'a'], partIdx);
            if(partIdx == i){
                ans.add(i-currIdx+1);
                currIdx = partIdx+1;
            }
        }
        return ans;
    }
}
