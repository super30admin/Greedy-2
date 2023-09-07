// tc : O(nlog(n))
// sc : O(1) - not assuming the output size

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new peopleComaparator());
        List<int[]> result = new ArrayList<>();
        for(int[] pep : people)
            result.add(pep[1],pep);
        return result.toArray(new int[people.length][2]);
    }

    public class peopleComaparator implements Comparator<int[]> {
        public int compare(int[]a, int[]b){
            if(a[0]==b[0])
                return a[1]-b[1];
            return b[0]-a[0];
        }
    }
}
