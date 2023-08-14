// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: We iterate through the string twice:
// In the first loop, populate the map with characters and their last indices. In the second loop, update end with max last index, and when reaching the end of a partition, add its length to result, updating start.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabel {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PartitionLabel partitionLabel = new PartitionLabel();

        String s1 = "ababcbacadefegdehijhklij";
        System.out.println("Partition labels (s1): " + partitionLabel.partitionLabels(s1));

        String s2 = "abcbac";
        System.out.println("Partition labels (s2): " + partitionLabel.partitionLabels(s2));

        String s3 = "eccbbbbdec";
        System.out.println("Partition labels (s2): " + partitionLabel.partitionLabels(s3));
    }
}
