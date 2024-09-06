//Time = O(n^2), length of input array
//Space = O(n)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people in decreasing order of height and increasing order of k
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        List<int[]> queue = new ArrayList<>(); // list to store the reconstructed queue
        for (int[] person : people) {
            queue.add(person[1], person); // insert person at position k
        }
        
        int[][] result = queue.toArray(new int[queue.size()][]); // convert list to array
        return result;
    }
}
