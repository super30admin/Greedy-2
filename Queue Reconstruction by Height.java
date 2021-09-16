class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people , (int[] a,int[] b) -> a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);

        List<int[]> res = new ArrayList<>();

        for(int[] ppl : people)
        {
            res.add(ppl[1] , ppl);
        }

        return res.toArray(new int[people.length][]);

    }
}
