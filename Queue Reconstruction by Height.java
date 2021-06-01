//Time Complexity : O(n^2)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0){
            return new int[][]{};
        }
        //sort the given array in decending order of the heights
        Arrays.sort(people,(a,b)->{ //using comparator
            /*
            (a,b) ->{} is equal to a.compareTo(b){
            negative value: if a < b (here a should appear first)
            zero if a==b
            positive value : if a > b (here a should appear second)
            }
            */
            //if the heights are same, then sort by second index(other people in front)
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            //else sort by height
            return b[0]-a[0];
        });
        //use a list for easy add operation
        List<int[]> q = new ArrayList<>();
        //iterate through the array
        for(int person[] : people){
            //based on the kth value(second index) place each person
            q.add(person[1],person);
        }
        //convert the list into 2D array
        //the first dimension cant be left empty so its filled with 0
        return q.toArray(new int[0][]);
    }
}