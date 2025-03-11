import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TC: O(n) as all the characters in the string
// TC: O(n) as Map has been used to save the last indexes for each characters

// Runs successfully on Leetcode
// Last indexes for each charactered is associated in the map, 
// an endMax variable is updated until the current index is equal to endMax.
// If it matches, the length is added in the result list
public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij")); // [9,7,8]
        System.out.println(partitionLabels("eccbbbbdec")); // [10]
    }

    private static List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int endMax = 0;
        for (int i = 0; i < s.length(); i++) {
            endMax = Math.max(endMax, map.get(s.charAt(i)));
            if (i == endMax) {
                result.add(endMax - start + 1);
                start = endMax + 1;
            }
        }
        return result;
    }
}