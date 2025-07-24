/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Approach make a map with last index of particular char
Time Complexity - O(N)
Space Complexity - O(1)
 */

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_LC_763 {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        List<Integer> result = new ArrayList<>();
        int end = 0,start = 0;
        for(int i = 0; i<s.length(); i++) {
            map[s.charAt(i)-'a'] = i; //this will automatically update last index of particular character
        }
        for(int i = 0 ;i < s.length(); i++) {
            end = Math.max(end, map[s.charAt(i) - 'a']); // we will take max index for upcoming characters
            if( i == end){ //when current index matches with end(max index of char we have reached the partition add it to result)
                result.add(end - start + 1);
                start = i + 1; // update my next partition
            }
        }
        return result;
    }
}
