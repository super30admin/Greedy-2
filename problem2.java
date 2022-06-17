class queueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[][] {};
        
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
        List<int[]> result = new ArrayList();
        for(int[] person : people){
            result.add(person[1], person);
        }
        
        return result.toArray(new int[0][]);
    }
}
//time complexity O(n^2)
//space complexity O(1)