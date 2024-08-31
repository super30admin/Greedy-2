#// Time Complexity : O(N) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        maxfreq = 0
        max_count = 0
        dicti = {}
        for i in range(len(tasks)):
            if tasks[i] in dicti:
                dicti[tasks[i]] += 1
                maxfreq = max(maxfreq,dicti[tasks[i]])
            else:
                dicti[tasks[i]] = 1
        
        for i in dicti.values():
            if i == maxfreq:
                max_count += 1
     
        partition = maxfreq - 1
        available_slots  = partition * ( n - (max_count - 1))
        pending_slots = len(tasks) - (maxfreq * max_count)
        idle_slot = max(0,available_slots - pending_slots)

        return len(tasks) + idle_slot

# Approach:
# 1. Create a dictionary to store the frequency of each task.
# 2. Find the maximum frequency and the number of tasks with this frequency.
# 3. Calculate the number of partitions and available slots.
# 4. Calculate the number of pending slots.
# 5. Calculate the number of idle slots.
# 6. Return the total number of slots.

        
        