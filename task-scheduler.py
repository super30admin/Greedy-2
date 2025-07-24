# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks:
            return 0
        
        # Count frequency of each task
        task_counts = Counter(tasks)
        
        # Get the maximum frequency
        max_freq = max(task_counts.values())
        
        # Count how many tasks have the maximum frequency
        max_freq_count = sum(1 for count in task_counts.values() if count == max_freq)
        
        # Calculate minimum intervals needed
        # Formula: (max_freq - 1) * (n + 1) + max_freq_count
        # This accounts for:
        # - (max_freq - 1) complete cycles of length (n + 1)
        # - max_freq_count tasks in the final cycle
        min_intervals = (max_freq - 1) * (n + 1) + max_freq_count
        
        # The answer is the maximum of:
        # 1. The calculated minimum intervals
        # 2. The total number of tasks (in case n is very small)
        return max(min_intervals, len(tasks))
        