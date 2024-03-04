// Time Complexity : O(N^2)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using Greedy, first sort the array based on heights or num of people if h is same.
//take a list, at each index of the list add the people array.

// 406. Queue Reconstruction by Height

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> { //nlog n
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        List<int []> q = new ArrayList<>();
        for(int [] person: people){ // O(n^2)
            q.add(person[1],person);
        }
        int [][] result = new int[people.length][2];
        for(int i=0;i < result.length;i++){
            result[i] = q.get(i);
        }
        return result;
    }
}