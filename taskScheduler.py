class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        maxTaskCount = 0
        numMaxTasks = 0
        availableSlots = 0
        remainingTasks = 0
        idle = 0
        counts = collections.defaultdict(int)
        for task in tasks:
            counts[task] += 1
            if counts[task] > maxTaskCount:
                maxTaskCount = counts[task]
        
        for task, count in counts.items():
            if count == maxTaskCount:
                numMaxTasks += 1
            else:
                remainingTasks += count
        
        availableSlots = (maxTaskCount - 1) * (n - (numMaxTasks - 1))
        idle = max(0, availableSlots - remainingTasks)
        return (maxTaskCount * numMaxTasks) + idle + remainingTasks


        