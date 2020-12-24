// O(NlogN) since I am sorting the array
// SC: O(1) for constant space
import java.util.*;

public class queueReconstruction {

	public int[][] reconstructionQueue(int[][] people){
		
		// We know that we need to sort by height and number of people, if the height is same, we need to sort the array in such a way that
		// we have the less number of people with less heights in ascending order, if the height is not same, we need to sort the array in descending order of the height
		// in our result, we can just keep updating our result for that particular number of ppl, add the complete ppl array
		// So, this way, we are keeping all the same number of ppl  and adding it in ascending order and keeping height as well in ascending order
		Arrays.sort(people, (int[] o1, int[] o2)-> (o1[0]==o2[0])? o1[1]-o2[1]: o2[0]- o1[0]);
		List<int[]> res = new LinkedList<>();
		
		for(int[] ppl: people) {
			
			int k = ppl[1];
			res.add(k, ppl);
		}
		return res.toArray(new int[people.length][]);
	}
}
