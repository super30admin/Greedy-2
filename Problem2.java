// Time Complexity :O(nlogn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int[][] reconstructQueue(int[][] people) 
    {
        Arrays.sort(people, (a,b) -> {
            if(a[0]==b[0])
            {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        List<int []> li = new ArrayList<>();
        for(int [] person: people)
        {
            li.add(person[1], person);
        }
        int [][] result = new int [people.length][2];
        for(int i=0; i<result.length;i++)
        {
            result[i] = li.get(i);
        }
        return result;
    }
}
