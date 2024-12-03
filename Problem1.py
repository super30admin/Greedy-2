# Problem 1: Task Scheduler
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        Map = {}
        result = 0
        maxTaskValue = 0
        maxFreq = 0
        
        for task in tasks:
            Map[task] = Map.get(task,0) + 1

        for c in Map:
            maxTaskValue = max(maxTaskValue,Map[c])
        
        for c in Map:
            if Map[c] == maxTaskValue:
                maxFreq += 1

        partitions = maxTaskValue - 1
        avalaible_slots = partitions * (n - (maxFreq - 1))
        pending = len(tasks) - (maxTaskValue * maxFreq)
        idle = max(0,avalaible_slots - pending)

        return len(tasks) + idle



        
        
        