// Time Complexity : 0(n^2) because putting element at given index of list takes n time, so Line 22-25 take n^2
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        //sort array in descending order of height
        //if height are equal then sort in ascending order of k-values
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        //iterate through people array
        for(int[] p : people){
            //put p at index p[1]
            output.add(p[1], p);
        }

        return output.toArray(new int[people.length][2]);
    }
}