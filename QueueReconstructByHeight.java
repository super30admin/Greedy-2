import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity : O(n^2)
//Space Complexity : O(n)
public class QueueReconstructByHeight {	
	/**Approach: Greedy**/
	public int[][] reconstructQueue(int[][] people) {
        List<int[]> res= new ArrayList<>();
        //Arrange in decreasing order of height. If height is same then increasing order of people in front of them.
        Arrays.sort(people, (a,b)->{ //O(n log n)
            if(a[0] == b[0]) return a[1]-b[1];
            return b[0] - a[0];
        });
        
        //Start from front and insert at the index as same as people in front of them.
        for(int[] person: people){//O(n)
            res.add(person[1], person); //O(n)
        }
        return res.toArray(people);
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		QueueReconstructByHeight ob  = new QueueReconstructByHeight();		
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		System.out.println("Reconstructed queue: "+Arrays.deepToString(ob.reconstructQueue(people)));
	}
}
