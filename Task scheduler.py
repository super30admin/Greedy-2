#Time Complexity: O(n)
#Space Complexity: O(n)
from collections import Counter
class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        # Step 1: Count frequency of each task
        freq_map = Counter(tasks)
        
        # Step 2: Find the most frequent task count
        max_freq = max(freq_map.values())
        
        # Step 3: Count how many tasks have that max frequency
        max_count = list(freq_map.values()).count(max_freq)
        
        # Step 4: Apply the formula
        intervals = max(len(tasks), (max_freq - 1) * (n + 1) + max_count)
        
        return intervals
        