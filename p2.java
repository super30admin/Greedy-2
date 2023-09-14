// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int[][] reconstructQueue(int[][] people) {
//Sort based on the height
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
        //Add to the list based on the number of people in front
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] p: people){   
            list.add(p[1], p);
        }

//convert list to array
        int[][] result = new int[people.length][2];
        int i=0;
        for(int[] p: list){   
            result[i] = p;
            i++;
        }
        return result;
    }
}