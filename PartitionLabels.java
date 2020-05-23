//Time Complexity: O(n)
//Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() == 0) return result;
        int[] map = new int[26];
        int end = 0; int start = 0;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            map[c - 'a'] = i;
        }
        
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            end = Math.max(end, map[c - 'a']);
            if(end == i){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
    return result;
    }
}
