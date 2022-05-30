// O(n^2) time: sorting takes O(n log n), insert n operations which takes O(k), summation is O(n^2)
// O(n) space for output

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        
        List<int[]> output = new LinkedList<>();
        for (int[] p: people){
            output.add(p[1], p);
        }
        
        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}