import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class PartitionLabels {
    class Solution {
        public List<Integer> partitionLabels(String S) {
            if(S == null || S.length() == 0) return null;

            List<Integer> outputArray = new ArrayList<>();

            //create array to store the last index of each characted in S
            int[] lastIndices = new int[26];
            for (int i = 0; i < S.length(); i++) {
                lastIndices[S.charAt(i) - 'a'] = i;
            }

            //determine start and end of partition
            int start=0, end=0;
            for (int i = 0; i < S.length(); i++) {
                end = Math.max(end, lastIndices[S.charAt(i)-'a']);
                if(i == end){
                    outputArray.add(end-start+1);
                    start = end +1;
                }
            }
            return outputArray;
        }
    }
}
