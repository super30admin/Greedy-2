from collections import defaultdict
from typing import List


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        maxFreq = 0
        maxCount = 0
        c_tasks = defaultdict(int)
        for i in range(len(tasks)):
            c_tasks[tasks[i]] += 1
            maxFreq = max(maxFreq,c_tasks[tasks[i]])
        
        for val in c_tasks.values():
            if val == maxFreq:
                maxCount += 1
            
        partition = maxFreq - 1
        available_slots = partition * (n - (maxCount -1))
        pedingTasks = len(tasks) - maxFreq * maxCount
        idle = max(0,available_slots -  pedingTasks)
        return idle + len(tasks)





        







        
        
