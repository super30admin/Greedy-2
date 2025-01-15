# Explain your approach in brief:
# The problem is to calculate the minimum number of intervals required to complete all tasks
# with a cooling period `n` between tasks of the same type. 
# We calculate the frequency of each task and use this to determine the optimal order and spacing.

# Time Complexity: O(T + U), where T is the number of tasks and U is the number of unique tasks.
# Space Complexity: O(U), where U is the number of unique tasks.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # Count the frequency of each task
        task_counts = Counter(tasks)
        
        # Find the maximum frequency of any task
        max_freq = max(task_counts.values())
        
        # Count the number of tasks that have this maximum frequency
        max_count = list(task_counts.values()).count(max_freq)
        
        # Calculate the total intervals required:
        # (max_freq - 1) * (n + 1) is the framework that includes n cool-down intervals
        # max_count accounts for all tasks with maximum frequency filling the last row
        total_intervals = (max_freq - 1) * (n + 1) + max_count
        
        # The result is the maximum of the calculated intervals or the total number of tasks
        # because we can't have fewer intervals than the tasks themselves
        return max(total_intervals, len(tasks))
