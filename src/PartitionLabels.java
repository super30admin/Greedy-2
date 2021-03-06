import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * Space complexity is O(1) 
 */

public class PartitionLabels {

	public List<Integer> partitionLabels(String S) {

		List<Integer> result = new ArrayList<>();

		if (S == null || S.length() == 0)
			return result;

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < S.length(); i++) {

			char c = S.charAt(i);

			map.put(c, i);

		}

		int start = 0;
		int end = 0;

		for (int i = 0; i < S.length(); i++) {

			char c = S.charAt(i);

			end = Math.max(end, map.get(c));

			if (end == i) {

				result.add(end - start + 1);
				start = i + 1;

			}
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
