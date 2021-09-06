// Time Complexity : O(n), n -> Length of string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		List<Integer> ans = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return ans;
		}

		Map<Character, Integer> idxMap = new HashMap<Character, Integer>();

		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			idxMap.put(s.charAt(i), i);
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			end = Math.max(end, idxMap.get(ch));

			if (i == end) {
				ans.add(end - start + 1);
				start = i + 1;
			}
		}

		return ans;
	}

	private void print(List<Integer> partitions) {
		for (Integer partitionSize : partitions) {
			System.out.print(partitionSize + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PartitionLabels obj = new PartitionLabels();
		String str = "ababcbacadefegdehijhklij";

		List<Integer> partitions = obj.partitionLabels(str);

		System.out.print("Partition Sizes: ");
		obj.print(partitions);
	}

}
