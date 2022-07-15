#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        tasksCount = {}
        maxTask = 0
        count = 0 
        for task in tasks:
            if task not in tasksCount:
                tasksCount[task] = 0
            tasksCount[task] += 1
            maxTask = max(maxTask,tasksCount[task])
            
        for t in tasksCount:
            if tasksCount[t] == maxTask:
                count += 1

        partitions = maxTask - 1
        available = partitions * (n - (count - 1))
        pending = len(tasks) - maxTask * count
        idle = max(0, available - pending)
        
        return len(tasks) + idle
            
        