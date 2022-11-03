#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        countMap = {}
        max_freq = 0
        max_count = 0
        
        for i in range(len(tasks)):
            if tasks[i] in countMap:
                count = countMap[tasks[i]] + 1
                if count > max_freq:
                    max_freq = count
                countMap[tasks[i]] = count
            else:
                countMap[tasks[i]] = 1
        
        for value in countMap.values():
            if value == max_freq:
                max_count += 1
        
        partition_count = max_freq - 1
        empty_slots = (n - max_count + 1) * partition_count
        avail_slots = len(tasks) - (max_count * max_freq)
        idle = max(0, empty_slots - avail_slots)
        return len(tasks) + idle
                
        