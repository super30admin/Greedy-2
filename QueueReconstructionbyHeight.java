// Time Complexity : O(n^2) // for asjusting arraylist for each insertion
// Space Complexity : O(n) // extra arraylist

/*
 * sort each element in decending order based on their own height.
 * if we find the same value then in acending order based on number
 * of people infornt of them. now add each person to arraylist based on
 * number of people ahead of them.
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return b[0] - a[0];
        });
        
        for(int[] person: people){
            result.add(person[1], person);
        }

        int[][] res = new int[people.length][];
        for(int i = 0; i < people.length; i++){
            res[i] = result.get(i);
        }

        return res;
    }
}