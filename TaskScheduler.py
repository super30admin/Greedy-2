"""
Approach:

The maximum number of tasks is 26. Let's allocate an array frequencies of 26 elements to keep the frequency of each task.

Iterate over the input array and store the frequency of task A at index 0, the frequency of task B at index 1, etc.

Find the maximum frequency: f_max = max(frequencies).

Find the number of tasks which have the max frequency: n_max = frequencies.count(f_max).

If the number of slots to use is defined by the most frequent task, it's equal to (f_max - 1) * (n + 1) + n_max.

Otherwise, the number of slots to use is defined by the overall number of tasks: len(tasks).

Return the maximum of these two: max(len(tasks), (f_max - 1) * (n + 1) + n_max).

TC: O(n)
SC: O(1)
"""

from collections import Counter
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if tasks == None or len(tasks) == 0:
            return 0
        
        maxFreq = 0
        maxCount = 0
        count = {}
        
        for i in range(len(tasks)):
            if tasks[i] not in count:
                count[tasks[i]] = 1
            else:
                cnt = count[tasks[i]]
                count[tasks[i]] = cnt + 1
                maxFreq = max(cnt + 1, maxFreq)
                
        for key in count.keys():
            if count[key] == maxFreq:
                maxCount += 1
                
        partitions = maxFreq - 1
        emptySlots = partitions * (n - maxCount + 1)
        pending = len(tasks) - (maxFreq * maxCount)
        idle = max(0 , emptySlots - pending) # 
        
        return len(tasks) + idle