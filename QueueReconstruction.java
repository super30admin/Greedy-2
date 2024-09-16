/*
The time complexity is O(NlogN) and the space complexity is O(N) where N is the length of peple array.

Here the intuition is to add heights in the decreasing order since adding the elements of less height will not have any effect on the
previously added elements. For a particular height add the element to its kth index.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {

        //Sort the array according to our needs.
        Arrays.sort(people,new Comparator<int[]>(){

            @Override
            public int compare(int[] i1, int[] i2){
                return i1[0]==i2[0]?i1[1]-i2[1]:i2[0]-i1[0];
            }
        });


        List<int[]> ret = new ArrayList<>();

        //Add each to its kth index.
        for(int[] num:people){
            ret.add(num[1],num);
        }

        return ret.toArray(new int[people.length][2]);
    }
}