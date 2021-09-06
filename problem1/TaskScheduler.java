// Time Complexity : O(n), n -> Length of tasks
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		if (tasks == null || tasks.length == 0) {
			return 0;
		}

		if (n == 0) {
			return tasks.length;
		}

		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		int maxFreq = 0;
		int maxCnt = 0;

		for (char ch : tasks) {
			int cnt = freqMap.getOrDefault(ch, 0);
			cnt++;
			maxFreq = Math.max(maxFreq, cnt);
			freqMap.put(ch, cnt);
		}

		for (char key : freqMap.keySet()) {
			if (freqMap.get(key) == maxFreq) {
				maxCnt++;
			}
		}

		int partitions = maxFreq - 1;
		int availableSlots = partitions * (n - (maxCnt - 1));
		int pendingTasks = tasks.length - (maxFreq * maxCnt);
		int idleTime = Math.max(0, availableSlots - pendingTasks);

		return tasks.length + idleTime;
	}

	public static void main(String[] args) {
		TaskScheduler obj = new TaskScheduler();
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;

		System.out.println("Minimum time: " + obj.leastInterval(tasks, n));
	}

}
