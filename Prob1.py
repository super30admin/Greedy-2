class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        task_freq_map = {}
        max_freq = max_count = 0
        for task in tasks:
            task_freq_map[task] = task_freq_map.get(task,0) + 1
            max_freq = max(max_freq,task_freq_map.get(task))
        
        for task,freq in task_freq_map.items():
            if freq == max_freq:
                max_count += 1
        
        partitions = max_freq - 1
        available = partitions * (n - (max_count - 1))
        pending = len(tasks) - (max_freq * max_count)
        idle = max(0,available-pending)
        
        return len(tasks) + idle
