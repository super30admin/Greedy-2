# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks or len(tasks) == 0:
            return 0
        
        # find the frequency of the tasks and also the max frequency
        m = len(tasks)
        hashmap = {}
        max_freq = max_count = 0
        for i in range(m):
            if tasks[i] not in hashmap:
                hashmap[tasks[i]] = 0
            hashmap[tasks[i]] += 1
            max_freq = max(max_freq,hashmap[tasks[i]])
        
        # find the count of max frequency in the hashmao
        for keys in hashmap:
            if hashmap[keys] == max_freq:
                max_count += 1
        
        # find the partitions, that is available to fill the tasks after assigning the task with max frequency
        partition = max_freq - 1
        
        # available slots are partitions * the n value
        slots = partition * (n - (max_count - 1))
        
        # find the pending tasks after putting in the task with max frequency
        pending = m - (max_freq * max_count)
        
        # find empty slots
        empty = max(0,slots - pending)
        
        # return the total number of units required
        return m + empty
