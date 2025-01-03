// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem2 {
    //TC:O(nlogn + n^2)
    //SC:O(n)
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people,(a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else{
                return b[0]-a[0];
            }

        });//sort by decreasing order of height
        List<int[]> result = new ArrayList<>();
        //O(N)
        for(int i=0;i<n;i++){
            int[] person = people[i];
            int pplInFront = person[1];
            //place the person at the right position based on number of ppl are in pplInFront
            //ArrayList has to rearrange elements whenever we place the element at the current place
            //O(N)
            result.add(pplInFront,person);
        }

        return result.toArray(new int[0][0]);
    }
}
