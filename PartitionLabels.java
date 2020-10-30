/*
 * #763. Partition Labels
 * 
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".

This is a partition so that each letter appears in at most one part.

A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

1. S will have length in range [1, 500].
2. S will consist of lowercase English letters ('a' to 'z') only.

 */

/*
 * Time Complexity: O (N + N) = O (2N) = O (N) -> To traverse input string twice, once to fill the map, then to find partitions
 * 
 * Space Complexity: O (N) -> HashMap to store farthest index of 'N' characters in input string
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.greedy3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
        
        // #1. Base condition
        if(S == null || S.length() == 0){
            return new ArrayList<>();
        }
        
        // #2. Create a HashMap which will store the farthest point/index of each character in a string
        HashMap<Character, Integer> map = new HashMap<>();
        
        // #3. Create a output list
        List<Integer> output = new ArrayList<>();
        
        // #4. Traverse through the string and fill the map 
        for(int i = 0; i < S.length(); i++){ // O (N)
            char ch = S.charAt(i);
            
            map.put(ch, i);
            
        }
        
        // #5. Initialize the pointers
        // start -> start of a partition, end -> end of a partition, x -> traverse all characters of a string
        int start = 0;
        int end = 0;
        
        // #6. Traverse through the string again to form partitions such that each letter appears in at most one partition
        for(int x = 0; x < S.length(); x++){ // O (N)
            char ch = S.charAt(x);
            
            /*
            *   At each character while traversing, check if end pointer < farthest point/index of a character,
            *   If yes, then move the end pointer to that character's farthest index
            *   By moving the end pointer like this, we are trying to find partition from start to end pointers
            *   When x == end, meaning we have found a partition, get the size of partition and add to output list
            */
            // #6.1. move end to farthest point of a character
            if(end < map.get(ch)){
                end = map.get(ch);
            }
            
            
            // #6.2. If x == end, we found a partition
            if(x == end){
                // Get the size of partition and add to output list
                output.add(end - start + 1);
                // move the start pointer to 'x'th next character to find other partition
                start = x + 1;
                
            }
                
        }
        
        return output;
        
    }

}
