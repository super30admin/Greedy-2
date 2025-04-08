class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        //nlogn
        Arrays.sort(people, (a,b) ->{
            if(a[0] == b[0])
            {
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        //n
        for(int[] person: people)
        {
            res.add(person[1], person); //n
        }
        
        return res.toArray(new int[0][]);
    }
}

//tc: O(n^2)
//SC: O(n)
