// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(1) since the map will have at most 26 characters

import java.util.ArrayList;
import java.util.List;

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map[ch-'a'] = i;
        }
        int end = 0, start = 0;;
        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, map[s.charAt(i)-'a']);

            if(i == end){
                res.add(end-start+1);
                start = i+1;
            }
        }
        return res;
    }
}