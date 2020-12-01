class Solution {//Time of o(n^2) and space O(n)
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people , (a,b)-> a[0] == b[0] ? a[1]-b[1]:b[0]-a[0]);
        
        List<int[]> result = new ArrayList<>();
        
        for(int[] p:people){
            result.add(p[1],p);
        }
        System.out.print(people.length);
        return result.toArray(new int[0][]);
    }
}