
//Time Complexity: O(n^2) in worst case for inserting elements in list
//Space Complexity: O(n) for the result list

//We use greedy approach to solve this problem.
//The idea is to first sort the people in descending order of height.
//If two people have the same height, we sort them in ascending order of the number of people in front of them.
//This way, when we insert them into the result list, we can be sure that the taller people are already in the list.
//So, when we insert a person at the index equal to the number of people in front of them, 
//we can be sure that there are enough taller people in front of them.

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //sort in dec height if same height inc order of no of people
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return b[0]-a[0];
        });
        List<int[]> res=new ArrayList<>();
        //Then we insert each person at the index equal to how many taller or equal people 
        // should be in front of them.
        for(int p[]:people){
            res.add(p[1],p);
        }
        return res.toArray(new int[res.size()][2]);
    }
}