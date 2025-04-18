import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Get the last index of all characters in the string s.
 * 2. Find the max for each string range
 */

public class PartitionLabels {
    // ------------- Approach one - using hashmap ---------------
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }

    // ------------- Approach two - using int[] --------------
    public List<Integer> partitionLabels2(String s) {
        int[] lastIndex = new int[26]; // For 26 lowercase letters

        // Store the last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        // Your code here
    }
}