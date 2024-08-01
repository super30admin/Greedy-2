# Time Complexity : O(m), where m is the length of the tasks array
# Space Complexity : O(1)
class Solution:
    def least_interval(self, tasks, n):
        if not tasks:
            return 0
        
        task_counts = [0] * 26  # Maintains count of tasks for all 26 capital letters
        for task in tasks:
            task_counts[ord(task) - ord('A')] += 1  # Calculates the frequency of each task
        
        task_counts.sort()  # Sort the counts to find the maximum frequency
        max_freq = task_counts[25]  # This gives the max frequency since the array is sorted
        idle_time = (max_freq - 1) * n  # Initial idle time based on the max frequency
        
        for i in range(24, -1, -1):
            if task_counts[i] > 0:
                idle_time -= min(task_counts[i], max_freq - 1)  # Reduce idle time as we fill it with other tasks
        
        if idle_time > 0:
            return idle_time + len(tasks)
        
        return len(tasks)

# Instantiate the Solution class
solution = Solution()

# Example 1
tasks1 = ['A', 'A', 'A', 'B', 'B', 'B']
n1 = 2
print("Result 1:", solution.least_interval(tasks1, n1))  # Output: 8

# Example 2
tasks2 = ['A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D', 'D']
n2 = 2
print("Result 2:", solution.least_interval(tasks2, n2))  # Output: 10

# Example 3
tasks3 = ['A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E']
n3 = 2
print("Result 3:", solution.least_interval(tasks3, n3))  # Output: 12