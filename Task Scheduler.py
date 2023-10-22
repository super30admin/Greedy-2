# Time Complexity : O(n)
# Space Complexity : O(n)
# The code ran on LeetCode

# Maintain the frequency map of the tasks. Combine the tasks with highest frequency, since they can be processed simultaneously. Fill the remaining spots in between these combined tasks with the remaining tasks (frequency != max frequency).


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        l = len(tasks)
        highest_freq = 0
        freq_map = {}
        for task in tasks:
            if task in freq_map:
                freq_map[task] += 1
            else:
                freq_map[task] = 1
            highest_freq = max(highest_freq, freq_map[task])

        combined = 0
        remaining = l
        for key in freq_map:
            if freq_map[key] == highest_freq:
                combined += 1
                remaining -= highest_freq
        
        spots = (n - combined + 1)*(highest_freq - 1)
        spots = max(0, spots - remaining)
        return spots + l
