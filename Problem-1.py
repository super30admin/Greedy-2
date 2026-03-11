# Time Complexity : O(n), n = number of tasks
# Space Complexity : O(1), fixed size array for 26 uppercase letters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Count frequency of each task.
# 2. The task with maximum frequency determines the skeleton of the schedule.
# 3. Use formula: (max_freq - 1) * (n + 1) + number of tasks with max_freq.
# 4. The answer is the maximum of total tasks and the skeleton length.

from typing import List
from collections import Counter

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = Counter(tasks)
        max_freq = max(count.values())
        max_count = sum(1 for v in count.values() if v == max_freq)
        return max(len(tasks), (max_freq - 1) * (n + 1) + max_count)