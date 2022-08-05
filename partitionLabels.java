// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {

    // greedy approch using map
    public static List<Integer> partitionLabels(String s) {
        // null case
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        int n = s.length();
        // map for storing ending index of each chars
        HashMap<Character, Integer> map = new HashMap<>();
        // first pass
        // store all the char's end index in the map
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        // in second pass we check maximum end index
        // if we found end index that is greater than current end index
        // we update end index here we also check if current pointer crosses
        // end index we update the start and put number of chars in the result
        List<Integer> result = new ArrayList<>();
        // to maintain start index and end index
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // update the end with maximum end of current char
            end = Math.max(end, map.get(c));
            // if my current pointer is at end of the index I will update the start index
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));

    }
}