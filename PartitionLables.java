import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLables {
	public List<Integer> partitionLabels(String S) {

		List<Integer> result = new ArrayList<Integer>();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			Character ch = S.charAt(i);
			map.put(ch, i);

		}
		int start = 0;
		int end = 0;
		for (int i = 0; i < S.length(); i++) {
			Character ch = S.charAt(i);
			end = Math.max(end, map.get(ch));

			if (i == end) {
				result.add(end - start + 1);
				start = end + 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		PartitionLables l = new PartitionLables();
		System.out.println(l.partitionLabels("ababcbacadefegdehijhklij"));
	}
}
