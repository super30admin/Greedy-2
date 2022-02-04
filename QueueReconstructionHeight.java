// Time Complexity: O(nlogn) (sorting) + O(n*n) (traverse and arrange) -> O(n^2)
// Space Complexity: O(1) as constant 26 alphabets
public class QueueReconstructionHeight {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0)
            return new int[0][];
        
        // sort the people according to descending order heights
        // if the heights are same then sort asc order of number of people
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1]; // asc order of no of people before
            else
                return b[0] - a[0]; // desc of height
        });
        
        
        // add people in list according to number of people ahead of them
        List<int[]> result = new ArrayList<>();
        for(int [] person: people)
        {
            result.add(person[1], person); // add this person at the height location
        }
        
        return result.toArray(new int[0][]);
    }
}
