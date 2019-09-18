import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//sort the height in desending order if height is not same. otherwise sort in ascending order by k
//then put it in list at index equal to k(no of person in front)
//note in list if adding element at index 2 then element which is already at index2 move to index3.

//time: O(nlogn)
	// space: O(n), for ArrayList
public class QueueRectruction {
	// time: O(nlogn)
	// space: O(n), for ArrayList
	public int[][] reconstructQueue(int[][] people) {

		// After sorting: [7,0],[7,1],[6,1],[5,0],[5,2],[4,4]
		// O(nlog(n))
		Arrays.sort(people, (a,b) -> (a[0] != b[0] ?   b[0] - a[0]:a[1] - b[1]));

		List<int[]> res = new ArrayList<>();
		// O(n^2)
		for (int[] p : people) {
			res.add(p[1], p);
		}

		return res.toArray(new int[0][]);
	}
		
		
		/*class Solution {
			  public int[][] reconstructQueue(int[][] people) {
			    Arrays.sort(people, new Comparator<int[]>() {
			      public int compare(int[] p1, int[] p2) {
			        return p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1];
			      }
			    });
			    List<int[]> res = new ArrayList<>();
			    for (int[] p: people) {
			      res.add(p[1], p);
			    }
			    return res.toArray(new int[people.length][]);
			  }
			}*/

}
