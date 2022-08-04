//Time Complexity : O(NlogN)
 // Space Complexity : O(1)
public class QueueConstruction
{
    public int[][] reconstructQueue(int[][] people)
    {
        List<int[]> list = new ArrayList<>();

        /**
         * here sorting the input array such that the people greater height comes first
         * and if the height is same then sort according to the frequency
         */
        Arrays.sort(people, (a,b)-> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        for(int person[]: people) {
            list.add(person[1], person);
        }

        return list.toArray(people);
    }
}