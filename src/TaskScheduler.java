import java.util.HashMap;

/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * Space complexity is O(1) 
 */

public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {

		if (tasks == null || tasks.length == 0)
			return 0;

		HashMap<Character, Integer> map = new HashMap<>();
		int maxFreq = 0;
		int maxCount = 0;

		for (char c : tasks) {

			if (!map.containsKey(c)) {

				map.put(c, 0);

			}

			int cnt = map.get(c);
			cnt++;
			maxFreq = Math.max(maxFreq, cnt);
			map.put(c, cnt);

		}

		for (int val : map.values()) {

			if (val == maxFreq) {
				maxCount++;
			}
		}

		int partitions = maxFreq - 1;
		int empty = (n - (maxCount - 1)) * partitions;
		int available = tasks.length - maxFreq * maxCount;
		int idle = Math.max(0, empty - available);

		return tasks.length + idle;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
