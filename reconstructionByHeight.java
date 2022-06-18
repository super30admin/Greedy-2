//TC : O(n2) bec of list insertion
//SC : O(1)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0) return new int[][]{};

        Arrays.sort(people,(a,b) ->{
            if(a[0] == b[0])
            {
                return a[1] - b[1];
            }

            return b[0] - a[0];
        });

        List <int[]>l = new ArrayList();

        for(int[] p : people)
        {
            l.add(p[1],p);
        }

        return l.toArray(new int[l.size()][]);
    }
}