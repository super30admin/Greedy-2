// 406.
// time - O(n^2)
// space - O(1)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //edge
        if(people == null || people.length == 0)
        {
            return new int[0][0];
        }
        //time - O(n logn) for sorting
        //sort people[] based on decreasing order of height, if same height then increasing order of number of people blocking the current person
        Arrays.sort(people, ((a, b) -> {
            if(a[0] == b[0])
            {
                return a[1] - b[1];
            }
            else
            {
                return b[0] - a[0];
            }
        }));
        ArrayList<int[]> result = new ArrayList<>();
        //time - O(n^2) for inserting at appropriate index
        //insert each person in the sorted people[] in the appropriate position in result list
        for(int[] person : people)
        {
            //add person[] at index person[1] of result list
            result.add(person[1], person);
        }
        return result.toArray(new int[0][]);
    }
}
