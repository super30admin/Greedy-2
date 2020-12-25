package Dec24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        
        /* Greedy approach::
         Note: Start placing people with maximum height  because it can be slided here and there without affecting other people.
         1st sorting: descending order of height
         2nd sorting: no.of people ahead of him
        
        Example:
        people array: [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        Arrays.sort: [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
        Place people at the index determined by the no.of people standing ahead of them in the resultant list, i.e. place [7,0] person at 0th index in the list, place [7,1] person at 1st index in the list, place [6,1] person at 1st index in the list (would involve shifting [7,1] person to 2nd index in the list. Such shifts could be for multiple people by multiple indexes and that is okay)..so on till end of sorted people array is reached. 
         
        */
        
        // time complexity: O(n^2)
        // space complexity: O(n) because we are using extra space of list of max size n.
        
        Arrays.sort(people, (a,b) -> {
          if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        }); // O(n log n)
        
        List<int[] > q = new ArrayList<>();
        
        for (int[] person: people ) {  // O(n^2) because for loop is O(n). Adding an element => shifting all other elements to correct positions implies O(n).
            q.add(person[1], person);
        }
        
        return q.toArray(new int[0][]);
        
    }
}