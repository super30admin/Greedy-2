class ReconstructQueue {
    //time: O(n^2) since list has to rearranged for each n insertions
    //space: O(n)
    //did it run successfully on leetcode: yes
    public int[][] reconstructQueue(int[][] people) {
        //sorting array in decreasing order of height and if height is same then on increasing order of number of person infront
        Arrays.sort(people, (a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        
        //List to strore resultant array
        List<int[]> res = new ArrayList<>();
        //looping through the sorted person array
        for(int[] person: people){
            //add each person to the index which is equal to number of person infront
            res.add(person[1], person);
        }
        //return the result
        return res.toArray(new int[0][]);
            
    }
}