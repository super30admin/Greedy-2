class QueueReconstructionByHeight {
    
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); // nlogn

        // n^2 -- because shifting performs n^2 operations here
        for(int[] p : people)
            result.add(p[1], p);
        
        return result.toArray(new int[people.length][2]);
    }
}